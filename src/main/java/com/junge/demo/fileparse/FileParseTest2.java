/**
 * 
 */
package com.junge.demo.fileparse;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

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

			List<String> lines = FileUtils.readLines(new File("D:\\localhost_access_log.2019-01-22.txt"), "UTF-8");
			List<SortData> result = new ArrayList<SortData>();
			for (String line : lines) {
				if (!line.contains("salegoods")) {
					continue;
				}
				int handleTime = getHandleTime(line);
				if (handleTime <= 100) {
					continue;
				}

				result.add(new SortData(handleTime, line));
			}

			Collections.sort(result, new Comparator<SortData>() {
				public int compare(SortData o1, SortData o2) {
					return o2.getHandletime().compareTo(o1.getHandletime());
				}
			});

			for (SortData sortData : result) {
				FileUtils.writeLines(new File("D:\\result_500.log"), Arrays.asList(sortData.getContent()), true);
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

class SortData {
	private Integer handletime;
	private String content;

	public SortData(Integer handletime, String content) {
		this.handletime = handletime;
		this.content = content;
	}

	public Integer getHandletime() {
		return handletime;
	}

	public void setHandletime(Integer handletime) {
		this.handletime = handletime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
