package cn.szboc.platform.component.msgbean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.szboc.platform.component.msgbean.enhance.ICustomSetConvertor;
import cn.szboc.platform.component.msgbean.interseptor.AfterSetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeSetInterceptor;

/**
 * 自定义转换
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MessageSetEnhance {

    Class<? extends AfterSetInterceptor>[] afterSet() default {};

    Class<? extends BeforeSetInterceptor>[] beforeSet() default {};

    Class<? extends ICustomSetConvertor> convertor() default ICustomSetConvertor.class;

}
