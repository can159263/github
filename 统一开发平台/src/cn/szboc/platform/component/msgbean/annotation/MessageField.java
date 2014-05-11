package cn.szboc.platform.component.msgbean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对某个set/get方法进行标注,方便后续与byte[]转换时进行信息提取
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageField {

    /**
     * 相对于字节数组的从0开始的下标
     * 
     * @return
     */
    int startPos();

    /**
     * 该字段的长度
     * 
     * @return
     */
    int length();

    /**
     * 填充类型,默认右填充,
     * 当该字段是数值时,通常应该将该属性设置为左填充
     * 
     * @return
     */
    PadType type() default PadType.RIGHT;

    /**
     * 填充的字节的ASCII码,默认用半角空格(32)填充,数字一般使用0(ascii码为48)填充.
     * 
     * @return
     */
    byte material() default 32;

}
