package org.opensource.commons.api.dto;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public interface RespResultBuilder {

	/**
	 * 用来生成接口返回信息对应Result对象
	 * @return
	 */
	public <T> RespResult<T> buildResult();

}