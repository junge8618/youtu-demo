/**
 * 
 */
package com.junge.demo.minghu.model.order;

import java.util.List;

import com.junge.demo.minghu.model.extobj.SaleExtObj;

/**
 * @author "liuxj"
 *
 */
public class SaleInfo {
	private String ententity;
	private String refsheetid;
	private String custentity;
	private String deliveryaddress;
	private String contact;
	private String contactmobile;
	private String contacttele;
	private Double discvalue;
	private String deliverydate;
	private String saler;
	private String notes;
	private Integer sendtype;
	private String createtime;
	private SaleExtObj extobj;
	private List<SaleItemInfo> items;

	public String getEntentity() {
		return ententity;
	}

	public void setEntentity(String ententity) {
		this.ententity = ententity;
	}

	public String getRefsheetid() {
		return refsheetid;
	}

	public void setRefsheetid(String refsheetid) {
		this.refsheetid = refsheetid;
	}

	public String getCustentity() {
		return custentity;
	}

	public void setCustentity(String custentity) {
		this.custentity = custentity;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactmobile() {
		return contactmobile;
	}

	public void setContactmobile(String contactmobile) {
		this.contactmobile = contactmobile;
	}

	public String getContacttele() {
		return contacttele;
	}

	public void setContacttele(String contacttele) {
		this.contacttele = contacttele;
	}

	public Double getDiscvalue() {
		return discvalue;
	}

	public void setDiscvalue(Double discvalue) {
		this.discvalue = discvalue;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getSaler() {
		return saler;
	}

	public void setSaler(String saler) {
		this.saler = saler;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getSendtype() {
		return sendtype;
	}

	public void setSendtype(Integer sendtype) {
		this.sendtype = sendtype;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public SaleExtObj getExtobj() {
		return extobj;
	}

	public void setExtobj(SaleExtObj extobj) {
		this.extobj = extobj;
	}

	public List<SaleItemInfo> getItems() {
		return items;
	}

	public void setItems(List<SaleItemInfo> items) {
		this.items = items;
	}
	
}
