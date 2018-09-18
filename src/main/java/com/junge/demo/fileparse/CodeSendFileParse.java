/**
 * 
 */
package com.junge.demo.fileparse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**
 * 注册服务短信发送被攻击，导致
 * @author liuxj
 *
 */
public class CodeSendFileParse {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Map<String, Integer> result = new HashMap<String, Integer>();
			List<String> lines = FileUtils.readLines(new File("D:\\smslog.txt"), "UTF-8");
			System.out.println("lines size:" + lines.size());
			for (String line : lines) {
				String ip = getSendIP(line);
				if (null == ip) {
					continue;
				}
				
				if (!result.containsKey(ip)) {
					result.put(ip, 0);
				}
				
				result.put(ip, (result.get(ip) + 1));
			}
			
			result = sortMapByValue(result);
			
			Integer count = 0;
			for (String key : result.keySet()) {
				count += result.get(key);
			}
			
			FileUtils.writeLines(new File("D:\\smslog_result.txt"), Arrays.asList(result.toString()), "UTF-8", false);
			
			System.out.println("count:" + count);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String getSendIP(String line) {
		String regEx="((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(line); 

		while (m.find()) {
			return m.group();
		}
		
		return null;
	}

	/*public static String getSendIP(String line) {
		String[] strs = line.split(" ");
		if (isboolIp(strs[1])) {
			return strs[1];
		}
		
		if (isboolIp(strs[2])) {
			return strs[2];
		}
		
		if (isboolIp(strs[3])) {
			return strs[3];
		}
		
		if (isboolIp(strs[4])) {
			return strs[4];
		}
		
		System.out.println(line);
		return null;
	}
	
	public static boolean isboolIp(String ipAddress)  
	{  
	       String ip = "(?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))";   
	       Pattern pattern = Pattern.compile(ip);   
	       Matcher matcher = pattern.matcher(ipAddress);   
	       return matcher.matches();   
	}*/
	
	/**
     * 使用 Map按value进行排序
     * @param map
     * @return
     */
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        
        return sortedMap;
    }
}

class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Entry<String, Integer> me1, Entry<String, Integer> me2) {

        return me1.getValue().compareTo(me2.getValue());
    }
}
