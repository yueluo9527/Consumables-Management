package jp.co.nss.hrm.backend.api.aop.annotation;

import java.lang.annotation.*;

/**
 * @author lyz
 * @title: OperationLog
 * @projectName springcloud
 * @date 2020/9/23
 * @description: 自定义操作日志注解
 */
@Target(ElementType.METHOD)//注解放置的目标位置即方法级别
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented
public @interface OperationLogAnnotation {
    String operaModule() default ""; // 操作模块

    String operaType() default "";  // 操作类型

    String operaDesc() default "";  // 操作说明
}
