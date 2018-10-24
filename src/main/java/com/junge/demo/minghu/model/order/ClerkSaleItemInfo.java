/**
 * 
 */
package com.junge.demo.minghu.model.order;

import com.junge.demo.minghu.model.extobj.MrkSaleItemExtObj;

/**
 * @author "liuxj"
 *
 */
public class ClerkSaleItemInfo {

	private String goodsentity;
	private Double saleqty;
	private Double retqty;
	private Double giftqty;
	private Double salevalue;
	private MrkSaleItemExtObj extobj;

	public String getGoodsentity() {
		return goodsentity;
	}

	public void setGoodsentity(String goodsentity) {
		this.goodsentity = goodsentity;
	}

	public Double getSaleqty() {
		return saleqty;
	}

	public void setSaleqty(Double saleqty) {
		this.saleqty = saleqty;
	}

	public Double getRetqty() {
		return retqty;
	}

	public void setRetqty(Double retqty) {
		this.retqty = retqty;
	}

	public Double getGiftqty() {
		return giftqty;
	}

	public void setGiftqty(Double giftqty) {
		this.giftqty = giftqty;
	}

	public Double getSalevalue() {
		return salevalue;
	}

	public void setSalevalue(Double salevalue) {
		this.salevalue = salevalue;
	}

	public MrkSaleItemExtObj getExtobj() {
		return extobj;
	}

	public void setExtobj(MrkSaleItemExtObj extobj) {
		this.extobj = extobj;
	}

}
