package com.maple.earnings.test;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmcUserGetRequest;
import com.taobao.api.response.TmcUserGetResponse;

public class Test6 {
	public static void main(String[] args) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.tbsandbox.com/router/rest", "1024484863", "sandbox566cc6b2d5b6d0b6bdddfe714");
		TmcUserGetRequest req = new TmcUserGetRequest();
		req.setFields("user_nick,topics,user_id,is_valid,created,modified");
		req.setNick("sandbox_b_01");
		req.setUserPlatform("tbUIC");
		TmcUserGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	
}
