package jp.co.nss.hrm.backend.common.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
public @interface OperationLogAnnotationIndex {
    String operaModel() default ""; // 操作模块

    String operaType() default "";  // 操作类型

    String operaDesc() default "";  // 操作说明
}
