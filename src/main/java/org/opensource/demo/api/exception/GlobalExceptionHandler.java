package org.opensource.demo.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.opensource.commons.api.constant.ErrorType;
import org.opensource.commons.api.dto.RespResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespResult<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("全局异常处理", e);
        return ErrorType.UNKNOW.buildResult();
    }

	@ExceptionHandler(value = ViewException.class)
    public ModelAndView viewErrorHandler(HttpServletRequest req, ViewException e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public RespResult<String> jsonErrorHandler(HttpServletRequest req, JsonException e) throws Exception {
    	RespResult<String> resp = new RespResult<>();
       
        resp.setStatus(e.getCode());
        resp.setMsg(e.getMessage());
        resp.setData("Some Data");
        
        return resp;
    }
    
}