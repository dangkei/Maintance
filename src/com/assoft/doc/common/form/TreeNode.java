package com.assoft.doc.common.form;

import java.io.Serializable;

public class TreeNode implements Serializable{
	private static final long serialVersionUID = 2807084485227147879L;

	private String id;
	private String pId;
	private String name;
	private boolean open;
	private boolean isParent;
	private boolean isDept;
	private String loginName;
	private String dn;
	private boolean nocheck;
	private boolean isLeader;
	
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public TreeNode() {
		super();
	}
	
	public TreeNode(String id, String pId, String name, boolean open, boolean isParent, boolean isDept, String loginName,
			String dn, boolean nocheck) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
		this.isDept = isDept;
		this.loginName = loginName;
		this.dn = dn;
		this.nocheck = nocheck;
	}
	public TreeNode(String id, String pId, String name, boolean open, boolean isParent) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	public boolean isDept() {
		return isDept;
	}
	public void setDept(boolean isDept) {
		this.isDept = isDept;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public boolean isNocheck() {
		return nocheck;
	}
	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}
	public boolean isLeader() {
		return isLeader;
	}
	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}
	
	
	
}
