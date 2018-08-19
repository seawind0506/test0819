/**
*
*
*/
package cn.wind.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.wind.common.jedis.JedisClient;
import cn.wind.common.utils.JsonUtils;
import cn.wind.mapper.TbItemMapper;
import cn.wind.pojo.TbItem;
import cn.wind.pojo.TbItemExample;
import cn.wind.pojo.TbItemExample.Criteria;
import cn.wind.service.ItemService;

/**
 * <p>Title:ItemServiceImpl.java </p>
 * <p>Description: ItemServiceImpl.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月1日下午1:49:28
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${ITEM_LIST}")
	private String ITEM_LIST;
	
	Logger logger = Logger.getLogger(ItemServiceImpl.class);
	
	@Override
	public TbItem getItemById(Long itemId) {
		//加缓存
		//1、查询缓存
		try {//如果有就直接返回数据
			String json = jedisClient.hget(ITEM_LIST,itemId+"");
			//json数据转换成对象
			if(StringUtils.isNotBlank(json)){
				logger.info("==================get from cache============================");
				
				List<TbItem> list = JsonUtils.jsonToList(json,TbItem.class);
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//2、查询数据库
		//方式一：根据主键查询
 		//List<TbItem> list = itemMapper.selectByPrimaryKey(itemId);
		//方式二：设置条件查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		
		logger.info("==================get from db============================");
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			//3、结果添加到缓存（对象要转换成json数据存储）
			try {
				jedisClient.hset(ITEM_LIST, itemId+"", JsonUtils.objectToJson(list));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list.get(0);
		}
		
		return null;
	}

}
