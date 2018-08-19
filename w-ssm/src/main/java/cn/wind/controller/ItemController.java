/**
*
*
*/
package cn.wind.controller;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wind.MultiThread.MultiThreadAccess;
import cn.wind.pojo.TbItem;
import cn.wind.service.ItemService;

/**
 * <p>Title:ItemController.java </p>
 * <p>Description: ItemController.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月1日下午2:01:06
 * @version 1.0
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId){
		TbItem item = itemService.getItemById(itemId);
		System.out.println(item);
		return item;
	}
	
	@RequestMapping("/item/testCache/{itemId}")
	public void getItemByIdCache(@PathVariable Long itemId){
		int ConcurrentCount = 100;
		CountDownLatch countDownLatch = new CountDownLatch(ConcurrentCount);
		System.out.println("---------------------------开始----------------------------------");
		for (int i = 0; i < ConcurrentCount; i++) {
			new Thread(new MultiThreadAccess(itemService, itemId, countDownLatch,i+1)).start();
			countDownLatch.countDown();
		}
		System.out.println("---------------------------结束----------------------------------");
		
	}
}
