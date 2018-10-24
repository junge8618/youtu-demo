/**
 * 
 */
package com.junge.demo.minghu.testdata.baseinfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONObject;
import com.junge.demo.minghu.model.baseinfo.GoodsInfo;

/**
 * 构建企业测试数据
 * @author "liuxj"
 *
 */
public class BuildGoodsTestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = 1000;
		long barcode = 9588878200000L;
		int goodsentity = 10000;
		
		List<String> entlist = buildEntList();
		
		File outputFile = new File("D:\\minghu\\goodsinfo.txt");
		
		for (int i=1; i<=count; i++) {
			GoodsInfo goods = new GoodsInfo();
			goods.setGoodsentity(String.valueOf(goodsentity++));
			goods.setBarcode(String.valueOf(barcode++));
			goods.setGoodsname("金冠枕式真果趣dev" + goods.getGoodsentity());
			goods.setSpec("560ml");
			goods.setUname("瓶");
			goods.setPackunit("件");
			goods.setPackspec("1*24");
			goods.setPackunitqty(24.0);
			goods.setBulkprice(3.0);
			goods.setPackprice(72.00);
			goods.setEntlist(entlist);
			
			try {
				FileUtils.writeLines(outputFile, Arrays.asList(JSONObject.toJSONString(goods)), "\n", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("fin");
	}

	private static List<String> buildEntList() {
		
		int count = 1000;
		int ententity = 2000;
		
		List<String> result = new ArrayList<String>();
		for (int i=1; i<=count; i++) {
			result.add(String.valueOf(ententity++));
		}
		
		return result;
	}

}
