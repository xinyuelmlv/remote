package com.maple.earnings.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.taobao.api.internal.util.WebUtils;

import net.sf.json.JSONObject;

public class refreshToken {
	public static void main(String[] args) {
	    String url="https://oauth.tbsandbox.com/token";
	    Map<String,String> props=new HashMap<String,String>();
	    props.put("grant_type","refresh_token");
	    props.put("refresh_token","62016258caaa8691d78d07383fa0e5df1ZZ7a048f82d53b2054718218");
	    props.put("client_id","1024484863");
	    props.put("client_secret","sandbox566cc6b2d5b6d0b6bdddfe714");
	    String s="";
	    try{
	    s=WebUtils.doPost(url, props, 30000, 30000);
	    JSONObject jsonObjectUserInfo = null;
		jsonObjectUserInfo = JSONObject.fromObject(s);
		String refreshToken=jsonObjectUserInfo.getString("access_token");
	    System.out.println(s);
	    System.out.println(refreshToken);
	    }catch(IOException e){
	        e.printStackTrace();
	    }

}}
