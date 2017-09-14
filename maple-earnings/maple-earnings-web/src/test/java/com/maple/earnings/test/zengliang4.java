package com.maple.earnings.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.maple.earnings.pojo.TradeHistory;
import com.maple.earnings.pojo.TradeInfoBean;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradesSoldIncrementGetResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class zengliang4 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ApiException {
		Date dNow = new Date();
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
		dBefore = calendar.getTime(); // 得到前一天的时间

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.tbsandbox.com/router/rest", "1024484863",
				"sandbox566cc6b2d5b6d0b6bdddfe714");
		TradesSoldIncrementGetRequest req = new TradesSoldIncrementGetRequest();
		req.setFields("tid,type,status,payment,received_payment,title,post_fee");
		req.setStartModified(StringUtils.parseDateTime(df.format(dBefore)));
		req.setEndModified(StringUtils.parseDateTime(df.format(new Date())));
		req.setPageNo(1L);
		req.setPageSize(40L);
		req.setUseHasNext(true);
		TradesSoldIncrementGetResponse rsp = client.execute(req,
				"6102718b9cb2fcb3b0b99879511a556afeca67f1f629dee2054718218");
		System.out.println(rsp.getBody());
		if (rsp.getBody().contains("trades_sold_increment_get_response")) {
			JSONObject ResponseData = null;
			ResponseData = JSONObject.fromObject(rsp.getBody());
			String jsonObjectIncreate = ResponseData.getString("trades_sold_increment_get_response");
			JSONObject jsonObjectResData = JSONObject.fromObject(jsonObjectIncreate);
			String trades = null;
			try {
				trades = jsonObjectResData.getString("trades");
				JSONObject jsonObjectTrades = JSONObject.fromObject(trades);
				String tradeInfo = jsonObjectTrades.getString("trade");
				JSONArray jsonArray = JSONArray.fromObject(tradeInfo);
				List<TradeInfoBean> lTradeInfoBeans = new ArrayList<>();
				lTradeInfoBeans = JSONArray.toList(jsonArray, TradeInfoBean.class);
				for (TradeInfoBean tradeInfoBean : lTradeInfoBeans) {
					TradeHistory tradeHistory = new TradeHistory();
					tradeHistory.setChangetime(df.format(new Date()));
					tradeHistory.setPostfee(Double.parseDouble(tradeInfoBean.getPost_fee()));
					tradeHistory.setRealpayment(Double.parseDouble(tradeInfoBean.getReceived_payment()));
					tradeHistory.setShuoldpayment(Double.parseDouble(tradeInfoBean.getPay_time()));
					tradeHistory.setTid(tradeInfoBean.getTid());
				}
			} catch (Exception ex) {

			}
		} else {
			System.out.println("接口调用失败！");
		}

	}

}
