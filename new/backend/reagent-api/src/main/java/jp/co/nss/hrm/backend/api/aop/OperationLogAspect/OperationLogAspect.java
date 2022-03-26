package jp.co.nss.hrm.backend.api.aop.OperationLogAspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.common.util.RequestUtil;
import jp.co.nss.hrm.backend.mapper.ReagentOperationLogMapper;
import jp.co.nss.hrm.backend.model.ReagentOperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Aspect
@Component
public class OperationLogAspect {
    @Autowired
    private ReagentAdminDao adminDao;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;
    @Autowired
    private ReagentOperationLogMapper operationLogMapper;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 设置操作日志切入点   在注解的位置切入代码
     */
    @Pointcut("@annotation(jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation)")
    public void operaLogPointCut() {

    }

    /**
     * 记录操作日志
     *
     * @param joinPoint 方法的执行点
     * @param result    方法返回值
     * @throws Throwable
     */
    @AfterReturning(returning = "result", value = "operaLogPointCut()")
    public void saveOperaLog(JoinPoint joinPoint, Object result) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        //将结果转化为json格式
        String jsonResult = JSONObject.toJSONString(result);
        try {
            //将json格式返回值转换成map集合
            Map map = JSON.parseObject(jsonResult, Map.class);
            ReagentOperationLog operationLog = new ReagentOperationLog();
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();
            //获取操作
            OperationLogAnnotation annotation = method.getAnnotation(OperationLogAnnotation.class);
            if (annotation != null) {
                operationLog.setModule(annotation.operaModule());
                operationLog.setOperaLog(annotation.operaDesc());
            }
            //操作时间
            operationLog.setCreateTime(Timestamp.valueOf(sdf.format(new Date())));
            //操作用户
            operationLog.setUserName(request.getRemoteUser());
            //操作IP
            operationLog.setIp(RequestUtil.getRequestIp(request));
            //返回值信息
            operationLog.setResult((String) map.get("message"));
            //URL地址
            operationLog.setUrl(request.getRequestURL().toString());
            //操作方法
            operationLog.setMethod(request.getMethod());
            //用户ID
            Long adminId = adminDao.selectByUser(request.getRemoteUser());
            Long roleId = adminRoleDao.selectByAdmin(adminId);
            operationLog.setUserId(roleId);

            //System.out.println("operationLog11:" + operationLog);
            assert annotation != null;
            if (!annotation.operaDesc().equals("新增")) {
                String operaId;

                Object[] pointValues = joinPoint.getArgs();
                String arrValue = Arrays.toString(pointValues);

                if (((String) map.get("message")).contains("成功")) {

                    String demo = arrValue.substring(1, arrValue.length() - 1);
                    String[] splitValues = demo.split(",");

                    //操作对象ID
                    if (annotation.operaDesc().startsWith("新增")) {
                        operaId = splitValues[1].substring(4);
                    } else {
                        operaId = splitValues[0];
                    }
                    if (!annotation.operaDesc().equals("一键导入")) {
                        //操作对象ID
                        operationLog.setOperaId(operaId);
                        //请求参数
                        operationLog.setOperaParams(arrValue);
                    }
                }
            }
            //保存日志
            operationLogMapper.insertSelective(operationLog);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
