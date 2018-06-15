/**
 * 
 */
package com.junge.demo.skylink.symmetricencrypte;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * AES，全称为“Advanced Encryption Standard”，中文名“高级加密标准”，在密码学中又称 Rijndael
 * 加密法，是美国联邦政府采用的一种区块加密标准。AES 加密算法作为新一代的数据加密标准汇聚了强安全性、高性能、高效率、易用和灵活等优点。AES
 * 设计有三个密钥长度：128，192，256 位。相对而言，AES 的 128 密钥比 DES 的 56 密钥强了 1021 倍。
 * 
 * @author "liuxj"
 *
 */
public class AESUtil {

	private Cipher cipher;
	private SecretKey generateKey;

	public String encode(String src) {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);// size
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();

			generateKey = new SecretKeySpec(keyBytes, "AES");

			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, generateKey);
			byte[] resultBytes = cipher.doFinal(src.getBytes());

			return Hex.encodeHexString(resultBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String decode(String src) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, generateKey);
			byte[] result = Hex.decodeHex(src.toCharArray());
			return new String(cipher.doFinal(result));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "测试中文是否可以";

		AESUtil util = new AESUtil();
		String encodeStr = util.encode(str);
		System.out.println(encodeStr);
		System.out.println(util.decode(encodeStr));

	}

}
