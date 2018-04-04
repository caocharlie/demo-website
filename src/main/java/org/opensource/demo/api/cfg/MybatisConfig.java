package org.opensource.demo.api.cfg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("org.opensource.demo.api.dao*")
public class MybatisConfig {

}
