/**
*
*
*/
package cn.wind.MultiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.wind.pojo.TbItem;
import cn.wind.service.ItemService;


/**
 * <p>Title:MultiThreadAccess.java </p>
 * <p>Description: MultiThreadAccess.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月2日下午1:17:46
 * @version 1.0
 */
public class MultiThreadAccess2 implements Runnable{

	private CountDownLatch countDownLatch;
	
	private long count;
	
	
	public MultiThreadAccess2(CountDownLatch countDownLatch,long count) {
		this.countDownLatch = countDownLatch;
		this.count = count;
	}
	
	Logger logger = Logger.getLogger(MultiThreadAccess2.class);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			logger.info(Thread.currentThread().getName()+": "+count+" 开始等待。。。。");
			countDownLatch.await();
			logger.info(Thread.currentThread().getName()+": "+count+" 开始执行。。。。");
			
			logger.info(StringUtils.right(Thread.currentThread().getName(), 15)+"： 处理业务");
			logger.info(Thread.currentThread().getName()+": "+count+" 结束运行。。。。");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}