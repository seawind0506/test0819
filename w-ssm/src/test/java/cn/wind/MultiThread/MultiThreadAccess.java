/**
*
*
*/
package cn.wind.MultiThread;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
public class MultiThreadAccess implements Runnable{ 
	
	private ItemService itemService;
	
	private Long itemId;
	
	private CountDownLatch countDownLatch;
	
	private int count;
	
	Logger logger = Logger.getLogger(MultiThreadAccess.class);
    
	public MultiThreadAccess(ItemService itemService, Long itemId, CountDownLatch countDownLatch, int count) {
		super();
		this.itemService = itemService;
		this.itemId = itemId;
		this.countDownLatch = countDownLatch;
		this.count = count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			logger.info(Thread.currentThread().getName()+": "+count+" 开始等待...");
//			countDownLatch.await();
			logger.info(Thread.currentThread().getName()+": "+count+" 开始运行...");
			TbItem item = itemService.getItemById(itemId);
			logger.info(item.getCid()+": "+item.getTitle());
			logger.info(Thread.currentThread().getName()+": "+count+" 运行结束...");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}