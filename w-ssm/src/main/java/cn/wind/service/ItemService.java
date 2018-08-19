/**
*
*
*/
package cn.wind.service;

import cn.wind.pojo.TbItem;

/**
 * <p>Title:Itemservice.java </p>
 * <p>Description:</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月1日下午1:43:50
 * @version 1.0
 */
public interface ItemService {
	TbItem getItemById(Long itemId);
}
