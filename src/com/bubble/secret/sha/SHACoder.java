/**
 * 2009-9-3
 */
package com.bubble.secret.sha;

import java.security.MessageDigest; 

/**
 * SHA加密组件
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public abstract class SHACoder {

	/**
	 * SHA-1加密
	 * 
	 * @param data
	 *            待加密数�?
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA");

		// 执行消息摘要
		return md.digest(data);
	}


	/**
	 * SHA-256加密
	 * 
	 * @param data
	 *            待加密数�?
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA256(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * SHA-384加密
	 * 
	 * @param data
	 *            待加密数�?
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA384(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-384");

		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * SHA-512加密
	 * 
	 * @param data
	 *            待加密数�?
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA512(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-512");

		// 执行消息摘要
		return md.digest(data);
	}
}
