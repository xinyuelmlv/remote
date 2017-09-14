/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maple.earnings.pojo.DayReport;
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.EProduct;
import com.maple.earnings.pojo.EProductCost;
import com.maple.earnings.pojo.ERefund;
import com.maple.earnings.pojo.ETrade;
import com.maple.earnings.pojo.EUser;
import com.maple.earnings.service.OrderReportService;
import com.maple.earnings.service.OrderService;
import com.maple.earnings.service.ProductCostService;
import com.maple.earnings.service.ProductService;
import com.maple.earnings.service.TradeService;
import com.maple.earnings.service.UserService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/applicationContext-*.xml")
public class TestService {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCostService productCostService;

	@Autowired
	private TradeService tradeService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderReportService orderReportService;

	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static long randomRange(long start, long end) {
		return (long) (Math.random() * (end - start) + start);
	}

	private static List<String> orderStatus = Arrays.asList("WAIT_SELLER_SEND_GOODS", "WAIT_BUYER_CONFIRM_GOODS",
			"TRADE_FINISHED");

	private static List<String> refundStatus = Arrays.asList("WAIT_SELLER_AGREE", "WAIT_BUYER_RETURN_GOODS",
			"WAIT_SELLER_CONFIRM_GOODS", "SUCCESS");

	private static Date ranDate(String begin, String end) {
		Date date = null;
		try {
			Date sd = format.parse(begin);
			Date ed = format.parse(end);
			long randomRange = randomRange(sd.getTime(), ed.getTime());
			date = new Date(randomRange);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	static Random random = new Random();

	private static String getOrderStatus() {
		return orderStatus.get(random.nextInt(3));
	}

	private static String getRefundStatus() {
		return refundStatus.get(random.nextInt(4));
	}

	@Test
	public void testRandom() {
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(2));
		}
	}

	@Test
	public void testGetOrderStatus() {
		System.out.println(getOrderStatus());
	}

//	@Test
//	public void register() {
//		EUser user = new EUser();
//		user.setNick("测试");
//		user.setUserId(666666L);
//		this.userService.register(user);
//	}
//
//	@Test
//	public void testLoad() {
//		EUser user = this.userService.load(666666);
//		System.out.println(user.getNick());
//	}

	@Test
	public void testAddProduct() {
		EProduct product = new EProduct();
		for (int i = 0; i < 10; i++) {
			product.setModified(format.format(new Date()));
		//	product.setNum(50L + i);
			product.setApprroveStatus("onsale");
			product.setNumIid(99999999L - i);
			product.setPrice(250.0 + i);
			product.setTitle("test" + i);
		//	product.setuId(666666L);
			this.productService.add(product);
		}
	}

	@Test
	public void testLoadProduct() {
		EProduct product = this.productService.load(99999999);
		System.out.println(product.getApprroveStatus());
	}

	@Test
	public void testLIstProduct() {
//		List<EProduct> products = this.productService.list(666666);
//		for (EProduct eProduct : products) {
//			System.out.println(eProduct);
//		}
	}

	@Test
	public void testAddProductCost() {
		EProductCost productCost = new EProductCost();
		for (int i = 0; i < 10; i++) {
			productCost.setCost(100.0 - i);
			productCost.setNumIid(99999999L - i);
			this.productCostService.add(99999999, productCost);
		}
	}

	@Test
	public void testAddTrade() throws ParseException {
		ETrade trade = new ETrade();
		for (int i = 0; i < 20; i++) {
			trade.setCreated(format.format(ranDate("2017-03-16 10:30:00", "2017-03-11 12:30:00")));
			trade.setPayTime(format.format(ranDate("2017-03-16 12:30:00", "2017-03-11 14:30:00")));
			trade.setEndTime(format.format(ranDate("2017-03-17 10:30:00", "2017-03-13 12:30:00")));
			trade.setModifiedTime(format.format(ranDate("2017-03-17 10:30:00", "2017-03-13 12:30:00")));
			trade.setStatus(getOrderStatus());
		//	trade.setTid(999999999L - i);
			trade.setTotalFee(2017.10 + 20 * i);
		//	trade.setUserId(666666L);
			this.tradeService.saveOrUpdate(trade);
		}
	}

	// @Test
	// public void testListTrade() {
	// List<ETrade> trades = (List<ETrade>) this.tradeService.listByPage(666666, 2, 10).getRows();
	// for (ETrade eTrade : trades) {
	// System.out.println(eTrade);
	// }
	// }

	@Test
	public void testListTrade() {
		List<ETrade> trades = this.tradeService.list("");
		for (ETrade eTrade : trades) {
			System.out.println(eTrade);
		}
	}

	@Test
	public void testAddOrder() {
		EOrder order = null;
		ERefund refund = null;
		for (int i = 0; i < 20; i++) {
			order = new EOrder();
			order.setCost(i + 0.0);
			order.setNum(4);
			order.setNumIid(99999999L - i / 5);
			order.setStatus(getOrderStatus());
			order.setPrice(500.0);
			int flag = random.nextInt(2);
			if (flag == 1) {
				refund = new ERefund();
				order.setRefundStatus(getRefundStatus());
				order.setRefundId(10000L - i);
				refund.setRefundFee(100L - i);
			}
			order.setTitle("哈哈哈哈哈哈哈" + i);
		//	order.setTid(999999999L - i);
		//	this.orderService.add(99999999999L - i, order, refund);
		}
	}

//	@Test
//	public void testListOrder() {
//		List<EOrder> orders = this.orderService.list(99999999999L);
//		for (EOrder eOrder : orders) {
//			System.out.println(eOrder);
//		}
//	}

	@Test
	public void testListTrade0() {
		List<ETrade> trades = this.tradeService.listByEndTime("", "2017-03-14");
		for (ETrade eTrade : trades) {
			System.out.println(eTrade);
		}
	}

	@Test
	public void testListReportDates() {
//		List<String> rList = this.orderReportService.getReportDates(666666);
//		for (String string : rList) {
//			System.out.println(string);
//		}
	}

	@Test
	public void testListDayReport() {
//		List<DayReport> dayReports = this.orderReportService.list(666666);
//		for (DayReport dayReport : dayReports) {
//			System.out.println(dayReport);
//		}
	}
}
