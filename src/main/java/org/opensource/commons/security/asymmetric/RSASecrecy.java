package org.opensource.commons.security.asymmetric;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import org.opensource.commons.security.Secrecy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class RSASecrecy implements Secrecy {
	
	private static final Logger log = LoggerFactory.getLogger(RSASecrecy.class);
	
	private static final String KEY_ALGORITHM = "RSA";

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jointwisdom.commons.security.Secrecy#encrypt(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String encrypt(String key, String content) {
		try {
			PublicKey publicKey = this.restorePublicKey(key);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// java默认"RSA"="RSA/ECB/PKCS1Padding"
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] bytes = cipher.doFinal(content.getBytes());
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			log.error("RSA加密时异常", e);
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jointwisdom.commons.security.Secrecy#decrypt(java.lang.String,
	 * java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.jointwisdom.commons.security.Secrecy#decrypt(java.lang.String, java.lang.String)
	 */
	@Override
	public String decrypt(String key, String content) {
		byte[] encodedText = Base64.getDecoder().decode(content);
		try {
			PrivateKey pkey = this.restorePrivateKey(key);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, pkey);
			return new String(cipher.doFinal(encodedText));
		} catch (Exception e) {
			log.error("RSA解密时异常", e);
		}
		
		return null;
	}
	
	/**
	 * 还原私钥，PKCS8EncodedKeySpec 用于构建私钥的规范
	 * 
	 * @param keyBytes
	 * @return
	 * @throws Exception 
	 */
	private PrivateKey restorePrivateKey(String privateKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKey);
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
		return factory.generatePrivate(pkcs8EncodedKeySpec);
	}
	
	/**
	 * 还原公钥，将base64编码后的公钥字符串转成PublicKey实例
	 * 
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	private PublicKey restorePublicKey(String publicKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes());
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		return keyFactory.generatePublic(keySpec);
	}

}