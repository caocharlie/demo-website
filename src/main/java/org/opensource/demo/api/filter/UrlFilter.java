package org.opensource.demo.api.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opensource.commons.api.constant.ErrorType;
import org.opensource.demo.api.util.HttpReqUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@WebFilter(filterName = "urlFilter", urlPatterns = "/*")
public class UrlFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(UrlFilter.class);
	

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String servletPath = req.getServletPath();
		String reqIp = HttpReqUtils.getRealIp(req);
		String appId = req.getParameter("appId");
		
		log.debug("RequestParam={}, {}, {}", new Object[]{appId, reqIp, servletPath});
		
		//是否接受指定IP的请求
		if(this.unallowdReqIp(reqIp)){
			HttpReqUtils.returnMsg(resp, servletPath, ErrorType.NO_PERMISSION.buildResult());
			return;
		} 
		
		chain.doFilter(request, response);
		
	}

	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig cfg) throws ServletException {
		log.debug("过滤器初始化={}", cfg);
	}


	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

	/**
	 * 是否接受指定IP的请求
	 * @param reqIP
	 * @return
	 */
	private boolean unallowdReqIp(String reqIp){
		//目前没做白名单，所以直接返回false
		return false;
	}
	
}