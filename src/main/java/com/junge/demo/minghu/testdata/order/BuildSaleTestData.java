/**
 * 
 */
package com.junge.demo.minghu.testdata.order;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;

import com.alibaba.fastjson.JSONObject;
import com.junge.demo.minghu.model.baseinfo.CustInfo;
import com.junge.demo.minghu.model.baseinfo.EntInfo;
import com.junge.demo.minghu.model.baseinfo.GoodsInfo;
import com.junge.demo.minghu.model.extobj.SaleExtObj;
import com.junge.demo.minghu.model.extobj.SaleItemExtObj;
import com.junge.demo.minghu.model.order.SaleInfo;
import com.junge.demo.minghu.model.order.SaleItemInfo;

/**
 * 构建销售测试数据
 * @author "liuxj"
 *
 */
public class BuildSaleTestData {
	
	private static List<CustInfo> custList = new ArrayList<CustInfo>();
	
	private static List<EntInfo> entInfoList = new ArrayList<EntInfo>();
	
	private static List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
	
	static {
		// 初始化基础数据
		
		try {
			File entFile = new File("D:\\minghu\\entinfo.txt");
			List<String> entJsons = FileUtils.readLines(entFile, "UTF-8");
			for(String entStr : entJsons) {
				entInfoList.add(JSONObject.parseObject(entStr, EntInfo.class));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			File entFile = new File("D:\\minghu\\custinfo.txt");
			List<String> entJsons = FileUtils.readLines(entFile, "UTF-8");
			for(String entStr : entJsons) {
				custList.add(JSONObject.parseObject(entStr, CustInfo.class));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			File entFile = new File("D:\\minghu\\goodsinfo.txt");
			List<String> entJsons = FileUtils.readLines(entFile, "UTF-8");
			for(String entStr : entJsons) {
				goodsInfoList.add(JSONObject.parseObject(entStr, GoodsInfo.class));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class Builder {
		private int custidx;
		private int entidx;
		private int goodscount;
		private String orderid_;
		
		public Builder(int custidx, int entidx, int goodscount, String orderid_) {
			this.custidx = custidx;
			this.entidx = entidx;
			this.goodscount = goodscount;
			this.orderid_ = orderid_;
		}
		
		public SaleInfo build() {
			SaleInfo saleInfo = new SaleInfo();
			saleInfo.setEntentity(entInfoList.get(entidx).getEntentity());
			saleInfo.setRefsheetid(orderid_);
			saleInfo.setCustentity(custList.get(custidx).getCustentity());
			saleInfo.setDeliveryaddress("深圳市龙岗区坂田街道百草园报停");
			saleInfo.setContact("王小姐");
			saleInfo.setContacttele("0755-32165487");
			saleInfo.setContactmobile("13801380138");
			saleInfo.setDiscvalue(0.0);
			saleInfo.setDeliverydate("2018-11-07 12:30:00");
			saleInfo.setSaler("业务员");
			saleInfo.setSendtype(0);
			saleInfo.setCreatetime("2018-11-06 11:26:00");
			
			SaleExtObj extobj = new SaleExtObj();
			extobj.setOrderid_(orderid_);
			extobj.setSettletype_("货到付款");
			extobj.setValidstatus_("已完成");
			extobj.setNotes_("敬请各位供应商注意，如果送货到储运部请提前1天电话预约（0668-2518898）送货是依我司规定凭单据排队卸货，谢谢合作");
			extobj.setDepotname_("坂田库区");
			extobj.setPurchasetele_("0755-1478523");
			extobj.setPurchasefaxno_("123-456-789");
			extobj.setCreator_("创建人");
			extobj.setVendorno_("0123");
			saleInfo.setExtobj(extobj);
			
			List<SaleItemInfo> items = new ArrayList<SaleItemInfo>();
			for (int i=0; i<goodscount; i++) {
				SaleItemInfo item = new SaleItemInfo();
				item.setGoodsentity(goodsInfoList.get(i).getGoodsentity());
				item.setBulkprice(goodsInfoList.get(i).getBulkprice());
				item.setPackprice(goodsInfoList.get(i).getPackprice());
				item.setPackqty(Double.valueOf((int)(10 * Math.random())));
				item.setBulkqty(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
				item.setGiftqty(0.0);
				item.setPackunitqty(goodsInfoList.get(i).getPackunitqty());
				item.setNotes("商品备注");
				
				SaleItemExtObj itemExtobj = new SaleItemExtObj();
				itemExtobj.setReqgroup_("百草园组");
				itemExtobj.setGoodsentity("0123");
				item.setExtobj(itemExtobj);
				
				items.add(item);
			}
			
			saleInfo.setItems(items);
			
			return saleInfo;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = 1000;
		
		RandomData randomData = new RandomDataImpl();
		
		File outputFile = new File("D:\\minghu\\saleorders.txt");
		
		Long orderid_ = 9999010000L;
		
		for (int i=1; i<=count; i++) {
			int custidx = randomData.nextInt(0, custList.size() - 1);
			int entidx = randomData.nextInt(0, entInfoList.size() - 1);
			int goodscount = randomData.nextInt(1, goodsInfoList.size());
			
			Builder builder = new Builder(custidx, entidx, goodscount, String.valueOf(orderid_++));
			try {
				FileUtils.writeLines(outputFile, Arrays.asList(JSONObject.toJSONString(builder.build())), "\n", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println("fin");
	}


}
