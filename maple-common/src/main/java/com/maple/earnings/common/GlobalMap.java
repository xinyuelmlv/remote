/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.common;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class GlobalMap {

	public static Map<String, String> ORDER_STATUS = new HashMap<>();

	public static Map<String, String> REFUND_STATUS = new HashMap<>();
	/**
	 *
	 * WAIT_BUYER_PAY：等待买家付款 WAIT_SELLER_SEND_GOODS：等待卖家发货 SELLER_CONSIGNED_PART：卖家部分发货
	 * WAIT_BUYER_CONFIRM_GOODS：等待买家确认收货 TRADE_BUYER_SIGNED：买家已签收（货到付款专用） TRADE_FINISHED：交易成功 TRADE_CLOSED：交易关闭
	 * TRADE_CLOSED_BY_TAOBAO：交易被淘宝关闭 TRADE_NO_CREATE_PAY：没有创建外部交易（支付宝交易） WAIT_PRE_AUTH_CONFIRM：余额宝0元购合约中
	 * PAY_PENDING：外卡支付付款确认中 ALL_WAIT_PAY：所有买家未付款的交易（包含：WAIT_BUYER_PAY、TRADE_NO_CREATE_PAY）
	 * ALL_CLOSED：所有关闭的交易（包含：TRADE_CLOSED、TRADE_CLOSED_BY_TAOBAO）
	 *
	 */
	static {
		ORDER_STATUS.put("WAIT_BUYER_PAY", "等待买家付款");
		ORDER_STATUS.put("WAIT_SELLER_SEND_GOODS", "等待卖家发货");
		ORDER_STATUS.put("SELLER_CONSIGNED_PART", "卖家部分发货");
		ORDER_STATUS.put("WAIT_BUYER_CONFIRM_GOODS", "等待买家确认收货");
		ORDER_STATUS.put("TRADE_BUYER_SIGNED", "买家已签收（货到付款专用）");
		ORDER_STATUS.put("TRADE_FINISHED", "交易成功");
		ORDER_STATUS.put("TRADE_CLOSED", "交易关闭");
		ORDER_STATUS.put("TRADE_CLOSED_BY_TAOBAO", "交易被淘宝关闭");
		ORDER_STATUS.put("TRADE_NO_CREATE_PAY", "没有创建外部交易（支付宝交易）");
		ORDER_STATUS.put("WAIT_PRE_AUTH_CONFIRM", "余额宝0元购合约中");
		ORDER_STATUS.put("PAY_PENDING", "外卡支付付款确认中");
		/**
		 * 退款状态。可选值 WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意) WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货)
		 * WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货) SELLER_REFUSE_BUYER(卖家拒绝退款) CLOSED(退款关闭) SUCCESS(退款成功)
		 */
		REFUND_STATUS.put("WAIT_SELLER_AGREE", "买家已经申请退款，等待卖家同意");
		REFUND_STATUS.put("WAIT_BUYER_RETURN_GOODS", "卖家已经同意退款，等待买家退货");
		REFUND_STATUS.put("WAIT_SELLER_CONFIRM_GOODS", "买家已经退货，等待卖家确认收货");
		REFUND_STATUS.put("SELLER_REFUSE_BUYER", "卖家拒绝退款");
		REFUND_STATUS.put("CLOSED", "退款关闭");
		REFUND_STATUS.put("SUCCESS", "退款成功");
	}
}
