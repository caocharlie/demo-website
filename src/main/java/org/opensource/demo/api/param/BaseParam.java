package org.opensource.demo.api.param;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public abstract class BaseParam {
	
	protected Long id;
	protected Long userId;
	protected String linkChannel; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLinkChannel() {
		return linkChannel;
	}
	public void setLinkChannel(String linkChannel) {
		this.linkChannel = linkChannel;
	}
	/**
	 * 将所有参数放入map
	 * @return
	 */
	public Map<String, Object> paramMap(){
		Map<String, Object> map = new HashMap<>();
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass(), Object.class);
			PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
			String key;
			Object value;
			
			for(PropertyDescriptor pd : props){
				key = pd.getName();
				value = this.invokeGet(this, pd);
				if(value != null){
					map.put(key, value);
				}				
			}
		} catch (Exception e) {
			System.err.println("通过BaseParam生成Page时异常："+e);
			//TODO 应该抛出异常吧？
		}
		
		return map;
	}
	/**
	 * @Title: invokeGet
	 * @Description: 调用一个对象的指定的get方法
	 * @param obj
	 * @param prop
	 * @return
	 */
	private Object invokeGet(Object obj, PropertyDescriptor prop){
		Object value = null;
		try {
			Method get = prop.getReadMethod();
			if(get != null){
				value = get.invoke(obj);
			}
		} catch (Exception e) {
			System.err.println("调用对象的get方法时异常："+obj+","+prop);
			//TODO 应该抛出异常吧？
		}
		return value;
	}

}