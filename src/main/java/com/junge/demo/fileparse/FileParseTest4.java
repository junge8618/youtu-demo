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
public class FileParseTest4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			List<Data> result = new ArrayList<Data>();
			List<String> lines = FileUtils.readLines(new File("D:\\log\\localhost_access_log.2019-01-02.txt"), "UTF-8");
			for (String line : lines) {
				int handleTime = getHandleTime(line);
				Data data = new Data(handleTime, line);
				result.add(data);
			}

			Collections.sort(result, new Comparator<Data>() {
				public int compare(Data o1, Data o2) {
					return o2.getTime() - o1.getTime();
				}
			});

			for (Data data : result) {
				FileUtils.writeLines(new File("D:\\log\\result_200.log"), Arrays.asList("耗时:" + data.getTime() + "ms: " + data.getData()), true);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void method1() {
		try {

			List<Data> result = new ArrayList<Data>();
			List<String> lines = FileUtils.readLines(new File("D:\\log\\localhost_access_log.2019-01-02.txt"), "UTF-8");
			for (String line : lines) {
				int handleTime = getHandleTime(line);
				Data data = new Data(handleTime, line);
				result.add(data);
			}

			Collections.sort(result, new Comparator<Data>() {
				public int compare(Data o1, Data o2) {
					return o2.getTime() - o1.getTime();
				}
			});

			for (Data data : result) {
				FileUtils.writeLines(new File("D:\\log\\result_200.log"), Arrays.asList("耗时:" + data.getTime() + "ms: " + data.getData()), true);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getHandleTime(String line) {
		String[] strs = line.split(" ");
		if (null == strs) {
			return 0;
		}
		
		return Integer.valueOf(strs[strs.length - 1]);
	}
}

class Data {
	private Integer time;
	private String data;

	public Data(Integer time, String data) {
		this.time = time;
		this.data = data;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
