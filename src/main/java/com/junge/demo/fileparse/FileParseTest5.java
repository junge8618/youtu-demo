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
public class FileParseTest5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//method1();
		//method2();
		method3();

	}

	private static void method3() {
		try {

			List<XeBoData> result = new ArrayList<XeBoData>();
			List<String> lines = FileUtils.readLines(new File("D:\\log\\152\\log20190103.txt"), "GBK");
			for (String line : lines) {
				if (line.contains("耗时:") && line.contains("(5301")) {
					double handleTime = getHandleTime(line);
					XeBoData data = new XeBoData(handleTime, line);
					result.add(data);
				}

			}

			Collections.sort(result, new Comparator<XeBoData>() {
				public int compare(XeBoData o1, XeBoData o2) {
					return o2.getTime().compareTo(o1.getTime());
				}
			});

			for (XeBoData data : result) {
				FileUtils.writeLines(new File("D:\\log\\xebo_152.log"), Arrays.asList("耗时:" + data.getTime() + "(秒) : " + data.getData()), true);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void method2() {
		try {

			List<XeBoData> result = new ArrayList<XeBoData>();
			List<String> lines = FileUtils.readLines(new File("D:\\log\\sql20190103.txt"), "GBK");
			String sqltxt = null;
			for (String line : lines) {
				if (!line.contains("耗时")) {
					sqltxt = line;
					continue;
				}
				double handleTime = getHandleTime(line);
				if (handleTime > 0.2 && sqltxt.contains("15034825")) {
					XeBoData data = new XeBoData(handleTime, sqltxt);
					result.add(data);
				}
			}

			Collections.sort(result, new Comparator<XeBoData>() {
				public int compare(XeBoData o1, XeBoData o2) {
					return o2.getTime().compareTo(o1.getTime());
				}
			});

			for (XeBoData data : result) {
				FileUtils.writeLines(new File("D:\\log\\xebo_sql20190103.log"), Arrays.asList("耗时:" + data.getTime() + "(秒) : " + data.getData()), true);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void method1() {
		try {

			List<XeBoData> result = new ArrayList<XeBoData>();
			List<String> lines = FileUtils.readLines(new File("D:\\log\\sql20190102.txt"), "GBK");
			String sqltxt = null;
			for (String line : lines) {
				if (!line.contains("耗时")) {
					sqltxt = line;
					continue;
				}
				double handleTime = getHandleTime(line);
				if (handleTime > 0.5) {
					XeBoData data = new XeBoData(handleTime, sqltxt);
					result.add(data);
				}
			}

			Collections.sort(result, new Comparator<XeBoData>() {
				public int compare(XeBoData o1, XeBoData o2) {
					return o2.getTime().compareTo(o1.getTime());
				}
			});

			for (XeBoData data : result) {
				FileUtils.writeLines(new File("D:\\log\\xebo_200.log"), Arrays.asList("耗时:" + data.getTime() + "(秒) : " + data.getData()), true);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static double getHandleTime(String line) {
		String[] strs = line.split("耗时:");
		if (null == strs || strs.length != 2) {
			return 0;
		}

		String temp = strs[1];
		String[] strs2 = temp.split("[(秒)]");
		if (null == strs2 || strs2.length < 1) {
			return 0;
		}
		
		return Double.valueOf(strs2[0]);
	}
}

class XeBoData {
	private Double time;
	private String data;

	public XeBoData(Double time, String data) {
		this.time = time;
		this.data = data;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
