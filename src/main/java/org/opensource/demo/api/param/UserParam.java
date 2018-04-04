package org.opensource.demo.api.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@Getter
@Setter
@ToString
public class UserParam extends BaseParam {

	protected String name;
	protected String phone;
	protected String email;

}