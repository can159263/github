package cn.szboc.platform.component.msgbean;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.enhance.ICustomGetConvertor;
import cn.szboc.platform.component.msgbean.enhance.ICustomSetConvertor;
import cn.szboc.platform.component.msgbean.interseptor.AfterGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.AfterSetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeSetInterceptor;

/**
 * 代表某一字段的property<-->byte[]相互转换的特性
 */
public class FieldTranslateProperty implements Comparable<FieldTranslateProperty> {

    /**
     * 属性名称
     */
    private String name;

    /**
     * 该字段的起始位置
     */
    private int startPos;

    /**
     * 该字段的长度
     */
    private int length;

    /**
     * 该字段的填充类型
     */
    private PadType padType;

    /**
     * 该字段的填充物
     */
    private byte material;

    /**
     * 字符集
     */
    private Charset charset;

    /**
     * 字段类型
     */
    private Class<?> fieldClass;

    // 四种拦截器

    private List<BeforeGetInterceptor> beforeGetInterceptors;
    private List<AfterGetInterceptor> afterGetInterceptors;
    private List<BeforeSetInterceptor> beforeSetInterceptors;
    private List<AfterSetInterceptor> afterSetInterceptors;

    // 一个自定义转换器
    private ICustomGetConvertor getConvetor;
    private ICustomSetConvertor setConvetor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public PadType getPadType() {
        return padType;
    }

    public void setPadType(PadType padType) {
        this.padType = padType;
    }

    public byte getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = (byte) material;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public Class<?> getFieldClass() {
        return fieldClass;
    }

    public void setFieldClass(Class<?> fieldClass) {
        this.fieldClass = fieldClass;
    }

    public List<BeforeGetInterceptor> getBeforeGetInterceptors() {
        return beforeGetInterceptors;
    }

    public void addBeforeGetInterseptor(BeforeGetInterceptor interseptor) {
        if (beforeGetInterceptors == null) {
            beforeGetInterceptors = new ArrayList<BeforeGetInterceptor>();
        }
        beforeGetInterceptors.add(interseptor);
    }

    public List<AfterGetInterceptor> getAfterGetInterceptors() {
        return afterGetInterceptors;
    }

    public void addAfterGetInterseptor(AfterGetInterceptor interseptor) {
        if (afterGetInterceptors == null) {
            afterGetInterceptors = new ArrayList<AfterGetInterceptor>();
        }
        afterGetInterceptors.add(interseptor);
    }

    public List<BeforeSetInterceptor> getBeforeSetInterceptors() {
        return beforeSetInterceptors;
    }

    public void addBeforeSetInterseptor(BeforeSetInterceptor interseptor) {
        if (beforeSetInterceptors == null) {
            beforeSetInterceptors = new ArrayList<BeforeSetInterceptor>();
        }
        beforeSetInterceptors.add(interseptor);
    }

    public List<AfterSetInterceptor> getAfterSetInterceptors() {
        return afterSetInterceptors;
    }

    public void addAfterSetInterseptor(AfterSetInterceptor interseptor) {
        if (afterSetInterceptors == null) {
            afterSetInterceptors = new ArrayList<AfterSetInterceptor>();
        }
        afterSetInterceptors.add(interseptor);
    }

    public ICustomGetConvertor getGetConvetor() {
        return getConvetor;
    }

    public void setGetConvetor(ICustomGetConvertor getConvetor) {
        this.getConvetor = getConvetor;
    }

    public ICustomSetConvertor getSetConvetor() {
        return setConvetor;
    }

    public void setSetConvetor(ICustomSetConvertor setConvetor) {
        this.setConvetor = setConvetor;
    }

    @Override
    public int compareTo(FieldTranslateProperty prop) {
        return this.getStartPos() - prop.getStartPos();
    }
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder("字段描述特性如下:")
    		.append("属性名称:").append(this.name)
    		.append(",对应字节长度:").append(this.length)
    		.append(",填充起始坐标:").append(this.startPos)
    		.append(",填充字节的ASCII码为:").append(this.material);
    	return builder.toString();
    }
}
