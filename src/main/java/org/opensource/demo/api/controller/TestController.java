package org.opensource.demo.api.controller;

import java.util.concurrent.TimeUnit;

import org.opensource.commons.api.dto.RespResult;
import org.opensource.demo.api.exception.JsonException;
import org.opensource.demo.api.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */
@Controller
@RequestMapping("/test")
public class TestController implements BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    private RedisTemplate<Object, Object> redis;
	
	
	@ApiOperation(value="测试接口", notes="不传name就返回SB")
	@GetMapping("/hello")
	@ResponseBody
	public RespResult<String> hello(String name) {

		log.debug("name={}", name);
		
		if(StringUtils.isEmpty(name)){
			name = "SB";
		} else if("sb".equalsIgnoreCase(name)){
			throw new RuntimeException("aa");
		} else {
			throw new JsonException(10, "毛异常");
		}
		
		return new RespResult<>("Hello " + name + "!");
	}
	
	@ApiOperation(value="Redis测试接口", notes="测试接口-流水号自增")
	@GetMapping("/redisincr")
	public RespResult<Long> redisIncrement(String key) {
		
		Boolean exists = redis.hasKey(key);
		
		ValueOperations<Object, Object> operations = redis.opsForValue();
		
		Long currentValue = operations.increment(key, 1L);
		
		//第1次创建，就设置有效期10秒
		if(!exists){
			redis.expire(key, 10, TimeUnit.SECONDS);
		}
		
		return new RespResult<>(currentValue);
	}
	
	@ApiOperation(value="Redis测试接口", notes="测试接口-查询")
	@GetMapping("/redis")
	public RespResult<Object> redisFind(String key) {
		
		ValueOperations<Object, Object> operations = redis.opsForValue();
		
		return new RespResult<>(operations.get(key));
	}
	
	@ApiOperation(value="Redis测试接口", notes="测试接口-保存")
	@PostMapping("/redis")
	public RespResult<Object> redisSave(User param) {
		
		ValueOperations<Object, Object> operations = redis.opsForValue();
		operations.set(param.getName(), param);
		
		return new RespResult<>(param);
	}
	
}