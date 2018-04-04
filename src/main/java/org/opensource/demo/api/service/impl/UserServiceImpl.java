package org.opensource.demo.api.service.impl;

import java.util.List;

import org.opensource.commons.api.constant.ErrorType;
import org.opensource.demo.api.dao.UserDao;
import org.opensource.demo.api.exception.JsonException;
import org.opensource.demo.api.param.UserParam;
import org.opensource.demo.api.pojo.User;
import org.opensource.demo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	/* (non-Javadoc)
	 * @see cn.jointwisdom.jiratest.api.service.UserService#saveWhenNonexistent()
	 */
	@Override
	public User saveWhenNonexistent(UserParam param) {
		
		//查询用户是否存在
		List<User> list = dao.findByConditions(param.paramMap());
		
		//不存在就保存用户
		if(list == null || list.isEmpty()){
			User u = User.builder()
					.name(param.getName())
					.phone(param.getPhone())
					.email(param.getEmail())
					.build();
			int n = dao.save(u);
			if(n < 1){
				throw new JsonException(ErrorType.DB_OPER.getStatus(), "用户数据保存时异常");
			}
			
			return u;
		} else {
			//这里可能出现多个匹配结果的情况，所以要求参数值中必填项不能少
			return list.get(0);
		}
	}

}