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
public class FileParseTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			List<String> lines = FileUtils.readLines(new File("D:\\zdbpssvender-server.log"), "UTF-8");
			for (String line : lines) {
				int handleTime = getHandleTime(line);
				if (handleTime > 5000) {
					FileUtils.writeLines(new File("D:\\zdbpssvender-server_5000.log"), Arrays.asList(line + "\n"), "UTF-8", true);
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
