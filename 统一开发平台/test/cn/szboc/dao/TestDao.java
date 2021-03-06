package cn.szboc.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szboc.platform.modules.parameter.service.SystemParamterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class TestDao {

	@Autowired()
	@Qualifier("systemParameterService")
	private SystemParamterService systemParameterService;

}
