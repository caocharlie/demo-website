package org.opensource.demo.api.exception;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class JsonException extends BaseException {

	private static final long serialVersionUID = 1L;

	public JsonException() {
		super();
	}
	public JsonException(int code) {
		super(code);
	}
	public JsonException(int code, String message) {
		super(code, message);
	}
	public JsonException(int code, Throwable cause) {
		super(code, cause);
	}

}