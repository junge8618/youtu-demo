/**
 * 
 */
package com.junge.demo.skylink;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author liuxj
 *
 */
public class MySign {
	
	public static String appSign(Map<String, String> params, String corpKey) {
		if (null == params || 0 == params.size()) {
			throw new RuntimeException("invalid params");
		}

		if (null == corpKey || "".equals(corpKey.trim())) {
			throw new RuntimeException("invalid params");
		}
		
		// 移除为值为null参数
		params = removeNullParam(params);

		// 字段名按升序排序
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		StringBuilder sb = new StringBuilder();
		for (String key : keys) {
			sb.append(key).append("=").append(params.get(key)).append("&");
		}

		sb.append("corpKey=").append(corpKey);
		
		return md5(sb.toString()).toUpperCase();
	}
	
	/**
	 * 移除key或者value为null的参数
	 * 
	 * @param params
	 * @return
	 */
	public static Map<String, String> removeNullParam(Map<String, String> params) {
		Map<String, String> result = new HashMap<String, String>();
		for (Entry<String, String> entry : params.entrySet()) {
			if (null != entry.getKey() && null != entry.getValue()) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		
		return result;
	}

	public static String md5(String source) {  
        
	    StringBuffer sb = new StringBuffer(32);  
	          
	    try {  
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        byte[] array = md.digest(source.getBytes("utf-8"));  
	              
	        for (int i = 0; i < array.length; i++) {  
	            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));  
	        }  
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return sb.toString();
	}

	public static void main(String[] args) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("corpId", "10135300");
		data.put("nonceStr", "2018062500001");
		data.put("thirdCustId", "E11000018P993");
		data.put("custName", "深圳市云端信联科技有限公司");
		data.put("custType", "2");
		data.put("socialCode", "320512000114943");
		data.put("faxCode", "9132059455117770X5");
		data.put("regState", "广东省");
		data.put("regCity", "深圳市");
		data.put("regAddress", "坂田集团商务中心1208");
		data.put("corpState", "广东省");
		data.put("corpCity", "深圳市");
		data.put("corpAddress", "坂田集团商务中心1208");
		data.put("legalName", "陆德心");
		data.put("legalIdNo", "430527197012152116");
		data.put("legalMobile", "18676653715");
		data.put("mark1", "mark1");
		
		System.out.println("synccustinfo:" + appSign(data, "rGfuztc9VgnjdPzNdqsjOwJUUIJCxWt4"));
		
		Map<String, String> data2 = new HashMap<String, String>();
		data2.put("corpId", "82969138");
		data2.put("nonceStr", "test");
		data2.put("thirdCustId", "13828936758");
		data2.put("creditStatus", null);
		data2.put("creditLimit", null);
		data2.put("remainLimit", null);
		data2.put("startDate", null);
		data2.put("endDate", null);
		data2.put("reason", null);
		data2.put("mark1", "");
		data2.put("joinOrgCode", null);
		
		System.out.println("synccreditresult:" + appSign(data2, "c6f398a5ede6646bf25f339c53c22716"));
		
		Map<String, String> data3 = new HashMap<String, String>();
		data3.put("corpId", "82969138");
		data3.put("nonceStr", "test");
		data3.put("thirdCustId", "13828936758");
		data3.put("custName", "深圳市****有限公司");
		data3.put("custType", "2");
		data3.put("socialCode", "");
		data3.put("faxCode", "");
		data3.put("regState", "");
		data3.put("regCity", "");
		data3.put("regAddress", "");
		data3.put("corpState", "");
		data3.put("corpCity", "");
		data3.put("corpAddress", "");
		data3.put("legalName", "");
		data3.put("legalIdNo", "");
		data3.put("legalMobile", "");
		data3.put("mark1", "");
		
		System.out.println("data3:" + appSign(data3, "c6f398a5ede6646bf25f339c53c22716"));
	}
}
