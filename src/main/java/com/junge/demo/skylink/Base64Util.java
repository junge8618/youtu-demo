/**
 * 
 */
package com.junge.demo.skylink;

import java.util.Base64;

/**
 * 把字符串转成base64格式字符串
 * 
 * @author "liuxj"
 *
 */
public class Base64Util {
	
	public static final String base64EncodeJdk8(String str) {
		byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes());
        return new String(encodeBytes);
	}
	
	public static final String base64DecodeJdk8(String str) {
		byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes());
		return new String(decodeBytes);
	}
	
	public static final String base64EncodeApacheCodec(String str) {
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
		return base64.encodeAsString(str.getBytes());
	}
	
	public static final String base64DecodeApacheCodec(String str) {
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
		return new String(base64.decode(str.getBytes()));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "thinking in java";
		String encodeBase64Str = base64EncodeJdk8(str);
		System.out.println(encodeBase64Str);
		System.out.println(base64DecodeJdk8(encodeBase64Str));
		System.out.println("----------------------------------");
		
		encodeBase64Str = base64EncodeApacheCodec(str);
		System.out.println(encodeBase64Str);
		System.out.println(base64DecodeApacheCodec(encodeBase64Str));
		

	}

}
