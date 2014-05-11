package cn.szboc.platform.component.msgbean;

import java.math.BigDecimal;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageSetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(Target = To.BOTH, ExpectedReadSize = 20, ExpectedWriteSize = 20)
public class TestInnerBean {

    private String field1;
    private BigDecimal bd;

    @MessageField(startPos = 0, length = 5)
    public String getField1() {
        return field1;
    }

    @MessageField(startPos = 0, length = 5)
    public void setField1(String field1) {
        this.field1 = field1;
    }

    @MessageField(startPos = 5, length = 15, type = PadType.LEFT, material = 48)
    public BigDecimal getBd() {
        return bd;
    }

    @MessageField(startPos = 5, length = 15, type = PadType.LEFT, material = 48)
    @MessageSetEnhance(beforeSet=TestBeforeSet.class)
    public void setBd(BigDecimal bd) {
        this.bd = bd;
    }

    public static void main(String[] args) throws Exception {
        MessageBeanCotext ctx = new MessageBeanCotext(TestInnerBean.class);
        
        TestInnerBean bean1 = new TestInnerBean();
        bean1.setField1("111");
        bean1.setBd(new BigDecimal("123456.78"));

        byte[] data = ctx.marshal(bean1);

        System.out.println(new String(data, "GBK"));
        
        //data = "111  00000123456.78-".getBytes();
        
        System.out.println(new String(data, "GBK"));
        
        TestInnerBean bean2 = ctx.unMarshal(data, TestInnerBean.class);

        System.out.println(bean2.getBd().toPlainString());

    }

}
