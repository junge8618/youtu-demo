/**
 * 
 */
package com.junge.demo.minghu.model.order;

import com.junge.demo.minghu.model.extobj.SaleItemExtObj;

/**
 * @author "liuxj"
 *
 */
public class SaleItemInfo {
	private String goodsentity;
	private Double bulkprice;
	private Double packprice;
	private Double bulkqty;
	private Double packqty;
	private Double giftqty;
	private Double packunitqty;
	private String notes;
	private SaleItemExtObj extobj;

	public String getGoodsentity() {
		return goodsentity;
	}

	public void setGoodsentity(String goodsentity) {
		this.goodsentity = goodsentity;
	}

	public Double getBulkprice() {
		return bulkprice;
	}

	public void setBulkprice(Double bulkprice) {
		this.bulkprice = bulkprice;
	}

	public Double getPackprice() {
		return packprice;
	}

	public void setPackprice(Double packprice) {
		this.packprice = packprice;
	}

	public Double getBulkqty() {
		return bulkqty;
	}

	public void setBulkqty(Double bulkqty) {
		this.bulkqty = bulkqty;
	}

	public Double getPackqty() {
		return packqty;
	}

	public void setPackqty(Double packqty) {
		this.packqty = packqty;
	}

	public Double getGiftqty() {
		return giftqty;
	}

	public void setGiftqty(Double giftqty) {
		this.giftqty = giftqty;
	}

	public Double getPackunitqty() {
		return packunitqty;
	}

	public void setPackunitqty(Double packunitqty) {
		this.packunitqty = packunitqty;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public SaleItemExtObj getExtobj() {
		return extobj;
	}

	public void setExtobj(SaleItemExtObj extobj) {
		this.extobj = extobj;
	}

}
