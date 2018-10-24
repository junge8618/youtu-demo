/**
 * 
 */
package com.junge.demo.minghu.model.order;

import java.util.List;

/**
 * @author "liuxj"
 *
 */
public class PdInfo {
	private String ententity;
	private String custentity;
	private String pddate;
	private String notes;

	private List<PdItemInfo> items;

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

	public String getPddate() {
		return pddate;
	}

	public void setPddate(String pddate) {
		this.pddate = pddate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<PdItemInfo> getItems() {
		return items;
	}

	public void setItems(List<PdItemInfo> items) {
		this.items = items;
	}

}
