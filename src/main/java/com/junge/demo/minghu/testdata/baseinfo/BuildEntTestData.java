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
import com.junge.demo.minghu.model.baseinfo.EntInfo;

/**
 * 构建企业测试数据
 * @author "liuxj"
 *
 */
public class BuildEntTestData {
	
	public static final String fileName = "D:\\minghu\\entinfo.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = 10;
		long mobileno = 13810010000L;
		int ententity = 2000;
		
		File outputFile = new File(fileName);
		
		for (int i=1; i<=count; i++) {
			EntInfo ent = new EntInfo();
			ent.setEntentity(String.valueOf(ententity++));
			ent.setEname("明湖供应商" + i);
			ent.setContact("张先生");
			ent.setContacttele("0755-12345678");
			ent.setContactmobile(String.valueOf(mobileno++));
			ent.setManager(ent.getContact());
			ent.setManagertele(ent.getContacttele());
			ent.setManagermobile(ent.getContactmobile());
			ent.setAddress("深圳市龙岗区坂田街道坂田集团商务中心1208");
			
			try {
				FileUtils.writeLines(outputFile, Arrays.asList(JSONObject.toJSONString(ent)), "\n", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			System.out.println(JSONObject.toJSON(FileUtils.readLines(outputFile, "UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> buildEntList() {
		List<String> result = new ArrayList<String>();
		
		try {
			File entFile = new File(fileName);
			List<String> entJsons = FileUtils.readLines(entFile, "UTF-8");
			for(String entStr : entJsons) {
				result.add(JSONObject.parseObject(entStr, EntInfo.class).getEntentity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
