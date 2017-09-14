package com.maple.earnings.test;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmcUserPermitRequest;
import com.taobao.api.response.TmcUserPermitResponse;


public class MyThread5 extends Thread { 
	public static void main(String[] args) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.tbsandbox.com/router/rest", "1024484863", "sandbox566cc6b2d5b6d0b6bdddfe714");
		TmcUserPermitRequest req = new TmcUserPermitRequest();
		TmcUserPermitResponse rsp = client.execute(req, "620241173a7f8eddee7ZZ0e7facd4e5f0d9ed099dd277ed2054718218");
		System.out.println(rsp.getBody());
	}
	
} 
