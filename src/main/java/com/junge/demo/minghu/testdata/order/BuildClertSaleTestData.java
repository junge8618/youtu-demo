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
import com.junge.demo.minghu.model.extobj.MrkSaleExtObj;
import com.junge.demo.minghu.model.extobj.MrkSaleItemExtObj;
import com.junge.demo.minghu.model.order.ClerkSaleInfo;
import com.junge.demo.minghu.model.order.ClerkSaleItemInfo;

/**
 * 构建销售测试数据
 * @author "liuxj"
 *
 */
public class BuildClertSaleTestData {
	
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
		
		public Builder(int custidx, int entidx, int goodscount) {
			this.custidx = custidx;
			this.entidx = entidx;
			this.goodscount = goodscount;
		}
		
		public ClerkSaleInfo build() {
			ClerkSaleInfo saleInfo = new ClerkSaleInfo();
			saleInfo.setEntentity(entInfoList.get(entidx).getEntentity());
			saleInfo.setCustentity(custList.get(custidx).getCustentity());
			saleInfo.setSaledate("2018-10-31");
			saleInfo.setNotes("盘点备注");
			
			MrkSaleExtObj extobj = new MrkSaleExtObj();
			extobj.setCustid_("00123");
			saleInfo.setExtobj(extobj);
			
			List<ClerkSaleItemInfo> items = new ArrayList<ClerkSaleItemInfo>();
			for (int i=0; i<goodscount; i++) {
				ClerkSaleItemInfo item = new ClerkSaleItemInfo();
				item.setGoodsentity(goodsInfoList.get(i).getGoodsentity());
				item.setSaleqty(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
				item.setRetqty(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
				item.setGiftqty(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
				item.setSalevalue(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
				
				MrkSaleItemExtObj itemExtobj = new MrkSaleItemExtObj();
				itemExtobj.setPurvalue_(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
				itemExtobj.setHasvalue_(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
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
		
		File outputFile = new File("D:\\minghu\\clertsale.txt");
		
		for (int i=1; i<=count; i++) {
			int custidx = randomData.nextInt(0, custList.size() - 1);
			int entidx = randomData.nextInt(0, entInfoList.size() - 1);
			int goodscount = randomData.nextInt(1, goodsInfoList.size());
			
			Builder builder = new Builder(custidx, entidx, goodscount);
			try {
				FileUtils.writeLines(outputFile, Arrays.asList(JSONObject.toJSONString(builder.build())), "\n", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println("fin");
	}


}
