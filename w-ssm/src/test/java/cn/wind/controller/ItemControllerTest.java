/**
*
*
*/
package cn.wind.controller;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v1.util.DebugUtils;

import cn.wind.common.jedis.JedisClient;
import cn.wind.pojo.TbItem;
import cn.wind.service.ItemService;
import cn.wind.MultiThread.*;

/**
 * <p>Title:ItemControllerTest.java </p>
 * <p>Description: ItemControllerTest.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月5日下午1:20:02
 * @version 1.0
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个路径
//@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml", "classpath:spring/springmvc.xml"})
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})

public class ItemControllerTest {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${ITEM_ID}")
	private Long ITEM_ID;
	
	private int concurrentNum = 0;
	
	private CountDownLatch countDownLatch;
	
	private Logger logger = Logger.getLogger(ItemControllerTest.class);
	
	private static int count = 0;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetItemById() {
		TbItem item = itemService.getItemById(ITEM_ID);
		logger.info(item.getId()+"==========================================================================");
		logger.info("----------------------------------hello-------------------------------------------");
	}

	@Test
	public void testGetItemByIdCache() {
		countDownLatch = new CountDownLatch(concurrentNum);
//		ExecutorService executorService = Executors.newCachedThreadPool();
		logger.info("开始------------------------------");
//		for ( ;count < concurrentNum; count++) {
			logger.info(Thread.currentThread().getName()+": "+count+" 开始创建...");
			new Thread(new MultiThreadAccess(itemService, ITEM_ID, countDownLatch, count)).start();
//			executorService.execute(new MultiThreadAccess());
//			countDownLatch.countDown();
//		}
		logger.info("结束------------------------------");
	}
	
}
