package org.opensource.demo.api.exception;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class ViewException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ViewException() {
		super();
	}
	public ViewException(int code, String message) {
		super(code, message);
	}
	public ViewException(int code, Throwable cause) {
		super(code, cause);
	}
	public ViewException(int code) {
		super(code);
	}
	
}