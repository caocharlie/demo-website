package org.opensource.demo.api.service;

/**
 * @ClassName: TODO<BR>
 * @Description: TODO<BR>
 * @author caoshuo@163.com<BR>
 * @date 2017年12月21日<BR>
 * @since V1.0
 */

public interface RedisService {
	
	/**
	 * 查找
	 * @param key
	 * @return
	 */
	String get(String key);
	
	/**
	 * 保存 
	 * @param key
	 * @param value
	 * @return
	 */
	boolean put(String key, String value);

}
