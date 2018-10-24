/**
 * 
 */
package com.junge.demo.minghu.model.order;

import java.util.List;

import com.junge.demo.minghu.model.extobj.MrkSaleExtObj;

/**
 * @author "liuxj"
 *
 */
public class ClerkSaleInfo {

	private String ententity;
	private String custentity;
	private String saledate;
	private String notes;
	private MrkSaleExtObj extobj;
	private List<ClerkSaleItemInfo> items;

	public String getEntentity() {
		return ententity;
	}

	public void setEntentity(String ententity) {
		this.ententity = ententity;
	}

	public String getCustentity() {
		return custentity;
	}

	public void setCustentity(String custentity) {
		this.custentity = custentity;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public MrkSaleExtObj getExtobj() {
		return extobj;
	}

	public void setExtobj(MrkSaleExtObj extobj) {
		this.extobj = extobj;
	}

	public List<ClerkSaleItemInfo> getItems() {
		return items;
	}

	public void setItems(List<ClerkSaleItemInfo> items) {
		this.items = items;
	}

}
