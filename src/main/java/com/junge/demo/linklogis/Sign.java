package com.junge.demo.linklogis;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 联易融签名
 * 
 * @author "liuxj"
 */
public class Sign {

	/**
	 * 空值返回空串
	 * 
	 * @param s
	 * @return
	 */
	private static String tidyValue(String s) {
		if (s == null || s.trim().equals("") || s.trim().equals("null")) {
			return "";
		}

		return s;
	}

	/**
	 * 请求报文中,签名原始串按以下方式组装成字符串: 1. 除 sign 字段外,所有参数按照字段名的 ascii 码升序排序后使用
	 * QueryString 的格式(即
	 * key1=value1&key2=value2...)拼接而成,空值也参与签名组串，并且将secret以&secret=
	 * secretValue拼接在最后。 2.
	 * 所有参数是指通信过程appId和实际出现的所有业务参数（即使是非必填字段,也需要参与签名，值填""不能填null）。 3.
	 * 将组成的串使用MD5算法生成32位长度的签名，并将签名转成大写。 签名原始串中,字段名和字段值都采用原始值,不进行 URL Encode。
	 * 
	 * @param params
	 * @param secret
	 * @return
	 */
	public static String appSign(Map<String, String> params, String secret) {
		if (null == params || 0 == params.size()) {
			throw new RuntimeException("invalid params");
		}

		if (null == secret || "".equals(secret.trim())) {
			throw new RuntimeException("invalid params");
		}

		List<String> keys = new ArrayList<String>(params.keySet());
		// 移除为null的key
		keys.removeAll(Collections.singleton(null));
		// 字段名按升序排序
		Collections.sort(keys);

		StringBuilder sb = new StringBuilder();
		for (String key : keys) {
			sb.append(key).append("=").append(tidyValue(params.get(key))).append("&");
		}

		sb.append("secret=").append(secret);
		
		return md5(sb.toString()).toUpperCase();
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

		Map<String, String> values = new HashMap<String, String>();
		values.put("appId", "2254556006");
		values.put("mobile", "15507588467");
		values.put("pwd", "111111111111111111");
		values.put("channel", "kingdee");
		values.put("flowStage", "1");
		values.put("thirdCustId", "990000");
		values.put("tmp", null);
		
		System.out.println(appSign(values, "rGfuztc9VgnjdPzNdqsjOwJUUIJCxWt4"));
		
	}

}
