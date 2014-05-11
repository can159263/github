package cn.szboc.platform.component.msgbean.interseptor;

import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;

/**
 * set-后置拦截器
 */
public interface AfterSetInterceptor {

    /**
     * 值设置完之后重新进行调整
     * 
     * @param value
     * @param fieldTranslateProperty
     * @return
     * @throws MsgBeanConvertException
     */
    public Object afterSetToProperty(Object value, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException;

}
