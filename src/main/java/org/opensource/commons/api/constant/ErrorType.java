package org.opensource.commons.api.constant;

import org.opensource.commons.api.dto.RespResult;
import org.opensource.commons.api.dto.RespResultBuilder;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public enum ErrorType implements RespResultBuilder {

	SUCCESS(200, null),
	
	//常用错误信息
	URL_INVALID(1001, "请求地址无效"),
	AUTH_FAIL(1002, "鉴权失败"),
	NO_PERMISSION(1003, "无此权限"),
	PARAM_INVALID(1004, "参数无效"),
	SMS_SEND_FAIL(1005, "短信发送失败"),
	EMAIL_SEND_FAIL(1006, "邮件发送失败"),
	ACT_CODE_INVALID(1007, "验证码无效"),
	ACCOUNT_INVALID(1008, "帐号或密码错误"),
	SESSION_TIMEOUT(1009, "未登录或登录超时"),
	
	DATA_EXIST(1011, "数据已存在"),
	DATA_NONEXISTENT(1012, "数据不存在"),
	DATA_NONEXISTENT_ON_CURR_CONDITIONS(1013, "当前条件下数据不存在"),
	DATA_INVALID(1014, "数据无效"),
	
	DB_OPER(9001, "数据库操作异常"),
	DB_CONN(9002, "数据库连接异常"),
	
	SYS_ERROR_RETRY(8888, "系统异常，请稍后重试"),
	UNKNOW(9999, "未知异常，请联系管理员");

	private int status;
	private String msg;
	
	private ErrorType(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	/**
	 * 用来生成错误信息对应Result对象
	 * @return
	 */
	@Override
	public <T> RespResult<T> buildResult(){
		return new RespResult<>(this.getStatus(), this.getMsg());
	}
	
	public int getStatus() {
		return status;
	}
	public String getMsg() {
		return msg;
	}

	@Override
	public String toString(){
		return "status=" + status + ", msg=" + msg;
	}
	
}