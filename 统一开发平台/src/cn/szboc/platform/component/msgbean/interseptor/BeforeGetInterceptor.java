package cn.szboc.platform.component.msgbean.interseptor;

import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;

/**
 * 读前置拦截器
 */
public interface BeforeGetInterceptor {
   
    /**
     * 在属性转成byte数组之前对值进行处理
     * @param value
     * @param fieldTranslateProperty
     * @return
     * @throws MsgBeanConvertException
     */
    public Object beforeGetToBytes(Object value, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException;
}
