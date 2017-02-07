package com.gzs.learn.boot.jpa;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.gomegj.exw.invoice.bo.RefundBO;
import com.gomegj.exw.invoice.common.Enums;
import com.gomegj.exw.invoice.common.Result;
import com.gomegj.exw.invoice.dubbo.DubboBackendOrderService;
import com.gomegj.exw.invoice.entity.Refund;

/*@RunWith(SpringRunner.class)
@ImportResource(locations = { "/client-dubbo.xml" })
@SpringBootTest(webEnvironment = WebEnvironment.NONE)*/
public class TestRefund {
	private DubboBackendOrderService dubboBackendOrderService;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:client-dubbo.xml");
		dubboBackendOrderService = (DubboBackendOrderService) ctx.getBean("DubboBackOrderEndService");
	}

	@Test
	public void testGetRefund() {
		RefundBO refund = new RefundBO();
		Result<Refund> result = dubboBackendOrderService.findRefunds(refund, 0, 10);
		System.out.println(JSON.toJSONString(result));
		System.out.println(dubboBackendOrderService.changeRefundFinanceStatus("gzs", "exw1152921504606877714",
				Enums.RefundStaus.REFUND_SUCCESS.getValue()));
	}
}
