package com.gzs.learn.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.gomegj.exw.order.inf.bo.RefundBO;
import com.gomegj.exw.order.inf.common.Enums.RefundStaus;
import com.gomegj.exw.order.inf.common.Result;
import com.gomegj.exw.order.inf.dubbo.DubboBackendOrderService;
import com.gomegj.exw.order.inf.dubbo.DubboInvoiceService;
import com.gomegj.exw.order.inf.entity.OrderInvoice;
import com.gomegj.exw.order.inf.entity.Refund;

public class TestRefund {
	private DubboBackendOrderService dubboBackendOrderService;
	private DubboInvoiceService dubboInvoiceService;
	ApplicationContext ctx = null;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("classpath:client-dubbo.xml");
		dubboBackendOrderService = ctx.getBean(DubboBackendOrderService.class);
		dubboInvoiceService = ctx.getBean(DubboInvoiceService.class);
	}

	@Test
	public void testGetRefund() {
		RefundBO refund = new RefundBO();
		refund.setRefundStatus(RefundStaus.REFUND_INIT.getValue());
		Result<Refund> result = dubboBackendOrderService.findRefunds(refund, 0, 10);
		System.out.println(JSON.toJSONString(result));
	}

	@Test
	public void testGetInvoice() {
		OrderInvoice orderInvoice = new OrderInvoice();
		System.out.println(dubboInvoiceService.findOrderInvoice(orderInvoice, 1, 10));
	}

	@After
	public void destory() {

	}
}
