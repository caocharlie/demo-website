package org.opensource.demo.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@Component
public class DemoTask {
	
	private static final Logger log = LoggerFactory.getLogger(DemoTask.class);


	@Scheduled(cron = "0 5 16 * * *")
    public void task(){
		try {
			log.debug("开始demo任务！");
		} catch (Exception e) {
			log.error("执行demo定时任务异常", e);
		}
    }
	
}