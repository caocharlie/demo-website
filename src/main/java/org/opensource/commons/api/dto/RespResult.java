package org.opensource.commons.api.dto;

import java.io.Serializable;

import org.opensource.commons.api.constant.ErrorType;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class RespResult<T> implements Serializable {

	private static final long serialVersionUID = 1581136519121869763L;

	private int status;
	private String msg;
	private T data;

	public RespResult(){
		super();
	}
	public RespResult(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	public RespResult(T data) {
		super();
		this.status = ErrorType.SUCCESS.getStatus();
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public RespResult<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public int getStatus() {
		return status;
	}
	public RespResult<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	
	@Override
	public String toString() {
		return "BaseResult [status=" + status + ", msg=" + msg 
				+ ", data=" + data + "]";
	}

}