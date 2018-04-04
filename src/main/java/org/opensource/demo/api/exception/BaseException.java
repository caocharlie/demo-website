package org.opensource.demo.api.exception;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	protected int code;
	
	public BaseException() {
		super();
	}
	public BaseException(int code) {
		super();
		this.code = code;
	}
	
	public BaseException(int code, String message) {
		super(message);
		this.code = code;
	}
	public BaseException(int code, Throwable cause) {
		super(cause);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	

}