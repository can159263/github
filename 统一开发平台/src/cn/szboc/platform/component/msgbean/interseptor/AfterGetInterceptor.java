package cn.szboc.platform.component.msgbean.interseptor;

import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;

/**
 * get-后置拦截器
 */
public interface AfterGetInterceptor {

    /**
     * byte[]转换之后重新进行调整
     * @param data
     * @param fieldTranslateProperty
     * @return
     * @throws MsgBeanConvertException
     */
    public byte[] afterGetToBytes(byte[] data, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException;
}
