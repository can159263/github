package cn.szboc.platform.component.msgbean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.charset.Charset;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MessageBean {

    /**
     * byte[]和bean的转换方向
     * 
     * @return
     */
    To Target() default To.BOTH;

    /**
     * 转换的字符集
     * 
     * @return
     */
    MsgCharset Charset() default MsgCharset.GB18030;

    /**
     * byte[]->message时的要求byte数组的总长度
     * 
     * @return
     */
    int ExpectedReadSize() default -1;

    /**
     * message->byte[]时的得到的byte数组的总长度
     * 
     * @return
     */
    int ExpectedWriteSize() default -1;

    
    public enum MsgCharset {

        /**
         * GBK编码
         */
        GBK,

        /**
         * GBK的超集,支持更多的字符集
         */
        GB18030,

        /**
         * UNICODE的一种编码
         */
        UTF8,

        /**
         * UNICODE的一种编码
         */
        UTF16,

        /**
         * UNICODE的一种编码
         */
        UTF32,

        /**
         * 台湾地区使用的繁体字编码
         */
        BIG5,

        /**
         * 欧美地区使用的单字节字符集
         */
        ISO8859_1;

        /**
         * 返回指定字符集
         * 
         * @return
         */
        public Charset getCharset() {
            return Charset.forName(this.name());
        }
    }
}
