/**
 * 2009-9-3
 */
package com.bubble.secret.sha;

import static org.junit.Assert.*;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * SHA校验
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class SHACoderTest {

	/**
	 * 测试SHA-1
	 * @return 
	 * 
	 * @throws Exception
	 */
	@Test
	public void main() throws Exception{
		String a = "电子商务安全�?��";
		System.out.println(testEncodeSHA(a));
	}
	
	public static String testEncodeSHA(String str) throws Exception {
		//String str = "SHA1消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA(str.getBytes());
		
		
		//System.err.println("data1:\t" + Base64.encodeBase64String(data1));
		//System.err.println("data2:\t" + Base64.encodeBase64String(data2));
		// 校验
		//assertArrayEquals(data1, data2);
		
		//return Base64.encodeBase64String(data1);
		return Base64.encodeBase64String(data1);
	}

	/**
	 * 测试SHA-256
	 * @return 
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA256() throws Exception {
		String str = "SHA256消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA256(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA256(str.getBytes());

		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试SHA-384
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA384() throws Exception {
		String str = "SHA384消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA384(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA384(str.getBytes());

		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试SHA-512
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA512() throws Exception {
		String str = "SHA512消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA512(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA512(str.getBytes());

		// 校验
		assertArrayEquals(data1, data2);
	}
}
