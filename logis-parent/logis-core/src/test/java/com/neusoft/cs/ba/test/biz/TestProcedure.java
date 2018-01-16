package com.neusoft.cs.ba.test.biz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/cs-ba-spring/applicationContext-cs-ba.xml")
public class TestProcedure {
	Logger log = LoggerFactory.getLogger(TestProcedure.class);

	@Autowired
	// private BaInterfaceFacade baInterfaceFacade;

	@Test
	public void testGetFaultReasonList() {
		try {
			// BaMaterialReplaceVO vo = new BaMaterialReplaceVO();
			// vo.setOrgCode("CS011");
			// vo.setMaterialCode("16073100000065");
			// MaterialReplaceResponse res =
			// baInterfaceFacade.findMaterialReplaceByParam(vo);
			// log.info("\n**********\n" + FastJSONHelper.serialize(res));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
