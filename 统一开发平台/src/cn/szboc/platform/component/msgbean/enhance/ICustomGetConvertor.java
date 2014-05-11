package cn.szboc.platform.component.msgbean.enhance;

import cn.szboc.platform.component.msgbean.annotation.PadType;

/**
 * 自定义转换接口
 */
public interface ICustomGetConvertor {
    
    /**
     * 从property到byte[]的转换
     * @param value
     * @param length
     * @param material
     * @param type
     * @return
     */
    public byte[] convert(Object value, int length, byte material, PadType type);
    
    
    /**
     * 从byte[]到property的转换
     * @param data
     * @param length
     * @param material
     * @param type
     * @return
     */
    public Object convert(byte[] data, int length, byte material, PadType type);
    
}
