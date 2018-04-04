package org.opensource.demo.api.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public interface BaseDao<T> {

	/**
	 * 能过id查询
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);

	/**
	 * 查询所有
	 * 
	 * @param param
	 */
	public List<T> findByConditions(@Param("params")Map<String, Object> params);
	
	/**
	 * 保存接口
	 * 
	 * @param t
	 */
	public int save(T t);

	/**
	 * 更新接口
	 * 
	 * @param t
	 */
	public int update(T t);

	/**
	 * 删除接口
	 * 
	 * @param t
	 */
	public int delete(T t);
	
}