/**
*
*
*/
package cn.wind.MultiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * <p>Title:TestThread.java </p>
 * <p>Description: TestThread.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月5日下午2:36:34
 * @version 1.0
 */
public class TestThread {
	Logger logger = Logger.getLogger(TestThread.class);
	@Test
	public void test(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		CountDownLatch countDownLatch = new CountDownLatch(100);
		for (int i = 0; i < 100; i++) {
			logger.info("创建第 "+(i+1)+" 个 线程");
			executorService.execute(new MultiThreadAccess(countDownLatch,i+1));
//			new Thread(new MultiThreadAccess(countDownLatch)).start();
			countDownLatch.countDown();
		}
		executorService.shutdown();
	}
	@Test
	public void test2(){
		String s1 = "zhong hua ren ming gong he guo!";
		System.out.println(StringUtils.right(s1, 12));
	}
}
