/**
 * 
 */
package com.junge.demo.minghu.model.order;

import com.junge.demo.minghu.model.extobj.MrkPdItemExtObj;

/**
 * @author "liuxj"
 *
 */
public class PdItemInfo {

	private String goodsentity;
	private Double packqty;
	private Double bulkqty;
	private Double packunitqty;
	private String batchid;
	private Double costvalue;
	private MrkPdItemExtObj extobj;

	public String getGoodsentity() {
		return goodsentity;
	}

	public void setGoodsentity(String goodsentity) {
		this.goodsentity = goodsentity;
	}

	public Double getPackqty() {
		return packqty;
	}

	public void setPackqty(Double packqty) {
		this.packqty = packqty;
	}

	public Double getBulkqty() {
		return bulkqty;
	}

	public void setBulkqty(Double bulkqty) {
		this.bulkqty = bulkqty;
	}

	public Double getPackunitqty() {
		return packunitqty;
	}

	public void setPackunitqty(Double packunitqty) {
		this.packunitqty = packunitqty;
	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	public Double getCostvalue() {
		return costvalue;
	}

	public void setCostvalue(Double costvalue) {
		this.costvalue = costvalue;
	}

	public MrkPdItemExtObj getExtobj() {
		return extobj;
	}

	public void setExtobj(MrkPdItemExtObj extobj) {
		this.extobj = extobj;
	}

}
