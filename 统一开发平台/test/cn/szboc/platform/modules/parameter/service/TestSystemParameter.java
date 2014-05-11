package cn.szboc.platform.modules.parameter.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szboc.platform.exception.PlatformRtException;
import cn.szboc.platform.modules.parameter.SystemParameterHelper;
import cn.szboc.platform.modules.parameter.dao.SystemParameterDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class TestSystemParameter {

    @Autowired()
    @Qualifier("systemParameterService")
    private SystemParamterService systemParameterService;

    @Test
    public void testCheckParameterExist() {
        try {
            Assert.assertEquals(false, systemParameterService.checkItemExist("UNIFORM.REQUEST.LISTEN.PORT"));
            Assert.assertEquals(true, systemParameterService.checkItemExist("SYSTEM.KUAIPAY.DISPATCH.MONITOR.TRANSACTION.LSTN_PORT"));
            Assert.assertEquals("15000", systemParameterService.getParameterItem("SYSTEM.KUAIPAY.DISPATCH.MONITOR.TRANSACTION.LSTN_PORT")
                    .getParamValue());
            Assert.assertEquals("127.0.0.1", SystemParameterHelper.getInstance().getParamValue("SYSTEM.KUAIPAY.DISPATCH.MONITOR.TRANSACTION.LSTN_IP"));
            Assert.assertEquals("127.0.0.1", SystemParameterHelper.getParam("SYSTEM.KUAIPAY.DISPATCH.MONITOR.TRANSACTION.LSTN_IP"));
        } catch (PlatformRtException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        try {
            SystemParameterHelper.getParam("SYSTEM.KUAIPAY.DISPATCH.MONITOR.TRANSACTION");
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getCause().getClass());
            Assert.assertEquals("该条目为包(没有值),不是参数!", e.getCause().getMessage());
        }
        try {
            SystemParameterHelper.getParam("xxx");
        } catch (Exception e) {
            Assert.assertEquals(PlatformRtException.class, e.getClass());
            Assert.assertEquals("参数查询异常", e.getMessage());
        }
    }

    
    @Test
    public void test(){
    	SystemParameterDao dao1 = systemParameterService.getParameterDao();
    	SystemParameterDao dao2 = systemParameterService.getParameterDao();
    	System.out.println(dao1==dao2);
    }
}
