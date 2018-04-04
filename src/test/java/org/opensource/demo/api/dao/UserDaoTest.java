package org.opensource.demo.api.dao;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.opensource.demo.api.dao.UserDao;
import org.opensource.demo.api.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class UserDaoTest extends BaseDaoTest {

	@Autowired
	private UserDao dao;

	
	public void testFindByPage(){
		Map<String, Object> params = new HashMap<>(1);
		params.put("name", "name");
		
		/*Page<User> page = new Page<>();
		page.setSize(2);
		page.setOrderByField("created_gmt");
		
		
		List<User> list = dao.findByPage(page, params);
		page.setRecords(list);
		System.out.println(page);
		assertNotNull(list);*/
	}
	
	@Test
	public void testFindById(){
		User u = dao.findById(2L);
		System.out.println(u);
		assertNotNull(u);
	}
	
	
	public void testFindByConditions(){
		Map<String, Object> param = new HashMap<>(1);
		param.put("name", "name_A");
		
		List<User> list = dao.findByConditions(param);
		System.out.println(list);
		assertNotNull(list);
	}
	
	
	public void testSave(){
		String tmpStr = "_C";
		User u = User.builder()
				.name("name" + tmpStr)
				.phone("phone" + tmpStr)
				.email("email" + tmpStr)
				.build();
		
		dao.save(u);
	}
	
}