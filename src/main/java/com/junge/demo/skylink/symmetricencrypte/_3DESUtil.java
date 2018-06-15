/**
 * 
 */
package com.junge.demo.skylink.symmetricencrypte;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 3DES，也就是“Triple DES”，中文名“三重数据加密算法”，它相当于是对每个数据块应用三次 DES 加密算法。由于计算机运算能力的增强，原版
 * DES 密码的密钥长度变得容易被暴力破解；3DES 即是设计用来提供一种相对简单的方法，即通过增加 DES
 * 的密钥长度来避免类似的攻击，而不是设计一种全新的块密码算法。
 * 
 * @author "liuxj"
 *
 */
public class _3DESUtil {

	private Cipher cipher;
	private SecretKey generateKey;

	public String encode(String src) {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			keyGenerator.init(168);// size
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();

			DESedeKeySpec desKeySpec = new DESedeKeySpec(keyBytes);
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
			generateKey = secretKeyFactory.generateSecret(desKeySpec);

			cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
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

		_3DESUtil util = new _3DESUtil();
		String encodeStr = util.encode(str);
		System.out.println(encodeStr);
		System.out.println(util.decode(encodeStr));

	}

}
