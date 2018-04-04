package org.opensource.demo.api.service.impl;

import org.opensource.demo.api.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TODO<BR>
 * @Description: TODO<BR>
 * @author caoshuo@163.com<BR>
 * @date 2017年12月21日<BR>
 * @since V1.0
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisTemplate<String, String> redis;
	
	/* (non-Javadoc)
	 * @see cn.jointwisdom.jiratest.api.service.impl.RedisService#get(java.lang.String)
	 */
	@Override
	public String get(String key) {
		ValueOperations<String, String> operations = redis.opsForValue();
		
		return operations.get(key);
	}

	/* (non-Javadoc)
	 * @see cn.jointwisdom.jiratest.api.service.impl.RedisService#put(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean put(String key, String value) {
		ValueOperations<String, String> operations = redis.opsForValue();
		operations.set(key, value);
		return true;
	}

}