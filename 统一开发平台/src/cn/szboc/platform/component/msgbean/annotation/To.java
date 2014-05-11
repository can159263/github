package cn.szboc.platform.component.msgbean.annotation;

/**
 * 某bean与byte[]的转换方向
 */
public enum To {
    
    /**
     * 只支持byte[]->bean的转换
     */
    TO_BEAN,
    
    /**
     * 只支持bean->byte[]的转换
     */
    TO_BYTES, 
    
    
    /**
     * 双向都支持
     */
    BOTH;
}
