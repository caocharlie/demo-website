package org.opensource.commons.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public class ThreadPool {

	private static final Logger log = LoggerFactory.getLogger(ThreadPool.class.getName());
	private ThreadPoolExecutor executor = null;
	private static int corePoolSize = 10;//初始化线程个数
	private static int maximumPoolSize = 100;//池里最大线程个数
	private static int keepAliveTime = 600;//线程空闲回收时间
	
	private ThreadPool(){
		executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(50), new ThreadPoolExecutor.CallerRunsPolicy());
	}
	
	public static ThreadPool getInstance(){
		return InstanceCreator.instance;
	}
	
	/**
	 * 当前线程池是否还有能力处理新线程
	 * @return
	 */
	public boolean executeAble(){
		//TODO 这部份逻辑还没有实现。
		//目前是长度为50的固定队列，超出后用主线程执行(貌似是这个逻辑)
		return true;
	}
	/**
	 * 抛出线程与当前线程并行
	 * @param command
	 * void
	 */
	public void execute(Runnable task){
		executor.execute(task);
	}
	/**
	 * 通过Future.get()可以与当前线程串行
	 * 但只能知道是否完成
	 * @param task
	 * @return
	 * Future<?>
	 */
	public Future<?> submit(Runnable task){
		return executor.submit(task);
	}
	/**
	 * 通过Future.get()可以与当前线程串行
	 * 并且可以获得返回结果
	 * @param <T>
	 * @param task
	 * @return
	 * Future<?>
	 */
	public <T> Future<T> submit(Callable<T> call){
		return executor.submit(call);
	}
	
	public void shutdown(){
		executor.shutdown();
	}
	
	public void printPoolSize(String name){
		StringBuffer sb = new StringBuffer();
		sb.append("线程池");
		sb.append(name);
		sb.append("当前状态");
		sb.append(": ActiveCount="+executor.getActiveCount());
		sb.append(", CorePoolSize="+executor.getCorePoolSize());
		sb.append(", TaskCount="+executor.getTaskCount());
		sb.append(", PoolSize="+executor.getPoolSize());
		
		log.info(sb.toString());
	}
	
	public static void sleep(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {}
	}
	
	private static class InstanceCreator{
		private static final ThreadPool instance = new ThreadPool();
	}
	
}