package com.maple.earnings.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.maple.earnings.pojo.Wuliu;
import com.maple.earnings.service.UserService;
import com.maple.earnings.service.WuliuService;

@Component  
public class MyTaskAnnotation {   
	@Autowired
	private UserService userService;
	@Autowired 
	private WuliuService wuliuService;
    /**  
     * 定时任务为用户设置每日可用的同步次数。每天凌晨 00:00 执行一次  
     */    
    @Scheduled(cron = "0 0 1 * * ?")   
    public void show(){  
     this.userService.updateExpreTime(5);
     System.out.println("------定时任务执行-----"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
   //  timeOut();
    }  
    // 通过定时任务判断当前交易中已签收的是否超时
    public void timeOut(){
    	Date dNow = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	List<Wuliu> wulius=wuliuService.wulius();
    	for (Wuliu wuliu : wulius) {
			if(compare_date(wuliu.getDistime(),df.format(dNow.getTime()))==1){
				wuliu.setTimeout(1);
				this.wuliuService.update(wuliu);
			}
		}
    }
    // 比较时间
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2); 
            if (dt1.getTime() > dt2.getTime()) {
                return -1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
   // 发送超时邮件
    public static void  sendEmail() throws Exception{
    	  String myEmailAccount = "fengling_tech@163.com";
          String myEmailPassword = "Fengling0987";
          String myEmailSMTPHost = "smtp.163.com";
          String receiveMailAccount = "958674218@qq.com";
          Properties props = new Properties();                    // 参数配置
          props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
          props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
          props.setProperty("mail.smtp.auth", "true");     
          Session session = Session.getDefaultInstance(props);
          session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

          // 3. 创建一封邮件
          MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);

          // 4. 根据 Session 获取邮件传输对象
          Transport transport = session.getTransport();
          transport.connect(myEmailAccount, myEmailPassword);

          // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
          transport.sendMessage(message, message.getAllRecipients());

          // 7. 关闭连接
          transport.close();
          
    }
    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "用户", "UTF-8"));

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent("您有超时未付款的交易，请注意处理", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
    public static void main(String[] args) {
		try {
			sendEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}  
