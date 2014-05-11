package cn.szboc.transaction;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.modules.parameter.domain.ParameterItemType;
import cn.szboc.platform.modules.parameter.domain.SystemParameterItem;
import cn.szboc.platform.modules.parameter.service.SystemParamterService;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class TestTransaction extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("systemParameterService")
	private SystemParamterService paramService;
	
	@Test
	public void test() {
		SystemParameterItem item = new SystemParameterItem();
		item.setQname("SYSTEM.KUAIPAY.DISPATCH.TEST");
		item.setPackageName("SYSTEM.KUAIPAY.DISPATCH");
		item.setItemName("TEST");
		item.setItemDesc("...");
		item.setItemDisplayName("测试参数");
		item.setItemType(ParameterItemType.PARAMETER);
		item.setLastUpdateDate(new Timestamp(new Date().getTime()));
		item.setLastUpdateUser("邢路");
		item.setParamValue("test");
		
		paramService.insertParameterItem(item);
		paramService.deleteParameterItem("SYSTEM.KUAIPAY.DISPATCH.TEST");
		System.out.println("删除成功");
	}

}
