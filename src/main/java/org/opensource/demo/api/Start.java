package org.opensource.demo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@SpringBootApplication
//加载自定义过滤器
@ServletComponentScan
//启用定时任务
@EnableScheduling
public class Start extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		//防止邮件附件名被截取
		System.setProperty("mail.mime.splitlongparameters", "false");
		
		SpringApplication.run(Start.class, args);
	}

	/**
	 * 部署在tomcat的配置
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Start.class);
	}

}