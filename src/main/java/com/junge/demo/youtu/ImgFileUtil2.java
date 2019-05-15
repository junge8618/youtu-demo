package com.junge.demo.youtu;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

public class ImgFileUtil2 {

	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author:
	 * @CreateTime:
	 * @return
	 */
	public static String getImageStr(String imgFile) {
		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(imgFile);
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 加密
		Base64 encoder = new Base64();
		return encoder.encodeToString(data);
	}

	/**
	 * @Description: 将base64编码字符串转换为图片
	 * @Author:
	 * @CreateTime:
	 * @param imgStr
	 *            base64编码字符串
	 * @param path
	 *            图片路径-具体到文件
	 * @return
	 */
	public static boolean generateImage(String imgStr, String path) {

		if (null == imgStr) {
			return false;
		}

		Base64 decoder = new Base64();

		try {
			// 解密
			byte[] b = decoder.decode(imgStr);
			// 处理数据
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}

			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		String imgstr = getImageStr("E://三证合一营业执照.jpg");
		System.out.println(imgstr);
		
		String imgstr2 = "ss";

		generateImage(imgstr2, "E://4230_bak.jpg");
	}
}
