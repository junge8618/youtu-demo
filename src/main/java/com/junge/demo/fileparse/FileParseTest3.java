/**
 * 
 */
package com.junge.demo.fileparse;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuxj
 *
 */
public class FileParseTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			List<String> lines = FileUtils.readLines(new File("D:\\log\\2018-08-11\\zdbpss-pursale-server-2018-12-03-1.log"), "UTF-8");
			for (String line : lines) {
				int handleTime = getHandleTime(line);
				if (handleTime > 2000) {
					FileUtils.writeLines(new File("D:\\log\\2018-08-11\\result_2000.log"), Arrays.asList(line + "\n"), "UTF-8", true);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getHandleTime(String line) {
		String[] strs = line.split("total time:");
		if (null == strs || strs.length != 2) {
			return 0;
		}
		
		return Integer.valueOf(strs[1]);
	}
}
