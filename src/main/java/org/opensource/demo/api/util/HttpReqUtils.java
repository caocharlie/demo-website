package org.opensource.demo.api.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opensource.commons.api.constant.ErrorType;
import org.opensource.commons.api.dto.RespResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class HttpReqUtils {
	
	private static final Logger log = LoggerFactory.getLogger(HttpReqUtils.class.getName());
	// 放入session的key
	public static final String SESSION_USER = "sessionUser";

	/**
	 * 返回登录超时
	 * @param reqPath
	 * @param resp
	 */
	public static void returnSessionTimeout(HttpServletResponse resp, String reqPath){
		returnMsg(resp, reqPath, ErrorType.SESSION_TIMEOUT.buildResult());
	}
	
	/**
	 * 返回指定消息
	 * @param resp
	 * @param rs
	 * @param reqPath
	 */
	public static void returnMsg(HttpServletResponse resp, String reqPath, RespResult<Object> rs){
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/json");
			PrintWriter writer = resp.getWriter();
			writer.write(JSON.toJSONString(rs));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			log.error("访问数据接口"+reqPath+"，返回信息"+rs+"时异常", e);
		}
	}
	
	/**
	 * 获取当前请求的IP
	 * @param request
	 * @return
	 */
	public static String getRealIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}
	
	/**
	 * 获取NGINX代理后的IP地址
	 * @param request
	 * @return
	 */
	public static String getRealIpInNginx(HttpServletRequest request) {
		//最直接的原始地址
		String ip = request.getRemoteAddr();
		if ("127.0.0.1".equalsIgnoreCase(ip)) {
			//本机或其他代理。下面的nginx的相关配置
			//proxy_set_header   X-Real-IP        $remote_addr;
	        //proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
			ip = request.getHeader("X-Forwarded-For");
			//多级代理只取第一组值
			if (ip != null && ip.indexOf(",") != -1) {
				ip = ip.substring(0, ip.lastIndexOf(",")).trim();
			}
		}
		//不符合正常格式的IP地址。取到数据库长度30即可
		if(ip == null || ip.trim().length() == 0){
			ip = "unknown";
		} else if(ip.length() > 15){
			ip = ip.substring(0, 30);
		}

		return ip;
	}

}