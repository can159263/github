package cn.szboc.platform.component.msgbean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.szboc.platform.component.msgbean.enhance.ICustomGetConvertor;
import cn.szboc.platform.component.msgbean.interseptor.AfterGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeGetInterceptor;

/**
 * 自定义转换
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MessageGetEnhance {

    Class<? extends BeforeGetInterceptor>[] beforeGet() default {};

    Class<? extends AfterGetInterceptor>[] afterGet() default {};

    Class<? extends ICustomGetConvertor> convertor() default ICustomGetConvertor.class;

}
