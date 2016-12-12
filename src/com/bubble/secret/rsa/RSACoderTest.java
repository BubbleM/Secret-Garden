package com.bubble.secret.rsa;

import static org.junit.Assert.*;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class RSACoderTest {

	/**
	 * 公钥
	 */
	private byte[] publicKey;

	/**
	 * 私钥
	 */
	private byte[] privateKey;

	/**
	 * 初始化密�?
	 * 
	 * @throws Exception
	 */
	@Before
	public void initKey() throws Exception {

		// 初始化密�?
		Map<String, Object> keyMap = RSACoder.initKey();

		publicKey = RSACoder.getPublicKey(keyMap);
		privateKey = RSACoder.getPrivateKey(keyMap);

		System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
		System.err.println("私钥�?\n" + Base64.encodeBase64String(privateKey));
	}

	/**
	 * 校验
	 * 
	 * @throws Exception
	 */
	@Test
	public void test(String inputStr2) throws Exception {
//		System.err.println("\n---公钥加密—�?私钥解密---");
//		String inputStr2 = "电子商务安全�?��";
		byte[] data2 = inputStr2.getBytes();
//		System.err.println("原文:\n" + inputStr2);

		// 加密
		byte[] encodedData2 = RSACoder.encryptByPublicKey(data2, publicKey);
		System.err.println("加密�?\n" + Base64.encodeBase64String(encodedData2));

		// 解密
		byte[] decodedData2 = RSACoder.decryptByPrivateKey(encodedData2,
				privateKey);
		String outputStr2 = new String(decodedData2);
		System.err.println("解密�? " + outputStr2);

		// 校验
		assertEquals(inputStr2, outputStr2);
	}

}
