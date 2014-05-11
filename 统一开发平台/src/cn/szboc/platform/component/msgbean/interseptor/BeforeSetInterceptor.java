package cn.szboc.platform.component.msgbean.interseptor;

import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;

/**
 * 写前置拦截器
 */
public interface BeforeSetInterceptor {

    /**
     * 在byte[]转成属性之前对数据进行预处理
     * 
     * @param data
     * @param fieldTranslateProperty
     * @return
     * @throws MsgBeanConvertException
     */
    public byte[] beforeSetToProperty(byte[] data, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException;
}
