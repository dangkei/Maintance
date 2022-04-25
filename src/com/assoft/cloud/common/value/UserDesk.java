package com.assoft.cloud.common.value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * 用户桌面
 * @author wzj
 */
public class UserDesk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DeskItem> items=new ArrayList<DeskItem>();

	private String deskType;
	private String loginName;
	
	private String mode;//模式
	
	private String skin;//皮肤，图片路径
	
	private String skinType;//皮肤类型 1系统皮肤2.自定义皮肤
	
	//<id,DeskServiceItem>
	private Map<String, DeskServiceItem> serviceMap=null;//服务map值
	
	private Map<String, DeskGroupItem> groupMap=null;//分组map值
	
	private String lastTime;
	
	
	private boolean forceUpdate=false;
	
	private boolean logout=false;
	
	/**
	 * 初始化条目信息
	 * @param aitems
	 */
	public synchronized void initItems(List<DeskItem> aitems){
		//this.items=aitems;<id,DeskServiceItem>
		serviceMap=new HashMap<String, DeskServiceItem>();
		groupMap=new HashMap<String, DeskGroupItem>();
		for(DeskItem item:aitems){
			insertItem(item);
		}
	}
	
	/**
	 * 删除服务
	 * @param type
	 * @param name
	 */
	public synchronized void removeItem(String type,String name){
		Iterator<DeskItem> iterator=items.iterator();
		while(iterator.hasNext()){
			DeskItem item=iterator.next();
			if(item.getType().equals(type)&&item.getName().equals(name)){
				
				iterator.remove();
				
				if(item instanceof DeskGroupItem) {
					groupMap.remove(name);
				}else {
					DeskServiceItem sItem=(DeskServiceItem)item;
					serviceMap.remove(sItem.getId());
					
				}
				
				
			}
		}
		reSetPos();
	    //reSort();
	}
	
	/**
	 * 重新设置
	 * @param list
	 */
	public synchronized void resetItemPoses(List<Map<String, Object>> list){
		if(list!=null){
			for(Map<String, Object> map:list){
				
				String type=(String)map.get("type");
				int pos=(Integer)map.get("pos");
				if("service".equals(type)){
					String id=(String)map.get("id");
					DeskServiceItem item=serviceMap.get(id);
					if(item!=null){
						item.setPos(pos);
					}
				}else if("group".equals(type)){
					String name=(String)map.get("name");
					DeskGroupItem item=groupMap.get(name);
					if(item!=null){
						item.setPos(pos);
					}
				}
			}
			reSort();
			reSetPos();
		}
	}
	
	public synchronized void resetGroupItemPoses(String groupName,List<Map<String, Object>> list){
		if(list!=null){
			DeskGroupItem groupItem=groupMap.get(groupName);
		
			for(Map<String, Object> map:list){
				String id=(String)map.get("id");
				String type=(String)map.get("type");
				Integer pos=(Integer)map.get("pos");
				
				if("service".equals(type)){
					DeskServiceItem item=serviceMap.get(id);
					item.setPos(pos);
				}
			}
			Collections.sort(groupItem.getServiceList(), new Comparator<DeskServiceItem>() {

				@Override
				public int compare(DeskServiceItem o1, DeskServiceItem o2) {
					Integer p1=o1.getPos();
					Integer p2=o2.getPos();
					return p1.compareTo(p2);
				}
			});
			
		}
	}
	
	
	
	
	/**
	 * 向item中塞入
	 * @param itemList
	 */
	 public synchronized void insertItems(List<DeskItem> itemList) {
			int pos=0;
			if(items!=null&&items.size()>0){
				DeskItem litem=items.get(items.size()-1);
			    pos=litem.getPos()+1;
			} 
			
			for(DeskItem item:itemList){
				if(item.getPos()==0){//初始状态，加入队尾
					item.setPos(pos);
				}	
			    insertItem(item);
			}
			reSort();
			reSetPos();
		}
	    
	
	 
	 public synchronized void insertItem(DeskItem item){
		  
			String name=item.getName();
			if(item instanceof DeskServiceItem){
				DeskServiceItem serviceItem=(DeskServiceItem)item;
				String serviceId=serviceItem.getId();
				if(serviceMap.get(serviceId)==null){//服务map中不存在
					serviceMap.put(serviceItem.getId(), serviceItem);
				 	items.add(item);
				}
				
			}else if(item instanceof DeskGroupItem){
				DeskGroupItem groupItem=(DeskGroupItem)item;
				if(groupMap.get(name)==null){//组map中不存在
					List<DeskServiceItem> serviceItems=groupItem.getServiceList();
					if(serviceItems!=null){
						for(DeskServiceItem serviceItem:serviceItems){
							String sid=serviceItem.getId();
							DeskServiceItem aItem=serviceMap.get(sid);
							if(aItem==null){
								serviceMap.put(sid, serviceItem);
							}
						}
					}
					
					groupMap.put(name, groupItem);
					
				 	items.add(item);
				}
				
				
			}
	 }
	 
	 
	
	/**
	 * 重新按照顺序排序
	 */
	public synchronized void reSort(){
		Collections.sort(items,new Comparator<DeskItem>() {
			@Override
			public int compare(DeskItem o1, DeskItem o2) {
				Integer pos1=o1.getPos();
				Integer pos2=o2.getPos();
				return pos1.compareTo(pos2);
			}
		});
	}
	
	/**
	 * 重新设置pos
	 */
	public synchronized void reSetPos(){
		int pos=0;
		for(DeskItem item:items){
			item.setPos(pos++);
		}
	}
	
	
	public String getSkinType() {
		return skinType;
	}

	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}

	public List<DeskItem> getItems() {
		return items;
	}

	public void setItems(List<DeskItem> items) {
		this.items = items;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public Map<String, DeskServiceItem> getServiceMap() {
		return serviceMap;
	}

	public void setServiceMap(Map<String, DeskServiceItem> serviceMap) {
		this.serviceMap = serviceMap;
	}

	public Map<String, DeskGroupItem> getGroupMap() {
		return groupMap;
	}

	public void setGroupMap(Map<String, DeskGroupItem> groupMap) {
		this.groupMap = groupMap;
	}

	public String getDeskType() {
		return deskType;
	}

	public void setDeskType(String deskType) {
		this.deskType = deskType;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public boolean isForceUpdate() {
		return forceUpdate;
	}

	public void setForceUpdate(boolean forceUpdate) {
		this.forceUpdate = forceUpdate;
	}

	public boolean isLogout() {
		return logout;
	}

	public void setLogout(boolean logout) {
		this.logout = logout;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	
	
	
	
	
	
}
