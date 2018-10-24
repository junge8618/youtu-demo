/**
 * 
 */
package com.junge.demo.fileparse;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * @author "liuxj"
 *
 */
public class VenderServerLogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			List<String> lines = FileUtils.readLines(new File("D:\\log\\2018-09-20\\zdbpssvender-server-2018-09-20-2.log"), "UTF-8");
			for (String line : lines) {
				String handleTime = getHandleTime(line);
				if (null != handleTime) {
					FileUtils.writeLines(new File("D:\\log\\2018-09-20\\result_2018-09-20-2.log"), Arrays.asList(handleTime), true);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getHandleTime(String line) {
		if (!line.contains("PaginationInterceptor")) {
			return null;
		}
		//System.out.println(line);
		String[] strs = line.split("pool-");
		if (null == strs || strs.length != 2) {
			return null;
		}
		
		return strs[0];
	}

}
