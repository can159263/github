package cn.szboc.platform.component.msgbean;

import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.BeforeGetInterceptor;

public class TestBeforeGet implements BeforeGetInterceptor {

    @Override
    public Object beforeGetToBytes(Object value, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {
        return "2222";
    }

}
