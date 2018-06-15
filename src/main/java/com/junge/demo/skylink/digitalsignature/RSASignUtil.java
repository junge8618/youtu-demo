/**
 * 
 */
package com.junge.demo.skylink.digitalsignature;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author "liuxj"
 *
 */
public class RSASignUtil {

	private PublicKey rsaPublicKey;
	private KeyFactory keyFactory;
	
	public byte[] sign(String src) {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			PrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			// 生成签名bytes

			return signature.sign();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean verifySign(String src, byte[] signBytes) {
		try {

			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initVerify(publicKey);
			signature.update(src.getBytes());

			return signature.verify(signBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "测试中文是否可以";

		RSASignUtil util = new RSASignUtil();
		byte[] signBytes = util.sign(str);
		System.out.println(util.verifySign(str, signBytes));

	}

}
