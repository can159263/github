package cn.szboc.platform.commons.thread.annotation;
import java.lang.annotation.*;

/**
 * 该注解标识了某个类或者接口是非线程安全的,不建议调用程序在多线程环境下并发的调用这些类的引用
 * 
 * @see ThreadSafe
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotThreadSafe {
}
