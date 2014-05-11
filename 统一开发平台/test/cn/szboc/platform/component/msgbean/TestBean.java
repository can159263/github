package cn.szboc.platform.component.msgbean;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageBean.MsgCharset;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(Target = To.BOTH, Charset = MsgCharset.GB18030, ExpectedReadSize = 20, ExpectedWriteSize = 20)
public class TestBean extends TestInnerBean{

    private String outterField;
    
    private int hahah;

    private TestInnerBean innerBean;
    
    @MessageField(startPos = 10, length = 5, type = PadType.LEFT, material = 48)
    public int getHahah() {
        return hahah;
    }

    @MessageField(startPos = 10, length = 5, type = PadType.LEFT, material = 48)
    public void setHahah(int hahah) {
        this.hahah = hahah;
    }

    @MessageField(startPos = 5, length = 5, type = PadType.RIGHT, material = 32)
    public String getOutterField() {
        return outterField;
    }

    @MessageField(startPos = 5, length = 5, type = PadType.RIGHT, material = 32)
    public void setOutterField(String outterField) {
        this.outterField = outterField;
    }
    
    
    @MessageField(startPos = 15, length = 5, type = PadType.RIGHT, material = 32)
    public TestInnerBean getInnerBean() {
        return innerBean;
    }
    
    @MessageField(startPos = 15, length = 5, type = PadType.RIGHT, material = 32)
    public void setInnerBean(TestInnerBean innerBean) {
        this.innerBean = innerBean;
    }

    public static void main(String[] args) throws Exception {
        
        String s = new String(new byte[0]);
        
        MessageBeanCotext context = new MessageBeanCotext(TestBean.class, TestInnerBean.class);
        
        TestBean testBean = new TestBean();
        testBean.setOutterField("12345");
        testBean.setHahah(999);
        testBean.setField1("abc");
        
        TestInnerBean innerBean = new TestInnerBean();
        innerBean.setField1("xxx");
        
        testBean.setInnerBean(innerBean);
        
        byte[] bytes = context.marshal(testBean);
        System.out.println(bytes.length);
    }
}
