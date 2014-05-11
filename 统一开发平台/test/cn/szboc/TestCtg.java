package cn.szboc;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szboc.platform.component.ctg.withSpring.CtgMessageSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class TestCtg {

    public static javax.resource.cci.Connection conn;

    @Autowired
    @Qualifier("platformCtgMessageSender")
    private CtgMessageSender ctgMessageSender;

    @Test
    public void test1() {

        String send = "000400178360000000009880800                    20120322091611                                                                                                                                                                                                                                               745857970567             1        ";
        System.out.println("send length: " + send.length());

        try {
            byte[] x = ctgMessageSender.execute(send.getBytes("GBK"));
            System.out.println(x.length);
            System.out.println(new String(x));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset());
        
        String zc = "正常";
        System.out.println(zc.getBytes());
        
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-config/PlatformApplicatonContext-ext.xml");
        CtgMessageSender ctgMessageSender = ctx.getBean("platformCtgMessageSender", CtgMessageSender.class);

        String account = "741957970563";
        
//        String send = "000400178360000000009880800                    20120322091611                                                                                                                                                                                                                                               "
//                + account + "          00110       ";
        
        String send = "000440029100000000009880800                    20101210                                                                                                                                                                                                                                                     762757970564                   ";
        System.out.println("send length: " + send.length());
        System.out.println("send       : " + send);

        try {
            byte[] x = ctgMessageSender.execute(send.getBytes("GBK"));
            System.out.println("---------");
            System.out.println("recv length: " + x.length);
            System.out.println("recv       : " + new String(x, "GBK"));
//            byte[] xx = new byte[20];
//            System.arraycopy(x, 398, xx, 0, 20);
//            System.out.println(new String(xx));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
