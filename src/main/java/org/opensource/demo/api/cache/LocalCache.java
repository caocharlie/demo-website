package org.opensource.demo.api.cache;

import java.util.HashMap;
import java.util.Map;

import org.opensource.commons.security.AlgorithmType;
import org.opensource.commons.security.Secrecy;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class LocalCache {
	
	//缓存appId对应的密钥
	private Map<AlgorithmType, Secrecy> secrecyMap;
	
	/**
	 * 获取算法对应的加解密实例
	 * @param algorithm
	 * @return
	 */
	public Secrecy getSecrecy(AlgorithmType algorithm){
		return secrecyMap.get(algorithm);
	}
	
	/**
	 * 增加一个加解密实例
	 * @param algorithm
	 * @param secrecy
	 */
	public void putSecrecy(AlgorithmType algorithm, Secrecy secrecy){
		secrecyMap.put(algorithm, secrecy);
	}
	
	/**
	 * 初始化相关属性
	 */
	private void init(){
		secrecyMap = new HashMap<>(AlgorithmType.values().length);
	}

	private LocalCache(){
		init();
	}
	
	public static LocalCache getInstance(){
		return InstanceCreator.instance;
	}
	/**
	 * 
	 * @ClassName: InstanceCreator
	 * @Description: 内部类实现单例
	 * @author shuocao@jointwisdom.cn
	 * @date 2017-6-28 下午5:21:22
	 *
	 */
	private static class InstanceCreator{
		private static final LocalCache instance = new LocalCache();
	}
	
}