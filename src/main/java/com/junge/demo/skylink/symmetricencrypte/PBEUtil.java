/**
 * 
 */
package com.junge.demo.skylink.symmetricencrypte;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Hex;

/**
 * PBE，全称为“Password Base
 * Encryption”，中文名“基于口令加密”，是一种基于密码的加密算法，其特点是使用口令代替了密钥，而口令由用户自己掌管，
 * 采用随机数杂凑多重加密等方法保证数据的安全性。
 * PBE算法没有密钥的概念，把口令当做密钥了。因为密钥长短影响算法安全性，还不方便记忆，这里我们直接换成我们自己常用的口令就大大不同了，便于我们的记忆。
 * 但是单纯的口令很容易被字典法给穷举出来，所以我们这里给口令加了点“盐”，这个盐和口令组合，想破解就难了。
 * 同时我们将盐和口令合并后用消息摘要算法进行迭代很多次来构建密钥初始化向量的基本材料，使破译更加难了。
 * 
 * @author "liuxj"
 *
 */
public class PBEUtil {

	private Cipher cipher;
	private SecretKey generateKey;
	private PBEParameterSpec pbeParameterSpec;

	public String encode(String src) {
		try {
			SecureRandom secureRandom = new SecureRandom();
			byte[] salt = secureRandom.generateSeed(8);

			String password = "amuro";
			PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			generateKey = secretKeyFactory.generateSecret(pbeKeySpec);

			pbeParameterSpec = new PBEParameterSpec(salt, 100);
			cipher = Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, generateKey, pbeParameterSpec);
			byte[] resultBytes = cipher.doFinal(src.getBytes());
			return Hex.encodeHexString(resultBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String decode(String src) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, generateKey, pbeParameterSpec);
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

		PBEUtil util = new PBEUtil();
		String encodeStr = util.encode(str);
		System.out.println(encodeStr);
		System.out.println(util.decode(encodeStr));

	}

}
