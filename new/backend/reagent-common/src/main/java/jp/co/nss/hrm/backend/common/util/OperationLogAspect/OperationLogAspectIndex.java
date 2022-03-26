package jp.co.nss.hrm.backend.common.util.OperationLogAspect;

import jp.co.nss.hrm.backend.common.domain.WebLog;
import jp.co.nss.hrm.backend.common.util.RequestUtil;
import jp.co.nss.hrm.backend.common.util.annotation.OperationLogAnnotationIndex;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/*import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.mapper.ReagentOperationLogMapper;*/

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class OperationLogAspectIndex {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 设置操作日志切入点   在注解的位置切入代码
     */
    @Pointcut("@annotation(jp.co.nss.hrm.backend.common.util.annotation.OperationLogAnnotationIndex)")
    public void operaLogPointCut() {

    }

    @AfterReturning(returning/**
     * 记录操作日志
     * @param joinPoint 方法的执行点
     * @param result  方法返回值
     * @throws Throwable
     */ = "result", value = "operaLogPointCut()")
    public void saveOperaLog(JoinPoint joinPoint, Object result) {
       /* @Autowired
        private ReagentAdminDao adminDao;
        @Autowired
        private ReagentAdminRoleRelationDao adminRoleDao;
        @Autowired
        private ReagentOperationLogMapper operationLogMapper;*/

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        /*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("username");
        System.out.println("user:" + user);*/

        try {
            //将返回值转换成map集合
            //Map<String, String> map = (Map<String, String>) result;
            WebLog operationLog = new WebLog();
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();
            //获取操作
            OperationLogAnnotationIndex annotation = method.getAnnotation(OperationLogAnnotationIndex.class);
            if (annotation != null) {
                operationLog.setModule(annotation.operaModel());
                operationLog.setType(annotation.operaType());
                operationLog.setOperaLog(annotation.operaDesc());
            }
            //操作时间
            operationLog.setCreateTime(Timestamp.valueOf(sdf.format(new Date())));
            //操作用户
            operationLog.setUsername(request.getRemoteUser());
            //操作IP
            operationLog.setIp(RequestUtil.getRequestIp(request));
            //返回值信息
            //operationLog.setResult(map.get("message"));
            //URL地址
            operationLog.setUrl(request.getRequestURL().toString());
            //操作方法
            operationLog.setMethod(request.getMethod());
            //用户ID
            /*Long adminId = adminDao.selectByUser(request.getRemoteUser());
            Long roleId = adminRoleDao.selectByAdmin(adminId);
            operationLog.setUserId(roleId);*/

            //保存日志
            //operationLogMapper.insert(operationLog);

            System.out.println("result:" + result);
            System.out.println("Test:" + operationLog);
            System.out.println("URL:" + request.getRequestURL());
            System.out.println("method:" + request.getMethod());
            System.out.println("username:" + request.getRemoteUser());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
