/**
 * 
 */
package com.junge.demo.fileparse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/**
 * @author liuxj
 *
 */
public class FileParseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Map<String, List<String>> result = new HashMap<String, List<String>>();
			List<String> lines = FileUtils.readLines(new File("D:\\lxjaccess.log"), "UTF-8");
			for (String line : lines) {
				String accessToken = getAccessToken(line);
				if (null == accessToken) {
					continue;
				}
				if (!result.containsKey(accessToken)) {
					result.put(accessToken, new ArrayList<String>());
				}
				
				result.get(accessToken).add(line + "\n");
			}
			
			for (String accessToken : result.keySet()) {
				if (result.get(accessToken).size() > 5) {
					FileUtils.writeLines(new File("D:\\access_result.log"), Arrays.asList("\n"+accessToken + ":####################\n"), "UTF-8", true);
					FileUtils.writeLines(new File("D:\\access_result.log"), result.get(accessToken), "UTF-8", true);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getAccessToken(String line) {
		if (!line.contains("/zdbpssvender-pc/visit/order/create")) {
			return null;
		}
		
		String[] strs = line.split("&accessToken=");
		String[] strs2 = strs[1].split("=");
		
		return strs2[0];
	}
}
