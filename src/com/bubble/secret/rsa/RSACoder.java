package com.bubble.secret.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;


public abstract class RSACoder {

	/**
	 * 非对称加密密钥算�?
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * 公钥
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/**
	 * 私钥
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/**
	 * RSA密钥长度 
	 * 默认1024位，
	 * 密钥长度必须�?4的�?数， 
	 * 范围�?12�?5536位之间�?
	 */
	private static final int KEY_SIZE = 512;

	/**
	 * 私钥解密
	 * 
	 * @param data
	 *            待解密数�?
	 * @param key
	 *            私钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, byte[] key)
			throws Exception {

		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// 对数据解�?
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}

	/**
	 * 公钥解密
	 * 
	 * @param data
	 *            待解密数�?
	 * @param key
	 *            公钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, byte[] key)
			throws Exception {

		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 生成公钥
		PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

		// 对数据解�?
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.DECRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}

	/**
	 * 公钥加密
	 * 
	 * @param data
	 *            待加密数�?
	 * @param key
	 *            公钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, byte[] key)
			throws Exception {

		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

		// 对数据加�?
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}

	/**
	 * 私钥加密
	 * 
	 * @param data
	 *            待加密数�?
	 * @param key
	 *            私钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, byte[] key)
			throws Exception {

		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// 对数据加�?
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}

	/**
	 * 取得私钥
	 * 
	 * @param keyMap
	 *            密钥Map
	 * @return byte[] 私钥
	 * @throws Exception
	 */
	public static byte[] getPrivateKey(Map<String, Object> keyMap)
			throws Exception {

		Key key = (Key) keyMap.get(PRIVATE_KEY);

		return key.getEncoded();
	}

	/**
	 * 取得公钥
	 * 
	 * @param keyMap
	 *            密钥Map
	 * @return byte[] 公钥
	 * @throws Exception
	 */
	public static byte[] getPublicKey(Map<String, Object> keyMap)
			throws Exception {

		Key key = (Key) keyMap.get(PUBLIC_KEY);

		return key.getEncoded();
	}

	/**
	 * 初始化密�?
	 * 
	 * @return Map 密钥Map
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {

		// 实例化密钥对生成�?
		KeyPairGenerator keyPairGen = KeyPairGenerator
				.getInstance(KEY_ALGORITHM);

		// 初始化密钥对生成�?
		keyPairGen.initialize(KEY_SIZE);

		// 生成密钥�?
		KeyPair keyPair = keyPairGen.generateKeyPair();

		// 公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

		// 私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		// 封装密钥
		Map<String, Object> keyMap = new HashMap<String, Object>(2);

		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);

		return keyMap;
	}
}
