/**
 * 
 */
package com.junge.demo.skylink;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;

/**
 * 安全加密工具
 * 
 * @author 'liuxj'
 *
 */
public class SecurityUtil {
	
	private static final Map<Character, Character> encryptTable = new HashMap<Character, Character>();
	
	private static final Map<Character, Character> decryptTable = new HashMap<Character, Character>();
	
	static {
		encryptTable.put('A', 'm');
		encryptTable.put('a', 'M');
		encryptTable.put('B', 'd');
		encryptTable.put('b', 'D');
		encryptTable.put('C', 'x');
		encryptTable.put('c', 'X');
		encryptTable.put('D', 'u');
		encryptTable.put('d', 'U');
		encryptTable.put('E', 'p');
		encryptTable.put('e', 'P');
		encryptTable.put('F', 'i');
		encryptTable.put('f', 'I');
		encryptTable.put('G', 'b');
		encryptTable.put('g', 'B');
		encryptTable.put('H', 'e');
		encryptTable.put('h', 'E');
		encryptTable.put('I', 'j');
		encryptTable.put('i', 'J');
		encryptTable.put('J', 'c');
		encryptTable.put('j', 'C');
		encryptTable.put('K', 't');
		encryptTable.put('k', 'T');
		encryptTable.put('L', 'n');
		encryptTable.put('l', 'N');
		encryptTable.put('M', 'k');
		encryptTable.put('m', 'K');
		encryptTable.put('N', 'o');
		encryptTable.put('n', 'O');
		encryptTable.put('O', 'g');
		encryptTable.put('o', 'G');
		encryptTable.put('P', 'w');
		encryptTable.put('p', 'W');
		encryptTable.put('Q', 'r');
		encryptTable.put('q', 'R');
		encryptTable.put('R', 's');
		encryptTable.put('r', 'S');
		encryptTable.put('S', 'f');
		encryptTable.put('s', 'F');
		encryptTable.put('T', 'y');
		encryptTable.put('t', 'Y');
		encryptTable.put('U', 'v');
		encryptTable.put('u', 'V');
		encryptTable.put('V', 'l');
		encryptTable.put('v', 'L');
		encryptTable.put('W', 'z');
		encryptTable.put('w', 'Z');
		encryptTable.put('X', 'q');
		encryptTable.put('x', 'Q');
		encryptTable.put('Y', 'a');
		encryptTable.put('y', 'A');
		encryptTable.put('Z', 'h');
		encryptTable.put('z', 'H');
		encryptTable.put('0', '9');
		encryptTable.put('1', '5');
		encryptTable.put('2', '6');
		encryptTable.put('3', '3');
		encryptTable.put('4', '7');
		encryptTable.put('5', '0');
		encryptTable.put('6', '8');
		encryptTable.put('7', '2');
		encryptTable.put('8', '4');
		encryptTable.put('9', '1');
		
		Set<Character> keys = encryptTable.keySet();
		for (Character key : keys) {
			decryptTable.put(encryptTable.get(key), key);
		}
	}
	
	private SecurityUtil() {
		
	}
	
	private static final Character getEncryptChar(Character inputChar) {
		Character result = encryptTable.get(inputChar);
		if (null == result) {
			return inputChar;
		}
		
		return result;
	}
	
	private static final Character getdecryptChar(Character inputChar) {
		Character result = decryptTable.get(inputChar);
		if (null == result) {
			return inputChar;
		}
		
		return result; 
	}
	
	/**
	 * 加密处理
	 * 
	 * @param inputStr
	 * @return
	 */
	public static final String encrypt(String inputStr) {
		if (null == inputStr) {
			return inputStr;
		}
		
		// 转成base64
		String base64Str = Base64.encodeBase64String(inputStr.getBytes());
		
		// 加密
		StringBuilder outputStr = new StringBuilder();
		for (int i=0; i<base64Str.length(); i++) {
			outputStr.append(getEncryptChar(base64Str.charAt(i)));
		}
		
		return outputStr.toString();
	}
	
	/**
	 * 解密处理
	 * @param inputStr
	 * @return
	 */
	public static final String decrypt(String inputStr) {
		if (null == inputStr) {
			return inputStr;
		}
		
		StringBuilder outputStr = new StringBuilder();
		for (int i=0; i<inputStr.length(); i++) {
			outputStr.append(getdecryptChar(inputStr.charAt(i)));
		}
		
		return new String(Base64.decodeBase64(outputStr.toString()));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JSONObject json = new JSONObject();
		json.put("eid", 11000018);
		json.put("creditstatus", "03");
		json.put("creditlimit", "500000");
		json.put("remainlimit", "300000");
		json.put("startdate", "20180614");
		json.put("enddate", "20190614");
		json.put("reason", "reason");
		json.put("mark1", "mark1");
		json.put("test", "SDFSDF");
		
		String encryptStr = encrypt(json.toJSONString());
		System.out.println(encryptStr);
		System.out.println(decrypt(encryptStr));
		System.out.println(json.toJSONString());
	}

}
