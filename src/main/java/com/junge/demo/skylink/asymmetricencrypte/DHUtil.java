/**
 * 
 */
package com.junge.demo.skylink.asymmetricencrypte;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Hex;

/**
 * DH，全称为“Diffie-Hellman”，他是一种确保共享KEY安全穿越不安全网络的方法，也就是常说的密钥一致协议。
 * 由公开密钥密码体制的奠基人Diffie和Hellman所提出的一种思想。简单的说就是允许两名用户在公开媒体上交换信息以生成“一致”的、可以共享的密钥。
 * 也就是由甲方产出一对密钥（公钥、私钥），乙方依照甲方公钥产生乙方密钥对（公钥、私钥）。
 * 以此为基线，作为数据传输保密基础，同时双方使用同一种对称加密算法构建本地密钥（SecretKey）对数据加密。这样，在互通了本地密钥（SecretKey）
 * 算法后，甲乙双方公开自己的公钥，使用对方的公钥和刚才产生的私钥加密数据，同时可以使用对方的公钥和自己的私钥对数据解密。不单单是甲乙双方两方，
 * 可以扩展为多方共享数据通讯，这样就完成了网络交互数据的安全通讯！
 * 
 * @author "liuxj"
 *
 */
public class DHUtil {

	private Cipher cipher;
	private SecretKey receiverSecretKey;

	public String encode(String src) {
		try {
			// 初始化发送方密钥
			KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			senderKeyPairGenerator.initialize(512);
			KeyPair senderkeyPair = senderKeyPairGenerator.generateKeyPair();
			PrivateKey senderPrivateKey = senderkeyPair.getPrivate();
			byte[] senderPublicKeyBytes = senderkeyPair.getPublic().getEncoded();// 发送方的公钥

			// 初始化接收方密钥,用发送方的公钥
			KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyBytes);
			PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec);
			DHParameterSpec dhParameterSpec = ((DHPublicKey) receiverPublicKey).getParams();
			KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			receiverKeyPairGenerator.initialize(dhParameterSpec);
			KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
			PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
			byte[] receiverPublicKeyBytes = receiverKeyPair.getPublic().getEncoded();

			KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
			receiverKeyAgreement.init(receiverPrivateKey);
			receiverKeyAgreement.doPhase(receiverPublicKey, true);
			receiverSecretKey = receiverKeyAgreement.generateSecret("DES");

			// 发送方拿到接收方的public key就可以做加密了
			KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
			x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyBytes);
			PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
			KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
			senderKeyAgreement.init(senderPrivateKey);
			senderKeyAgreement.doPhase(senderPublicKey, true);
			SecretKey senderSecretKey = senderKeyAgreement.generateSecret("DES");

			if (Objects.equals(receiverSecretKey, senderSecretKey)) {
				cipher = Cipher.getInstance("DES");
				cipher.init(Cipher.ENCRYPT_MODE, senderSecretKey);
				byte[] result = cipher.doFinal(src.getBytes());
				return Hex.encodeHexString(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String decode(String src) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, receiverSecretKey);
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

		DHUtil util = new DHUtil();
		String encodeStr = util.encode(str);
		System.out.println(encodeStr);
		System.out.println(util.decode(encodeStr));

	}

}
