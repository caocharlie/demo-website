package org.opensource.demo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@Controller
public class IndexController implements BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@ApiIgnore
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("rdm", 150);
		log.debug("rdm is {}", 150);
		return "index";
	}
	
}