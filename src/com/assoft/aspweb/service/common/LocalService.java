package com.assoft.aspweb.service.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assoft.asopUtil.common.tool.util.AsopXStreamUtil;
import com.assoft.asopUtil.common.tool.util.DnUtil;
import com.assoft.asopUtil.common.tool.util.Utils;
import com.assoft.asopUtil.common.tool.util.XmlUtil;
import com.assoft.aspweb.action.webmain.MySessionContext;
import com.assoft.aspweb.common.config.LocalConfig;
import com.assoft.aspweb.common.constant.WebcommonConstant;
import com.assoft.aspweb.service.bussiness.AppCataService;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.cloudclient.exchange.AsopCloudserviceTool;
import com.assoft.cloudclient.exchange.AsopIdsAction;
import com.assoft.cloudclient.exchange.AsopPortalAction;
import com.assoft.done.common.exchange.DoneTool;
import com.assoft.giss.common.entity.AsopCata;
import com.assoft.giss.common.exchange.BodyExtraElementTool;
import com.assoft.giss.common.exchange.FilerecordServerTool;
import com.assoft.giss.common.exchange.branch.BranchAppCataTool;
import com.assoft.giss.common.exchange.branch.BranchAppSchemaTool;
import com.assoft.giss.common.exchange.branch.BranchCataTool;
import com.assoft.giss.common.schema.AsopAppSchema;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.record.common.exchange.RecordTool;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;
import com.assoft.web.config.LocalEnv;
import com.soft.cms.spring.SpringContext;
/*aspWebCommon5.7*/
@Service
public class LocalService {
	
	@Autowired
	AspInfoHolderService aspInfoHolderService;
	private LocalEnv<LocalConfig> localEnv;
	private HashMap<String,String> loginMessageMap=new HashMap<String, String>();
	private List<String> securityList=null;
	
	

	@Autowired
	LocalElementIndexHandlerCustomService elementCustomService;
	
	@Autowired
	AppCataService appCataService;
	
	
	public String loadBranchAppIdFromMetaDn(String dn){
		String fdn=DnUtil.getFatherDn(dn);
		String appDn=DnUtil.getFatherDn(fdn);
		return DnUtil.getId(appDn);
	}
	
	public String getSecPass(int securityLevel) {
		return "ASOP_"+securityLevel;
	}
	
	
	/**
	 * 从领域对象中构建通用属性
	 * @param domain
	 * @return
	 */
	public AsopAppSchema buildAppSchema(AsopSchemaDomain domain) {
		AsopAppSchema ndomain=new AsopAppSchema();
		ndomain.setAppName(gainConfig().getAspAppName());
		ndomain.setSchemaName(domain.schemaName());
		ndomain.setSchemaType(domain.schemaType());
		
		
		ndomain.setTitle(domain.getTitle());
		ndomain.setDn(domain.getDn());
		ndomain.setId(domain.getId());
		ndomain.setModifyTime(domain.getModifyTime());
		ndomain.setFatherId(domain.getFatherId());
		ndomain.setMetaSchemaId(domain.getMetaSchemaId());
		ndomain.setRecycleStatus(domain.getRecycleStatus());
		
		ndomain.setPos(domain.getPos());
		ndomain.setSecurityLevel(domain.getSecurityLevel());
		ndomain.setFullMetaName(domain.getFullMetaName());
		ndomain.setFullShortname(domain.getFullShortname());
		ndomain.setExtraMetalements(domain.getExtraMetalements());
		return ndomain;
		
	}
	
	
	
	public HttpSession gainSession(HttpServletRequest request) {
		String token=request.getParameter("asop_token");
        HttpSession session=null;
        if(Utils.isEmpty(token)) {
        	session = request.getSession();
        }else {
        	session=MySessionContext.getInstance().getSession(token);
        }
        return session;
     
	}
	
	
	public void putAppAttr2Session(HttpSession session,String attrName,Object value) {
		  String appName=appCataService.loadAppName();
		  String name=appName+"_"+attrName;
		  session.setAttribute(name, value);
	}
	
	public Object getAppAttr2Session(HttpSession session,String attrName) {
		  String appName=appCataService.loadAppName();
		  String name=appName+"_"+attrName;
		  return session.getAttribute(name);
	}
	
	public String loadCustomElementIndexHandlerName(String schemaName,String elementShortname) {
		return elementCustomService.loadCustomElementIndexHandlerName(schemaName, elementShortname);
	}
	
	public int loadCutomElementIndexHandlerSize() {
		return elementCustomService.loadAppIndexHandlerSize();
	}
	
	public void putCustomElementIndexHandlerName(String schemaName,String elementShortname,Class clazz) {
		 elementCustomService.putCustomElementIndexHandlerName(schemaName, elementShortname, clazz);
	}
	
	
	
	
	public byte[] invertBytes(byte[] acontents) {
		int len=acontents.length;
		byte[] tcontents=new byte[len];
		for(int i=0;i<len;i++) {
		
			tcontents[i]=(byte)~acontents[i];
			
		}
		return tcontents;
	}
	
	/**
	 * 默认是否应用管理员方法
	 * @param user
	 * @return
	 */
	public boolean isAppAdmin(AsopUser user) {
		return isAppAdmin(user.getLoginName(), user.getRole());
	}

	/**
	 * 默认是否应用管理员方法
	 * @param loginName
	 * @param roles
	 * @return
	 */
	public boolean isAppAdmin(String loginName,List<String> roles) {

	
		if(roles!=null&&roles.contains("admin")) {
			return true;
		}
	
		String[] users= {"admin"};
		if(Utils.contain(users, loginName)) {
			return true;
		}
		return false;
	}
	
	
	public FilerecordServerTool filerecordServerTool(String appName, String schemaName){
		try{
		    return appCataService.cataTool(appName, schemaName, FilerecordServerTool.class);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	
	public int getSecurityLevel(String securityLevel) {
		if(!Utils.isDigitalNumber(securityLevel)) {
			return 0; 
		}else {
			return Utils.toNumber(securityLevel);
		}
	}
	
	
	
	

	
	public boolean isSchemaBranch() {
		return "1".equals(gainConfig().getBranchType());
	}
	
	
	
	public String loadLocalRmiUrl(){
		return localEnv.gainSystemInfo().gainLocalRmiUrl();
	}
	
	public List<String[]> listSchemaNameArrays(){
		List<String[]> names=new ArrayList<String[]>();
		
		List<AsopCata> list=loadAspInfo().getSchemaCatas();
		
		for(AsopCata cata:list){
			String[] ar={cata.getShortName(),cata.getTitle()};
			names.add(ar);
		}
		return names;
	}
	
	public String gainWebRootPath(){
		return getLocalEnv().getWebInfo().getWebRootPath();
	}
	
	
	
	
	public BranchAppCataTool cloudAppCataTool(){
		try{
			if("cloud".equals(gainConfig().getAspAppName())) {
				return (BranchAppCataTool)SpringContext.getBean("branchAppCataToolImpService");
			}
			AspInfo aspInfo=aspInfoHolderService.loadAspInfo(); 
			String rmiUrl=aspInfo.getCloudRmiURL();//用户
			BranchAppCataTool tool= AsopRmiClientENV.gainRemoteProxy(rmiUrl,BranchAppCataTool.class);
			return tool;
		}catch(Exception ex){
			
		}
		return null;
	}
	

	

	public BranchAppSchemaTool loadAppSchemaTool(){
		try{
			if("cloud".equals(gainConfig().getAspAppName())) {
				return (BranchAppSchemaTool)SpringContext.getBean("branchAppSchemaToolImpService");
			}
			AspInfo aspInfo=aspInfoHolderService.loadAspInfo(); 
			String rmiUrl=aspInfo.getCloudRmiURL();
			BranchAppSchemaTool tool= AsopRmiClientENV.gainRemoteProxy(rmiUrl,BranchAppSchemaTool.class);
			return tool;
		}catch(Exception ex){
			
		}
		return null;
	}
	
	public DoneTool doneTool() {
		if("done".equals(gainConfig().getAspAppName())) {
			return (DoneTool)SpringContext.getBean("doneToolImpService");
		}
		Map<String, String> map=loadAspInfo().getAspRmiMap();
		String url=map.get("done");
		return AsopRmiClientENV.gainRemoteProxy(url, DoneTool.class);
	}
	
	public RecordTool recordTool() {
		if("recordTool".equals(gainConfig().getAspAppName())) {
			return (RecordTool)SpringContext.getBean("recordToolImpService");
		}
		Map<String, String> map=loadAspInfo().getAspRmiMap();
		String url=map.get(WebcommonConstant.BASEWEB_RECORD);
		if(url==null) {
			return null;
		}
		return AsopRmiClientENV.gainRemoteProxy(url, RecordTool.class);
	}
	
	
	
	public <T> T gainAspwebTool(String shortName,Class<T> clazz){
		try{
			Map<String, String> rmiMap=loadAspInfo().getAspRmiMap();
			if(rmiMap!=null){
					String rmiUrl=rmiMap.get(shortName);
					if(!Utils.isEmpty(rmiUrl)) {
						T tool=AsopRmiClientENV.gainRemoteProxy(rmiUrl, clazz);
						return tool;
					}

			}
			
		}catch(Exception ex){
			return null;
		}
		return null;
		
	}
	
	
	
	
	

	
	
	public AspInfo loadAspInfo() {
		return aspInfoHolderService.loadAspInfo();
	}

	

	
	
	
	
	
	public void saveConfig(LocalConfig config){
		
		String xml=AsopXStreamUtil.toXml(config);
		String filePath=getLocalEnv().getConfigInfo().getConfigXmlPath();
		try {
			XmlUtil.writePrettyXml(filePath, xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public BranchCataTool loadLocalBranchCataTool() {
		String beanName="branchCataToolImpService";
		return (BranchCataTool)SpringContext.getBean(beanName);
	}

	
	public BranchAppCataTool loadLocalBranchAppCataTool() {
		String beanName="branchAppCataToolImpService";
		return (BranchAppCataTool)SpringContext.getBean(beanName);
	}
	
	
	public <T> T loadLocalToolByClass(Class<T> clazz) {
		String name=clazz.getSimpleName();
		String beanName=null;
		if(name!=null&&!name.equals("")){
			char first=Character.toLowerCase(name.charAt(0));	
			beanName=first+name.substring(1)+"ImpService";
		}
		return (T)SpringContext.getBean(beanName);
	}
	

public String loadAspServerRmiUrl(){
	
	LocalConfig config=localEnv.gainSystemInfo();
	
	return config.getServerRmi();
}
	

public BodyExtraElementTool bodyExtraElementTool(){
	try{
		AspInfo aspInfo=aspInfoHolderService.loadAspInfo();
			String rmiUrl=aspInfo.getCloudRmiURL();
			
			BodyExtraElementTool tool= AsopRmiClientENV.gainRemoteProxy(rmiUrl,BodyExtraElementTool.class);
			return tool;
		
		
	}catch(Exception ex){
		ex.printStackTrace();
		
	}
	return null;
}
	
	

	public String gainAppName(){
		String appName=gainConfig().getAppName();
		if(appName.equals("/")){
			appName="";
		}
		return appName;
	}
	
	
	/**
	 * 向云服务平台中加载idsAction
	 * @return
	 */
	public AsopIdsAction idsAction(){
		String appName=gainConfig().getAspAppName();
		if("cloud".equals(appName)) {
			return (AsopIdsAction)SpringContext.getBean("asopIdsActionImpService");
		}
		AspInfo aspInfo=aspInfoHolderService.loadAspInfo();
		String url=aspInfo.getCloudRmiURL();
		if(Utils.isEmpty(url)) {
			return null;
		}
		return AsopRmiClientENV.gainRemoteProxy(url, AsopIdsAction.class);
	}
	
	
	/**
	 * 服务类
	 * @return
	 */
	public AsopCloudserviceTool cloudserviceTool() {
		  return cloudTool(AsopCloudserviceTool.class);
	}
	
	
	
	public  <T> T   cloudTool(Class<T> clazz){
		String appName=gainConfig().getAspAppName();
		String name=gainClassSpringName(clazz);
		if("cloud".equals(appName)) {
			return (T)SpringContext.getBean(name+"ImpService");
		}
		AspInfo aspInfo=aspInfoHolderService.loadAspInfo();
		String url=aspInfo.getCloudRmiURL();
		if(Utils.isEmpty(url)) {
			return null;
		}
		return AsopRmiClientENV.gainRemoteProxy(url, clazz);
	}
	
	
	public String gainClassSpringName(Class clazz) {
		String name=clazz.getSimpleName();
		char first=Character.toLowerCase(name.charAt(0));
		
		name=first+name.substring(1);
		return name;
	}
	
	
	
	
	
	/**
	 * 向云服务平台中加载portalAction
	 * @return
	 */
	public AsopPortalAction portalAction(){
		String appName=gainConfig().getAspAppName();
		if("cloud".equals(appName)) {
			return (AsopPortalAction)SpringContext.getBean("asopPortalActionImpService");
		}
		AspInfo aspInfo=aspInfoHolderService.loadAspInfo();
		String url=aspInfo.getCloudRmiURL();
		return AsopRmiClientENV.gainRemoteProxy(url, AsopPortalAction.class);
	}
	
	public String gainSystemName(){
		return gainConfig().getSystemName();
	}
	
	public String gainMode() {
		
		return gainConfig().getMode();
	}
	
	public LocalEnv<LocalConfig> getLocalEnv() {
		return localEnv;
	}

	public void setLocalEnv(LocalEnv<LocalConfig> localEnv) {
		this.localEnv = localEnv;
	}
	public LocalConfig gainConfig(){
		return getLocalEnv().gainSystemInfo();
	}


	public HashMap<String, String> getLoginMessageMap() {
		return loginMessageMap;
	}


	public void setLoginMessageMap(HashMap<String, String> loginMessageMap) {
		this.loginMessageMap = loginMessageMap;
	}


	public List<String> getSecurityList() {
		return securityList;
	}


	public void setSecurityList(List<String> securityList) {
		this.securityList = securityList;
	}

	
}
