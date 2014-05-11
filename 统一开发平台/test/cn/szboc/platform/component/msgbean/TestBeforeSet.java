package cn.szboc.platform.component.msgbean;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.BeforeSetInterceptor;

public class TestBeforeSet implements BeforeSetInterceptor {

    @Override
    public byte[] beforeSetToProperty(byte[] data, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {
        
        // 去除右边的空白和+号
        byte[] rtn = ByteUtils.rightTrim(ByteUtils.rightTrim(data, (byte)32),(byte)'+');
        
        // 如果最后边有-号,则去除左边的0和右边的'-'
        if(rtn[rtn.length - 1] == '-'){
            rtn = ByteUtils.rightTrim(rtn, (byte)'-');
            rtn = ByteUtils.leftTrim(rtn, (byte)'0');
            // 然后左补'-'
            return ByteUtils.byteJoin(new byte[]{'-'}, rtn);
        }
        
        return rtn;
        
    }

}
