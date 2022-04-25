package com.assoft.aspweb.action.controllermain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.asopUtil.common.tool.util.Log4jUtil;
import com.assoft.asopUtil.common.tool.util.Utils;
import com.assoft.aspweb.action.webmain.MySessionContext;
import com.assoft.aspweb.common.action.AdminHookMainAction;
import com.assoft.aspweb.common.action.AdminMainAction;
import com.assoft.aspweb.common.config.LocalConfig;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.aspweb.service.actionmain.AdminMainActionImpService;
import com.assoft.aspweb.service.bussiness.AppCataService;
import com.assoft.aspweb.service.cache.SessionRedisService;
import com.assoft.aspweb.service.common.LocalService;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.record.common.value.AssoftActionRecord;
import com.assoft.report.util.log.LogRecord;
import com.assoft.web.controller.ControllerService;
import com.soft.cms.spring.SpringContext;
import com.soft.web.common.ActionUtil;
import com.soft.web.common.FasadeSession;

@Controller
@Scope("prototype")
public class MainController extends AsopBaseController<AdminMainAction> {
	private LogRecord logger=LogRecord.getLogRecord(this.getClass());
	//登陆
	@RequestMapping("/login.do")
	public ModelAndView login(String loginName,String loginPassword,String YANZHENGMA){
		LocalService localService=SpringContext.getClassNameLowerService(LocalService.class);
		Map<String, String> params=new HashMap<String, String>();
		params.put("loginName", loginName);
		params.put("loginPassword", loginPassword);
		params.put("YANZHENGMA", YANZHENGMA);    
		String systemName=localService.gainSystemName();
		AssoftActionRecord record=initRecord(params,"login","登录\""+systemName+"\"");
		ActionResultInfo<UserProperty> resultInfo=login(loginName, loginPassword, YANZHENGMA, request,record);
		if(!resultInfo.isOk()){
			String ajax=request.getParameter("ajax");
			if("jsonp".equals(ajax)) {
				//ActionUtil.generateAjaxJsonpUtf8Resp(response, buildErrorMap(resultInfo.getErrorMsg()), request);
				return null;
			}
			return new ModelAndView("/login.jsp");
		}else{
			
			AdminHookMainAction hookMainAction=loadHookAction();
			if(hookMainAction!=null) {
				hookMainAction.afterLogin(resultInfo.getResult(), request, response,session);
			}
			String ajax=request.getParameter("ajax");
			if("jsonp".equals(ajax)) {
				Map<String, Object> map=new HashMap<String, Object>();
				HttpSession session=request.getSession();
				String token=(String)session.getAttribute("token");
				map.put("token", token);
				map.put("user",resultInfo.getResult());
				if("redis".equals(request.getParameter("from"))) {//向redis写入session
					token="redis_"+token;
					FasadeSession redisSession=new FasadeSession();
					redisSession.setAttribute("redis_token", token);
					redisSession.setAttribute("UserProperty",resultInfo.getResult() );
					map.put("token", token);
					SessionRedisService sessionRedisService=SpringContext.getClassNameLowerService(SessionRedisService.class);
					sessionRedisService.putSession2Redis(token,redisSession);
				}
				//ActionUtil.generateAjaxJsonpUtf8Resp(response, map, request);
				return null;
			}
			
			String url=actionService().loadMainurlAftLogin();
			return new ModelAndView("redirect:"+url);
		}
	}
	
	
	
	
	
	
	

	private AssoftActionRecord initRecord(Map<String, String> params,String actionName,String actionTitle){
		AssoftActionRecord log=new AssoftActionRecord();
		String ip=getRemoteHost(request);
		log.setIp(ip);
		AppCataService appCataService=SpringContext.getClassNameLowerService(AppCataService.class);
		
		LocalService localService=SpringContext.getClassNameLowerService(LocalService.class);
		String userAgent= request.getHeader("User-Agent");
		log.setUserAgent(userAgent);
		
		log.setActionParams(params);
		log.setActionType("loginout");
		log.setActionName(actionName);
		log.setActionTitle(actionTitle);
    
       
        log.setActionUser(gainSessionUserLoginName());
        log.setAppName(appCataService.loadAppName());
        log.setAppTitle(localService.gainSystemName());
        
      
        
		return log;
	}
	
	
	public String getRemoteHost(javax.servlet.http.HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	
	
	@RequestMapping("/initRedisToken.do")
	public String initRedisToken(){
		try{
			String token=(String)session.getAttribute("redis_token");
			if(Utils.isEmpty(token)) {
				String tokenOrg=UUID.randomUUID().toString();
				token="redis_"+tokenOrg;
				FasadeSession redisSession=new FasadeSession();
				redisSession.setAttribute("redis_token", token);
				redisSession.setAttribute("UserProperty",gainSessionUser() );
				SessionRedisService sessionRedisService=SpringContext.getClassNameLowerService(SessionRedisService.class);
				sessionRedisService.putSession2Redis(token,redisSession);
			}
			return go2Page(token);
			}catch(Exception ex){
				Log4jUtil.logException(getClass(), ex);
				return go2Page(buildErrorMap("异常错误"));
			}
	}
	
	
	@RequestMapping("/loadRedisToken.do")
	public String loadRedisToken(){
		try{
		String token=(String)session.getAttribute("redis_token");
		return go2Page(token);
		}catch(Exception ex){
			Log4jUtil.logException(getClass(), ex);
			return go2Page(buildErrorMap("异常错误"));
		}
		
	}
	
	@RequestMapping("/saveConfig.do")
	public String saveConfig(LocalConfig config){
		try{
			
			actionService().saveConfig(config);
			session.getServletContext().removeAttribute("theme");
			session.getServletContext().removeAttribute("systemName");
			return go2Page("1");
		}catch(Exception ex){
			Log4jUtil.logException(getClass(), ex);
			return go2Page(buildErrorMap("异常错误"));
		}
		
	}
	
	
	@RequestMapping("/loadUser.do")
	public String loadUser(){
		try{
			
			UserProperty uProperty=gainSessionUserProperty();
			return go2Page(uProperty);
		}catch(Exception ex){
			Log4jUtil.logException(getClass(), ex);
		
			return null;
		}
	}
	
	

	
	
	
	
	

	
	@RequestMapping("/loadConfig.do")
	public String loadConfig(){
		try{
			
			ActionResultInfo<LocalConfig> info=actionService().loadConfig();
			return go2PageByResult(info);
		}catch(Exception ex){
			Log4jUtil.logException(getClass(), ex);
			return go2Page(buildErrorMap("异常错误"));
		}
		
	}
	
	
	
	
	public ActionResultInfo<UserProperty> login(String loginName,String loginPassword,String YANZHENGMA,HttpServletRequest request,AssoftActionRecord record){
		ActionResultInfo<UserProperty> resultInfo=new ActionResultInfo<UserProperty>(null);

		HttpSession session=request.getSession();
		String vv = (String)session.getAttribute("validateCode");
		if(Utils.isEmpty(vv)||Utils.isEmpty(YANZHENGMA)||!YANZHENGMA.toUpperCase().equals(vv.toUpperCase())){
			resultInfo.setOk(false);
			resultInfo.setErrorMsg("验证码错误");
		}	
		else {
			if(Utils.isEmpty(loginName) || Utils.isEmpty(loginPassword)){
				resultInfo.setOk(false);
				resultInfo.setErrorMsg("用户名或密码为空");
			}else{
				resultInfo=actionService().personLoginByLoginName(loginName, loginPassword, null,record);
			}
		
		}
		
		String errorMsg=resultInfo.getErrorMsg();
		if(!resultInfo.isOk()){
			buildErrorMsg(errorMsg, session);
			return resultInfo;
		}else{
			AsopUser userAccount=resultInfo.getResult().getUserInfo();
			session.invalidate(); 
		    session=request.getSession(true);
		    String token=UUID.randomUUID().toString();
		    MySessionContext.getInstance().addSession(token, session);
		    
		    UserProperty up=resultInfo.getResult();
			session.setAttribute("UserProperty", up);
			session.setAttribute("resultInfo", resultInfo);
			return resultInfo;
		}
	}
	public ActionResultInfo<UserProperty> login(String loginName,String loginPassword,HttpServletRequest request){
		ActionResultInfo<UserProperty> resultInfo=new ActionResultInfo<UserProperty>(null);

		HttpSession session=request.getSession();
		
	
			if(Utils.isEmpty(loginName) || Utils.isEmpty(loginPassword)){
			resultInfo.setErrorMsg("用户名或密码为空");
		}
		else{
			resultInfo=actionService().autoLoadLoginPersonByLoginName(loginName, loginPassword);
		}
		
		
		
		String errorMsg=resultInfo.getErrorMsg();
		if(!Utils.isEmpty(errorMsg)){
			resultInfo.setOk(false);
			buildErrorMsg(errorMsg, session);
			return resultInfo;
		}else{
			AsopUser userAccount=resultInfo.getResult().getUserInfo();
			session.invalidate(); 
		    session=request.getSession(true);
		    UserProperty up=resultInfo.getResult();
			session.setAttribute("UserProperty", up);	
			return resultInfo;
		}
	}
	//修改用户密码
	@RequestMapping("/appUpdateUserPassword.do")
	public String  appUpdateUserPassword(HttpServletRequest request,String oldPassword,String newPassword) throws Exception{
		HttpSession session=request.getSession(true);
		UserProperty up=(UserProperty)session.getAttribute("UserProperty");	
		Map<String, String> params=new HashMap<String, String>();
		params.put("loginName", up.getUserInfo().getLoginName());
		AssoftActionRecord record=initRecord(params,"updatePwd","修改用户密码");
		ActionResultInfo<AsopUser> resultInfo=actionService().updateUserPassword(up.getUserInfo().getId(), oldPassword, newPassword,record);
		if(resultInfo.isOk()){
			return go2AjaxPage("1");
		}else{
			return go2AjaxPage(buildErrorMap(resultInfo.getErrorMsg()));
		}
	}
	


	private void buildErrorMsg(String loginInfo,HttpSession session){
		LocalService localService=SpringContext.getClassNameLowerService(LocalService.class);
//		String displayString=localService.getLoginMessageMap().get(loginInfo);
//		
		if (Utils.isEmpty(loginInfo)) {
			loginInfo = "登陆失败!";
		}
		session.setAttribute("errorLogin",loginInfo);
		
	}
	
	@Override
	public  AdminMainAction gainActionService(Class<AdminMainAction> clazz){
		
		return SpringContext.getClassNameLowerService(AdminMainActionImpService.class);
	}

	
	private AdminHookMainAction loadHookAction() {
		ControllerService controllerService=SpringContext.getClassNameLowerService(ControllerService.class);
		AdminHookMainAction hookAction=controllerService.gainActionService(AdminHookMainAction.class);
		
		return hookAction;
	}
	
	
	
}
