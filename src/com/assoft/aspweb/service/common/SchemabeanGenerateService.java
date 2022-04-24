package com.assoft.aspweb.service.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assoft.asopUtil.common.tool.util.Utils;
import com.assoft.aspweb.service.bussiness.AppCataService;
import com.assoft.giss.common.entity.AsopCata;
import com.assoft.giss.common.entity.AsopMetaElement;
import com.assoft.giss.common.exchange.MetaElementTool;
import com.assoft.giss.common.form.SchemaForm;
import com.assoft.giss.common.value.AssoftAttrType;
import com.assoft.velocity.beangenerator.BeanGeneratorBaseInfo;
import com.assoft.velocity.beangenerator.BeanVariable;
import com.assoft.velocity.beangenerator.JavaBeanGeneartorUtil;
import com.assoft.velocity.beangenerator.JavaBeanSrcGenerator;

/**
 * 
 * @author wzj
 */
@Service
public class SchemabeanGenerateService {

	@Autowired
	AppCataService appCataService;
	@Autowired
	LocalService localService;
	/**
	 * 生成方案类服务
	 * @param appName
	 * @param schemaName
	 */
	public void generateSchema(String appName,String schemaName){
		AspInfo info=localService.loadAspInfo();
		
		
		//SchemaForm form=localService.metaElementTool().loadSchemaForm(appName, schemaName);
		AsopCata schemaCata=info.loadSchemaCata(schemaName);
		if(schemaCata == null) return;
		String schemaTitle=schemaCata.getTitle();
		
		String className="Aschema"+capName(schemaName);
		String pkgName="com.assoft."+appName+".common.schema";
		BeanGeneratorBaseInfo baseInfo=new BeanGeneratorBaseInfo("src", pkgName, className);
		//Map<String, String> map=buildDefaultMap();
		//
		
		//1. 获得方案元数据列表
		List<AsopMetaElement> list=info.loadSchemaElements(schemaName);
		//String[] dataTypes={"select","classdataref","contentdataref","person","dept"};
		String[] dataTypes={"select","person","dept","group"};		//预定义四种类型  ？,人员，部门，群组
		for(AsopMetaElement element:list){
			String shortName=element.getShortName();		//元数据元素短名对应类属性名称
			String dataType=element.getDataType();			//元素数据类型
			String multi=element.getMulti();				//单值或者多值
			String des=element.getTitle()+appendElement(element);	//元数据描述
			if((AssoftAttrType.APPENDIX.equals(dataType)||AssoftAttrType.IMG.equals(dataType))){
				//如果元素类型为附件类型或图片类型
				BeanVariable bv=new BeanVariable();
				if("1".equals(multi)){
					bv.setType("List<AssoftFileObj>");
				}else{
					bv.setType("AssoftFileObj");
				}
				bv.setName(shortName);
				bv.setDescription(des);
				baseInfo.appendVa(bv);
				continue;
			}
				/***处理数值和字符串类型*****/
				String type=buildBeanVariableType(dataType, multi);
				if("integer".equals(type)){
					baseInfo.appendIntVa(shortName, des);
				}else if("string".equals(type)){
					baseInfo.appendStringVa(shortName, des);
				}else if("List<String>".equals(type)){
					baseInfo.appendListStringVa(shortName, des);
				}
				
				/***如果元素类型为预定义类型 ? 人员，部门，群组，元素类型定义*****/
				if(Utils.contain(dataTypes, dataType)){
					if("1".equals(multi)){
						baseInfo.appendListStringVa(shortName+"Name", des+"名称");
						
					}else{
						baseInfo.appendStringVa(shortName+"Name", des+"名称");	
					}
					
				}
				
				if("dept".equals(dataType)||"group".equals(dataType)){
					if("1".equals(multi)){
						baseInfo.appendListStringVa(shortName+"FullName", des+"全称");
						//baseInfo.appendListStringVa(shortName+"Id", des+"标识");
					}else{
						baseInfo.appendStringVa(shortName+"FullName", des+"全称");
						//baseInfo.appendStringVa(shortName+"Id", des+"标识");
					}
				}
				
			
				if("richtext".equals(dataType)) {
					
					BeanVariable bv=new BeanVariable();
				
					bv.setType("List<AssoftFileObj>");
					
					
					bv.setName(shortName+"Files");
					
					bv.setDescription(des+"附件");
					baseInfo.appendVa(bv);
					//baseInfo.appendListStringVa(shortName+"Files", des+"附件");
				}
		}
		String filePath="com/assoft/aspweb/common/schema/bean.txt";
		String velocityCon=JavaBeanGeneartorUtil.readClassLoaderResouceCon(filePath);
	
		AsopCata cata=info.loadSchemaCata(schemaName);
		String atype=cata.metaValue("classification");
	
		
		List<Object[]> params=buildSchemaParams(schemaName);
		params.add(buildParams("schemaTitle", schemaTitle));
		params.add(buildParams("type", atype));
		//params.add(buildParams("physicalDeletion", physicalDeletion));
	
		JavaBeanSrcGenerator.getInstance().generateJavaSrcFile(baseInfo,velocityCon,params);
		
	}
	
	
	
	
	public String appendElement(AsopMetaElement element) {
		
		
		String string=" ";
		String dataType=element.getDataType();
		if("select".equals(dataType)) {
			List<Map<String,String>> range=element.getRange();
			if(range!=null) {
				for(Map<String, String> map:range) {
					String name=map.get("name");
					String value=map.get("value");
					string+=" "+value+":"+name;
				}
			}
		}
		
		string+=" "+delHtmlTag(element.getNote());
		return string;
	}
	
	public String delHtmlTag(String str){ 
		if(Utils.isEmpty(str)) {
	    	return "";
	    }
	    StringBuilder builder = new StringBuilder("  NOTE："); 
	    builder.append(str);
	    String newstr=builder.toString();
	    newstr=newstr.replaceAll("&lt;", "<");
	    newstr=newstr.replaceAll("&gt;", ">");
	    newstr = newstr.replaceAll("<[.[^>]]*>","");
	    //newstr = newstr.replaceAll(" ", ""); 
	   //newstr=StringFilter(newstr);
	   
	   newstr=decodeby10(newstr);
	    return newstr;
	}
	public Class getClassByMetaschemaName(String schemaName){
		
		String appName=appCataService.loadAppName();
		String pkgName="com.assoft."+appName+".common.schema";
		String className=pkgName+".Aschema"+capName(schemaName);
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public     String StringFilter(String   str)   throws   PatternSyntaxException   {       
        // 只允许字母和数字         
       String   regEx  =  "[^a-zA-Z0-9]";      
           
   // 清除掉所有特殊字符    
 // String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";    
  Pattern   p   =   Pattern.compile(regEx);       
  Matcher   m   =   p.matcher(str);       
  return   m.replaceAll("").trim();       
}       

	
	
	public static String decodeby10(String str) {
	    StringBuffer out = new StringBuffer();
	    if (str == null || ("".equals(str)))
	        return "";
	    char[] chars = str.toCharArray();
	    for(int i = 0; i < chars.length; i ++) {
	        if((chars[i] >= 19968 && chars[i] <= 40869) //中日朝兼容形式的unicode编码范围： U+4E00——U+9FA5
	        || (chars[i] >= 11904 && chars[i] <= 42191)//中日朝兼容形式扩展
	        || (chars[i] >= 63744 && chars[i] <= 64255)//中日朝兼容形式扩展
	        || (chars[i] >= 65072 && chars[i] <= 65103)//中日朝兼容形式扩展
	        || (chars[i] >= 65280 && chars[i] <= 65519)//全角ASCII、全角中英文标点、半宽片假名、半宽平假名、半宽韩文字母的unicode编码范围：U+FF00——U+FFEF
	        || (chars[i] >= 32 && chars[i] <= 126)//半角字符的unicode编码范围：U+0020-U+007e
	        || (chars[i] >= 12289 && chars[i] <= 12319)//全角字符的unicode编码范围：U+3000——U+301F
	        ) {
	            out.append(chars[i]);
	        }
	    }
	    String result=out.toString().trim();
	    result=result.replaceAll("\\?", "").replaceAll("\\*", "").replaceAll("<|>", "").replaceAll("\\|", "").replaceAll("/", "");
	    return result;

	}
	
	
	private String capName(String name){
		 if(name!=null&&!name.equals("")){
				char first=Character.toUpperCase(name.charAt(0));	
				return first+name.substring(1);
			}
		   return null;
		}
	
	
	/**
	 * 构建变量类型
	 * @param dataType 变量类型
	 * @param multi 是否多值
	 * @return
	 */
	private String buildBeanVariableType(String dataType,String multi){
		if("num".equals(dataType)){			//数字类型直接定义为integer类型
			return "integer";
		}else if(("1").equals(multi)){		//字符串多值数据类型为对应List<String>
			return "List<String>";
		}else{								//单值对应String类型
			return "string";
		}
	}
	
	
	
	private void appendByMap(BeanGeneratorBaseInfo baseInfo,Map<String, String> map){
		Iterator<Entry<String, String>> iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> entry=iterator.next();
			String name=entry.getKey();
			String description=entry.getValue();
			baseInfo.appendStringVa(name, description);
		}
	}
	
	//构建方案名称
	private List<Object[]> buildSchemaParams(String schemaName){
		List<Object[]> list=new ArrayList<Object[]>();
		Object[] objects=new Object[2];
		objects[0]="schemaName";
		objects[1]=schemaName;
		list.add(objects);
		return list;
	}
	
	
	private Object[] buildParams(String name,String value){
		Object[] objects=new Object[2];
		objects[0]=name;
		objects[1]=value;
		return objects;
	}
	
	private Map<String, String> buildDefaultMap(){
		Map<String, String> map=new LinkedHashMap<String,String>();
		//map.put("id", "唯一标识");
		//map.put("title", "标题");
		//map.put("createTime", "创建时间");
		//map.put("modifyTime", "修改时间");
		return map;
	}
	
	
	
	//活得所有方案
	public List<AsopMetaElement> listSchemaElements(SchemaForm form){
		return form.getElements();
	}
	
	
	
	


	
	
	
}
