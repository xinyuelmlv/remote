package com.maple.earnings.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.ETrade;
import com.maple.earnings.pojo.EUser;
import com.maple.earnings.pojo.ManagerUser;
import com.maple.earnings.pojo.TradeHistory;
import com.maple.earnings.pojo.TradeInfoBean;
import com.maple.earnings.pojo.TradeInfoBean.OrdersBean.OrderBean;
import com.maple.earnings.pojo.Wuliu;
import com.maple.earnings.service.IncomHistoryService;
import com.maple.earnings.service.ManagerUserService;
import com.maple.earnings.service.OrderReportService;
import com.maple.earnings.service.OrderService;
import com.maple.earnings.service.TradeService;
import com.maple.earnings.service.UserService;
import com.maple.earnings.service.WuliuService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmcUserPermitRequest;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TmcUserPermitResponse;
import com.taobao.api.response.TradesSoldGetResponse;
import com.taobao.api.response.TradesSoldIncrementGetResponse;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.api.internal.toplink.LinkException;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.internal.util.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/AuthCheck")
public class AuthCheckController {
	@Autowired
	private UserService userService;
	@Autowired
	private TradeService tradeService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ManagerUserService managerUserService;
	@Autowired
	private IncomHistoryService incomHistoryService;
	@Autowired
	private OrderReportService orderReportService;
    @Autowired
    private WuliuService wuliuService;
	@RequestMapping("/callback")
	protected void callBack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		System.out.println("------code-----"+code);
		HttpSession sessionCode = request.getSession();
		sessionCode.setAttribute("code", code);
		AuthCheckController control = new AuthCheckController();
		InputStream in = control.getClass().getResourceAsStream("environmentSwich.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		response.sendRedirect(prop.getProperty("BACKURL") + "maple-earnings-web/AuthCheck/check?code=" + code);
	}
	// 修改管理员信息
	@RequestMapping("/updateAdmin")
	@ResponseBody
	protected int updateAdmin(HttpServletRequest request) throws ServletException, IOException {
		int result = 0;
		ManagerUser managerUser = new ManagerUser();
		try {
			String role = request.getParameter("role");
			String status = request.getParameter("status");
			String userId = request.getParameter("userId");
			managerUser.setRole(Integer.parseInt(role));
			managerUser.setStatus(Integer.parseInt(status));
			managerUser.setUserid(userId);
			this.managerUserService.Update(managerUser);
			result = 1;

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
// 保存初次登录输入的用户信息
	@RequestMapping("/saveUser")
	@ResponseBody
	protected int saveUser(HttpServletRequest request) throws Exception{
		EUser user=new EUser();
		HttpSession session=request.getSession();
		String connectorName=request.getParameter("connectorName");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String companyName=request.getParameter("companyName");
		String nashui=request.getParameter("nashui");
		String kaihui=request.getParameter("kaihui");
		String addr=request.getParameter("addr");
		user.setTaobao_user_id(session.getAttribute("userId").toString());
		user.setConnectorName(connectorName);
		user.setEmail(email);
		user.setTel(tel);
		user.setCompanyName(companyName);
		user.setNashui(nashui);
		user.setKaihui(kaihui);
		user.setAddr(addr);
		this.userService.updateUserInfo(user);
		return 1;
	}
	// 修改管理员信息
	@RequestMapping("/addAdmin")
	@ResponseBody
	protected int addAdmin(HttpServletRequest request) throws ServletException, IOException {
		int result = 0;
		ManagerUser managerUser = new ManagerUser();
		try {
			String password = request.getParameter("password");
			String userName = request.getParameter("userName");
			String role = request.getParameter("role");
			String status = request.getParameter("status");
			managerUser.setPassword(password);
			managerUser.setRole(Integer.parseInt(role));
			managerUser.setStatus(Integer.parseInt(status));
			managerUser.setUsername(userName);
			managerUser.setIntime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			managerUser.setUserid(UUID.randomUUID().toString().substring(1, 8));
			this.managerUserService.save(managerUser);
			result = 1;
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return result;
	}

	@RequestMapping("/listUser")
	@ResponseBody
	protected EasyUIDataGridResult listUser(int page, int rows) throws ServletException, IOException {
		EasyUIDataGridResult result = this.userService.list(page, rows);
		return result;
	}

	@RequestMapping("/checkUser")
	@ResponseBody
	protected int checkUser(String userName, String password, int role) throws ServletException, IOException {
		// 1.超级管理员 2.禁止登录 3.普通管理员
		int result = this.managerUserService.login(userName, password, role);
		return result;
	}

	@RequestMapping("/listAdmin")
	@ResponseBody
	protected EasyUIDataGridResult listAdmin(int page, int rows) throws ServletException, IOException {
		EasyUIDataGridResult result = this.managerUserService.list(page, rows);
		return result;
	}

	@RequestMapping("/userManager")
	protected String userManager() throws ServletException, IOException {
		return "userManager";
	}
	//测试方法，稍后删掉-------------------------------------------------------------------------------------------------------
	@RequestMapping("/session")
	protected void session(String token,String userId,HttpServletRequest request) throws ServletException, IOException, ApiException {
//		System.out.println("执行-----------------------------");
//		zengLiangQuery(token,userId);
		System.out.println("--------查询--------");
		 Cookie cookies[]=request.getCookies();  
		    System.out.println("cookie的数量为："+ cookies.length);
		    for(int i = 0;i<cookies.length;i++){ 
		    	System.out.println("getName="+cookies[i].getName());
		    	System.out.println("getValue="+cookies[i].getValue());
		    	System.out.println("getDomain="+cookies[i].getDomain());
		    } 
	}	
	//------------------------------------------------------------------------------------------
	@RequestMapping("/tongbuTime")
	@ResponseBody
	protected int tongbuTime(HttpServletRequest request, String start) throws ServletException, IOException, ApiException {
		EUser user=new EUser();
		HttpSession session=request.getSession();
		user.setExpire_time(Long.parseLong(start));
		user.setTaobao_user_id(session.getAttribute("userId").toString());
		this.userService.updateByPrimaryKeySelective(user);
		grepTrade(request);
		EUser usertimes = this.userService.load(session.getAttribute("userId").toString());
		session.setAttribute("times", usertimes.getExpire_time());
		return 1;
	}

	@RequestMapping("/adminLogin")
	protected String adminLogin() throws ServletException, IOException {
		return "adminLogin";
	}

	// 超级管理员
	@RequestMapping("/superAdmin")
	protected String adminList() throws ServletException, IOException {
		return "superAdmin";
	}
   // 获取用户详细信息
	@RequestMapping("/pickUserInfo")
	@ResponseBody
	protected EUser pickUserInfo(HttpServletRequest req){
		
		EUser user = this.userService.load(req.getParameter("userId"));
		return user;
	}
		@RequestMapping("/returnlogin")

		protected String returnlogin(){
			
			return "login";
		}
	@RequestMapping("/check")
	protected String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ApiException {
		String redirectResult = "error";
		HttpSession sessionCode = request.getSession();
		Object code = sessionCode.getAttribute("code");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userInfo = "";
		if (code != null) {
			AuthCheckController control = new AuthCheckController();
			InputStream in = control.getClass().getResourceAsStream("environmentSwich.properties");
			Properties prop = new Properties();
			try {
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
				return "error";
			}
			try {
				String url = prop.getProperty("TOKEN");
				Map<String, String> props = new HashMap<String, String>();
				props.put("grant_type", "authorization_code");
				props.put("code", code.toString());
				props.put("client_id", prop.getProperty("APPKEY"));
				props.put("client_secret", prop.getProperty("APPSECRET"));
				props.put("redirect_uri", prop.getProperty("BACKURL") + "maple-earnings-web/AuthCheck/CheckOk");
				props.put("view", "web");
				userInfo = AuthCheckController.sendPost(url, props);
				sessionCode.setAttribute("code", null);
				System.out.println(userInfo);
				// 拿到accessToken,存储用户信息
				JSONObject jsonObjectUserInfo = null;
				jsonObjectUserInfo = JSONObject.fromObject(userInfo);
				EUser user = new EUser();
				user.setAccess_token(jsonObjectUserInfo.getString("access_token"));
				user.setTaobao_user_id(jsonObjectUserInfo.getString("taobao_user_id"));
				user.setTaobao_user_nick(jsonObjectUserInfo.getString("taobao_user_nick"));
				user.setRegisterTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				user.setStatus(1);
				user.setExpire_time(5l);
				user.setRefresh_token(jsonObjectUserInfo.getString("refresh_token"));
				HttpSession session = request.getSession();
				session.setAttribute("userId", jsonObjectUserInfo.getString("taobao_user_id"));
				session.setAttribute("token", jsonObjectUserInfo.getString("access_token"));
				EUser user1 = userService.load(jsonObjectUserInfo.getString("taobao_user_id"));
			//	redirectResult = "resister";
				//-- 为用户开通消息服务
				TaobaoClient client = new DefaultTaobaoClient(prop.getProperty("BASEURL"), prop.getProperty("APPKEY"),  prop.getProperty("APPSECRET"));
				TmcUserPermitRequest req = new TmcUserPermitRequest();
				req.setTopics("taobao_trade_TradePartlyConfirmPay,taobao_logistics_LogsticDetailTrace");
				TmcUserPermitResponse rsp = client.execute(req, jsonObjectUserInfo.getString("access_token"));
				System.out.println(rsp.getBody());
				//--开通消息结束
				if (user1 == null) {
					redirectResult="resister";
					this.userService.createOrder(session.getAttribute("userId").toString());
				    this.userService.createOrderReport(session.getAttribute("userId").toString());
					this.userService.createTrade(session.getAttribute("userId").toString());
					this.userService.createTradeHistory(session.getAttribute("userId").toString());
					userService.register(user);
					session.setAttribute("times",user.getExpire_time());
					this.grepTrade(request);	
				} else {
					// 执行获取同步次数。
					redirectResult="login";
					userService.updateByPrimaryKey(user);
					EUser usertimes = this.userService.load(session.getAttribute("userId").toString());
					session.setAttribute("times", usertimes.getExpire_time());
					int status = user1.getStatus();
					if (status == 3) {
						redirectResult = "runout";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		return redirectResult;
	}
	// 监听消息推送，跟随spring容器启动
	@PostConstruct
	  public void listenMessage() throws LinkException, InterruptedException{
		  AuthCheckController control = new AuthCheckController();
			InputStream in = control.getClass().getResourceAsStream("environmentSwich.properties");
			Properties prop = new Properties();
			try {
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
			TmcClient client = new TmcClient(prop.getProperty("APPKEY"), prop.getProperty("APPSECRET"), "default"); // 关于default参考消息分组说明
			client.setMessageHandler(new MessageHandler() {
			    public void onMessage(Message message, MessageStatus status) {
			    	// 设置日期为当前日期的三天后
			    	  Date dNow = new Date();
					  Date dAfter = new Date();
					  Calendar calendar = Calendar.getInstance(); //得到日历
					  calendar.setTime(dNow);//把当前时间赋给日历
					  calendar.add(Calendar.DAY_OF_MONTH, 3);  //设置为3天后
					  dAfter = calendar.getTime(); 
					  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					  String threeDaysLater=df.format(dAfter.getTime());
			        try {
			            System.out.println(message.getContent());
			            System.out.println(message.getTopic());
			            // 根据订单确认收货监听的消息添加调用增量查询的逻辑
			        	JSONObject jsonObjectUserInfo = null;
			        	JSONObject jsonObjectWuliu=null;
			        	if(message.getTopic().equals("taobao_trade_TradePartlyConfirmPay")){
						jsonObjectUserInfo = JSONObject.fromObject(message.getContent());
						EUser eu=userService.getUserByUserName(jsonObjectUserInfo.getString("seller_nick"));
						zengLiangQuery(eu.getAccess_token(),eu.getTaobao_user_id());
			        	}
			        	if(message.getTopic().equals("taobao_logistics_LogsticDetailTrace")){
			        		jsonObjectWuliu = JSONObject.fromObject(message.getContent());
			        		 Wuliu wuliu=new Wuliu();
			        		    wuliu.setAction(jsonObjectWuliu.getString("action"));
					            wuliu.setDescript(jsonObjectWuliu.getString("desc"));
					            wuliu.setTid(jsonObjectWuliu.getString("tid"));
					            wuliu.setTime(jsonObjectWuliu.getString("time"));
					            wuliu.setTimeout(0);
					            wuliu.setUserid(message.getUserId().toString());
					            wuliu.setDistime(threeDaysLater);
					            wuliuService.addWuliu(wuliu);   
			        	}
			        } catch (Exception e) {
			            e.printStackTrace();
			            status.fail();       
			        }
			    }
			});
			try{
			client.connect(prop.getProperty("LISTENURL")); 
			}catch(Exception ex){
				ex.printStackTrace();
				client.close();
			}
			System.out.println("监听状态："+client.isOnline());
			System.out.println("----监听启动成功-----");
	    }
	//根据refreshToken刷新accessToken
	  public String refreshToken(String refreshToken){
		    AuthCheckController control = new AuthCheckController();
			InputStream in = control.getClass().getResourceAsStream("environmentSwich.properties");
			Properties prop = new Properties();
			try {
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
				return "error";
			}
		    String url= prop.getProperty("TOKEN");
		    Map<String,String> props=new HashMap<String,String>();
		    props.put("grant_type","refresh_token");
		    props.put("refresh_token",refreshToken);
			props.put("client_id", prop.getProperty("APPKEY"));
			props.put("client_secret", prop.getProperty("APPSECRET"));
		    String s="";
		    String accessToken="";
		    try{
		    s=WebUtils.doPost(url, props, 30000, 30000);
		    JSONObject jsonObjectUserInfo = null;
			jsonObjectUserInfo = JSONObject.fromObject(s);
		    accessToken=jsonObjectUserInfo.getString("access_token");
		    System.out.println(s);
		    System.out.println(refreshToken);
		    }catch(IOException e){
		        e.printStackTrace();
		    }
		  return accessToken;
	  }
	  //----调用增量查询接口
	  public void zengLiangQuery(String accessToken,String userId) throws ApiException{
		  // ---加载配置文件----
		  AuthCheckController control = new AuthCheckController();
			InputStream in = control.getClass().getResourceAsStream("environmentSwich.properties");
			Properties prop = new Properties();
			try {
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		  Date dNow = new Date();
		  Date dBefore = new Date();
		  Calendar calendar = Calendar.getInstance(); //得到日历
		  calendar.setTime(dNow);//把当前时间赋给日历
		  calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		  dBefore = calendar.getTime();   //得到前一天的时间
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		  TaobaoClient client = new DefaultTaobaoClient(prop.getProperty("BASEURL"), prop.getProperty("APPKEY"),prop.getProperty("APPSECRET"));
		  TradesSoldIncrementGetRequest req = new TradesSoldIncrementGetRequest();
		  req.setFields("tid,type,status,payment,received_payment,title,post_fee");
		  req.setStartModified(StringUtils.parseDateTime(df.format(dBefore)));
		  req.setEndModified(StringUtils.parseDateTime(df.format(new Date())));
		  req.setPageNo(1L);
		  req.setPageSize(40L);
		  req.setUseHasNext(true);
		  TradesSoldIncrementGetResponse rsp = client.execute(req, accessToken);
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
						tradeHistory.setShuoldpayment(Double.parseDouble(tradeInfoBean.getPayment()));
						tradeHistory.setTid(tradeInfoBean.getTid());
						tradeHistory.setUserId(userId);
						tradeHistory.setTitle(tradeInfoBean.getTitle());
						tradeHistory.setStatus(tradeInfoBean.getStatus());
					    String realPay=	this.incomHistoryService.selectMaxRealPay(tradeHistory.getTid(), userId);
					    System.out.println(realPay);
					    if(realPay==null||realPay.equals("")){
					    	this.incomHistoryService.insert(tradeHistory);
					    }
					    else{
					    	 if(Double.parseDouble(realPay)!=tradeHistory.getRealpayment()){
							    	this.incomHistoryService.insert(tradeHistory);
							    }
					    }
					}
				} catch (Exception ex) {
                   ex.printStackTrace();
				}
			} else {
				System.out.println("接口调用失败！");
			}
		  
	  }
	@RequestMapping("/grepTrade")
	@ResponseBody
	public String grepTrade(HttpServletRequest request) throws ApiException{
		HttpSession session=request.getSession();
		AuthCheckController control = new AuthCheckController();
		InputStream in = control.getClass().getResourceAsStream("environmentSwich.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		TaobaoClient client = new DefaultTaobaoClient(prop.getProperty("BASEURL"),
				prop.getProperty("APPKEY"), prop.getProperty("APPSECRET"));
		TradesSoldGetRequest req = new TradesSoldGetRequest();
		req.setFields(
				"tid,type,status,payment,orders,created,pay_time,modified,end_time,post_fee,received_payment,price");
		TradesSoldGetResponse rsp = client.execute(req, session.getAttribute("token").toString());
	//	System.out.println(rsp.getBody());
		String tradesData = rsp.getBody();
		JSONObject jsonObjectTrade = JSONObject.fromObject(tradesData);
		String tradesSoldGetResponseData = null;
		try {
			tradesSoldGetResponseData = jsonObjectTrade.getString("trades_sold_get_response");
		} catch (Exception ex) {
			System.out.println("调取接口失败");
			ex.printStackTrace();
			return "error";
		}
		JSONObject jsonObjectResData = JSONObject.fromObject(tradesSoldGetResponseData);
		String trades = null;
		try {
			trades = jsonObjectResData.getString("trades");
			JSONObject jsonObjectTrades = JSONObject.fromObject(trades);
			String tradeInfo = jsonObjectTrades.getString("trade");
			JSONArray jsonArray = JSONArray.fromObject(tradeInfo);
			List<TradeInfoBean> lTradeInfoBeans = new ArrayList<>();
			lTradeInfoBeans = JSONArray.toList(jsonArray, TradeInfoBean.class);
			for (TradeInfoBean tradeInfoBean : lTradeInfoBeans) {
				System.out.println(tradeInfoBean.getPayment());
				ETrade etrade = new ETrade();
				etrade.setTid(tradeInfoBean.getTid());
				etrade.setTotalFee(Double.parseDouble(tradeInfoBean.getPayment()));
				etrade.setStatus(tradeInfoBean.getStatus());
				etrade.setUserId(session.getAttribute("userId").toString());
				etrade.setCreated(tradeInfoBean.getCreated());
				etrade.setEndTime(tradeInfoBean.getEnd_time());
				etrade.setModifiedTime(tradeInfoBean.getModified());
				etrade.setPayTime(tradeInfoBean.getPay_time());
				etrade.setPost_fee(tradeInfoBean.getPost_fee());
				etrade.setReceived_payment(tradeInfoBean.getReceived_payment());
				etrade.setPrice(tradeInfoBean.getPrice());
				tradeService.saveOrUpdate(etrade);
				JSONArray jsArrayOrder = JSONArray.fromObject(tradeInfoBean.getOrders().getOrder());
				@SuppressWarnings("deprecation")
				List<TradeInfoBean.OrdersBean.OrderBean> lorderBean = JSONArray.toList(jsArrayOrder,
						TradeInfoBean.OrdersBean.OrderBean.class);
				for (OrderBean orderBean : lorderBean) {
					EOrder eorder = new EOrder();
					eorder.setNum(orderBean.getNum());
					// ------------------------------------------------------
					eorder.setNumIid(orderBean.getNum_iid());
					// -----------------------------------------------------
					eorder.setPrice(Double.parseDouble(orderBean.getPrice()));
					eorder.setRefundStatus(orderBean.getRefund_status());
					eorder.setStatus(orderBean.getStatus());
					eorder.setTid(tradeInfoBean.getTid());
					eorder.setTitle(orderBean.getTitle());
					eorder.setId(orderBean.getOid());
					eorder.setUserId(session.getAttribute("userId").toString());
					EOrder eorder1 = new EOrder();
					eorder1 = orderService.listById(eorder.getId(),session.getAttribute("userId").toString());
					if (eorder1 == null) {
						orderService.add(tradeInfoBean.getTid(), eorder);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("账户下无订单！");
		}
		return "1";
	}
	@RequestMapping("/CheckOk")
	@ResponseBody
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public static String sendPost(String url, Map<String, String> parameters) {
		String result = "";// 返回的结果
		BufferedReader in = null;// 读取响应输入流
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer();// 处理请求参数
		String params = "";// 编码之后的参数
		try {
			// 编码请求参数
			if (parameters.size() == 1) {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
				}
				params = sb.toString();
			} else {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
							.append("&");
				}
				String temp_params = sb.toString();
				params = temp_params.substring(0, temp_params.length() - 1);
			}
			// 创建URL对象
			java.net.URL connURL = new java.net.URL(url);
			// 打开URL连接
			java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();
			// 设置通用属性
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// 设置POST方式
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			// 获取HttpURLConnection对象对应的输出流
			out = new PrintWriter(httpConn.getOutputStream());
			// 发送请求参数
			out.write(params);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应，设置编码方式
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
