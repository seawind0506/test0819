/**
*
*
*/
package com.wind.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title:LvHashMapTest.java </p>
 * <p>Description: 测试自己定义的hashmap</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月8日下午5:05:24
 * @version 1.0
 */
public class LvHashMapTest {

	/**
	*Title: main
	*Decription:
	*@param args
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LvMap<String, String> map = new LvHashMap();
//		Map<String, String> map = new HashMap<String, String>();
		map.put("jack", "one");
		map.put("star", "two");
		System.out.println("key jack: "+map.get("jack"));
		System.out.println("key star: "+map.get("star"));
		
		
	}

}
