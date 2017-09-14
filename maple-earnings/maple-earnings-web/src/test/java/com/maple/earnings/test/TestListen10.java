package com.maple.earnings.test;

import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.api.internal.toplink.LinkException;

public class TestListen10 implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		TestListen10 c=new TestListen10();
		  Thread t1=new Thread(c);  
	        t1.start();
	        t1.sleep(100000);
	}

	@Override
	public void run() {

		TmcClient client = new TmcClient("1024484863", "sandbox566cc6b2d5b6d0b6bdddfe714", "default"); // 关于default参考消息分组说明
		client.setMessageHandler(new MessageHandler() {
		    public void onMessage(Message message, MessageStatus status) {
		        try {
		            System.out.println(message.getContent());
		            System.out.println("---------------------");
		            System.out.println(message.getTopic());
		            System.out.println("---------------------");
		            System.out.println(message);
		            System.out.println("---------------------");
		            System.out.println(status);
		        } catch (Exception e) {
		            e.printStackTrace();
		            status.fail(); // 消息处理失败回滚，服务端需要重发
		          // 重试注意：不是所有的异常都需要系统重试。 
		          // 对于字段不全、主键冲突问题，导致写DB异常，不可重试，否则消息会一直重发
		          // 对于，由于网络问题，权限问题导致的失败，可重试。
		          // 重试时间 5分钟不等，不要滥用，否则会引起雪崩
		        }
		    }
		});
		try {
			client.connect("ws://mc.api.tbsandbox.com/");
			System.out.println(client.isOnline());
		} catch (LinkException e) {
			e.printStackTrace();
			client.close();
		} // 消息环境地址：ws://mc.api.tbsandbox.com/
		
	
		
	}

}
