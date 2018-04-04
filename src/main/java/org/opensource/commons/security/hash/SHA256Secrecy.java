package org.opensource.commons.security.hash;

import org.opensource.commons.security.Secrecy;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class SHA256Secrecy implements Secrecy {

	/* (non-Javadoc)
	 * @see cn.jointwisdom.commons.security.Secrecy#encrypt(java.lang.String, java.lang.String)
	 */
	@Override
	public String encrypt(String key, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.jointwisdom.commons.security.Secrecy#decrypt(java.lang.String, java.lang.String)
	 */
	@Override
	public String decrypt(String key, String content) {
		throw new RuntimeException("METHOD NOT SUPPORT");
	}

}