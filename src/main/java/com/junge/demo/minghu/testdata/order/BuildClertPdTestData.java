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
import com.junge.demo.minghu.model.extobj.MrkPdItemExtObj;
import com.junge.demo.minghu.model.order.PdInfo;
import com.junge.demo.minghu.model.order.PdItemInfo;

/**
 * 构建销售测试数据
 * @author "liuxj"
 *
 */
public class BuildClertPdTestData {
	
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
		
		public PdInfo build() {
			PdInfo saleInfo = new PdInfo();
			saleInfo.setEntentity(entInfoList.get(entidx).getEntentity());
			saleInfo.setCustentity(custList.get(custidx).getCustentity());
			saleInfo.setPddate("2018-10-31");
			saleInfo.setNotes("盘点备注");
			
			List<PdItemInfo> items = new ArrayList<PdItemInfo>();
			for (int i=0; i<goodscount; i++) {
				PdItemInfo item = new PdItemInfo();
				item.setGoodsentity(goodsInfoList.get(i).getGoodsentity());
				item.setPackqty(Double.valueOf((int)(1 * Math.random())));
				item.setBulkqty(BigDecimal.valueOf(2 * Math.random()).setScale(2, 5).doubleValue());
				item.setPackunitqty(goodsInfoList.get(i).getPackunitqty());
				item.setCostvalue(BigDecimal.valueOf(10 * Math.random()).setScale(2, 5).doubleValue());
				
				MrkPdItemExtObj itemExtobj = new MrkPdItemExtObj();
				itemExtobj.setDepotname_("百草园组");
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
		
		int count = 10;
		
		RandomData randomData = new RandomDataImpl();
		
		File outputFile = new File("D:\\minghu\\clertpd.txt");
		
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
