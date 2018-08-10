/**
 * 
 */
package com.junge.demo.skylink;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 消息摘要算法
 * 
 * @author "liuxj"
 *
 */
public class MessageDigestUtil {

	/**
	 * MD5算法消息摘要
	 * 
	 * @param inputStr
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static final String encodeMd5(String inputStr) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] encodeBytes = md.digest(inputStr.getBytes());

		return Hex.encodeHexString(encodeBytes);
	}
	
	/**
	 * MD5算法消息摘要
	 * 
	 * @param inputStr
	 * @return
	 */
	public static final String encodeMd5ApacheCodec(String inputStr) {
		return DigestUtils.md5Hex(inputStr);
	}

	/**
	 * SHA算法消息摘要
	 * 
	 * @param inputStr
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static final String encodeSHAApacheCodec(String inputStr) throws NoSuchAlgorithmException {
		return DigestUtils.sha1Hex(inputStr);
	}
	
	/**
	 * SHA算法消息摘要
	 * 
	 * @param inputStr
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static final String encodeSHA(String inputStr) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(inputStr.getBytes());
		return Hex.encodeHexString(md.digest());
	}
	
	public static final String encodeAES(String inputStr) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");  
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"), "AES"));  
		byte[] data = cipher.doFinal(inputStr.getBytes("UTF-8"));
		
		return Hex.encodeHexString(data);
	} 

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String str = "veuwbbebwariikhwrjbz";
		System.out.println(encodeMd5(str));
		System.out.println(encodeMd5ApacheCodec(str));
		System.out.println(encodeSHA(str));
		System.out.println(encodeSHAApacheCodec(str));
		System.out.println(encodeAES(str));
	}

}
