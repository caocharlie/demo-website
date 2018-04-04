package org.opensource.demo.api.service;

import org.opensource.demo.api.param.UserParam;
import org.opensource.demo.api.pojo.User;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public interface UserService extends BaseService {

	/**
	 * 保存并
	 * @param params
	 * @return
	 */
	User saveWhenNonexistent(UserParam param);
	
}