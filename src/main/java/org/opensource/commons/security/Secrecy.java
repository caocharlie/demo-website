package org.opensource.commons.security;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public interface Secrecy {

	/**
	 * 加密
	 * @param key //TODO 这里的key可以考虑用一些通用的父类
	 * @param content
	 * @return
	 */
	public String encrypt(String key, String content);
	
	/**
	 * 解密
	 * @param key //TODO 这里的key可以考虑用一些通用的父类
	 * @param content
	 * @return
	 */
	public String decrypt(String key, String content);	
	
}