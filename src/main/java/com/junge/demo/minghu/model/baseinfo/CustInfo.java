package com.junge.demo.minghu.model.baseinfo;

import java.util.List;

public class CustInfo {
	private String custentity;
	private String parentcustentity;
	// 是否连锁 默认为非，1-连锁关系
	private Integer chainflag;
	private String custname;
	private String notes;
	private String contact;
	private String contacttele;
	private String contactmobile;
	private String helpcode;
	private String mycode;
	private String qq;
	private String email;
	private Integer areaid;
	private String address;
	private Double latitude;
	private Double longitude;
	private String baiduaddr;
	private String logofile;
	private String faxno;
	private String extobj;
	private List<String> entlist;

	public String getCustentity() {
		return custentity;
	}

	public void setCustentity(String custentity) {
		this.custentity = custentity;
	}

	public String getParentcustentity() {
		return parentcustentity;
	}

	public void setParentcustentity(String parentcustentity) {
		this.parentcustentity = parentcustentity;
	}

	public Integer getChainflag() {
		return chainflag;
	}

	public void setChainflag(Integer chainflag) {
		this.chainflag = chainflag;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContacttele() {
		return contacttele;
	}

	public void setContacttele(String contacttele) {
		this.contacttele = contacttele;
	}

	public String getContactmobile() {
		return contactmobile;
	}

	public void setContactmobile(String contactmobile) {
		this.contactmobile = contactmobile;
	}

	public String getHelpcode() {
		return helpcode;
	}

	public void setHelpcode(String helpcode) {
		this.helpcode = helpcode;
	}

	public String getMycode() {
		return mycode;
	}

	public void setMycode(String mycode) {
		this.mycode = mycode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getBaiduaddr() {
		return baiduaddr;
	}

	public void setBaiduaddr(String baiduaddr) {
		this.baiduaddr = baiduaddr;
	}

	public String getLogofile() {
		return logofile;
	}

	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}

	public String getFaxno() {
		return faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	public String getExtobj() {
		return extobj;
	}

	public void setExtobj(String extobj) {
		this.extobj = extobj;
	}

	public List<String> getEntlist() {
		return entlist;
	}

	public void setEntlist(List<String> entlist) {
		this.entlist = entlist;
	}
}
