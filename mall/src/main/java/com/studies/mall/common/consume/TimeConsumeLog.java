package com.studies.mall.common.consume;

import java.lang.annotation.*;

/**
 * @date : 2020/7/24 10:44
 * 记录方法执行时间注解
 *  自己调用自己请使用 通过暴露代理类方式调用
 *  ((ClearServiceImpl)AopContext.currentProxy()).testAOP1();
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeConsumeLog {

    /**
     * 方法描述
     * @return
     */
    String methodDesc() default "";
}