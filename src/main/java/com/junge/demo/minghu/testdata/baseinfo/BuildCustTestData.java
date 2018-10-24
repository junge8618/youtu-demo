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
import com.junge.demo.minghu.model.baseinfo.CustInfo;

/**
 * 构建企业测试数据
 * @author "liuxj"
 *
 */
public class BuildCustTestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = 10000;
		long mobileno = 13810020000L;
		int ententity = 10000;
		
		List<String> entlist = buildEntList();
		
		File outputFile = new File("D:\\minghu\\custinfo.txt");
		
		for (int i=1; i<=count; i++) {
			CustInfo ent = new CustInfo();
			ent.setCustentity(String.valueOf(ententity++));
			ent.setCustname("明湖门店" + i);
			ent.setNotes("明湖百货的门店");
			ent.setContact("李先生");
			ent.setContacttele("0755-98765432");
			ent.setContactmobile(String.valueOf(mobileno++));
			ent.setAddress("深圳市龙岗区坂田街道坂田集团商务中心1208");
			ent.setEntlist(entlist);
			
			try {
				FileUtils.writeLines(outputFile, Arrays.asList(JSONObject.toJSONString(ent)), "\n", true);
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
