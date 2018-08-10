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
 * @author liuxj
 *
 */
public class FileParseTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			List<String> lines = FileUtils.readLines(new File("D:\\localhost_access_log.2018-08-08.txt"), "UTF-8");
			for (String line : lines) {
				int handleTime = getHandleTime(line);
				if (handleTime > 1000) {
					FileUtils.writeLines(new File("D:\\result_1000.log"), Arrays.asList(line + "\n"), "UTF-8", true);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getHandleTime(String line) {
		String[] strs = line.split(" ");
		String handleTime = strs[strs.length - 1];
		if (null != handleTime && !"-".equalsIgnoreCase(handleTime)) {
			return Integer.valueOf(handleTime);
		}
		return 0;
	}
}
