/**
*
*
*/
package com.wind.hashmap;

/**
 * <p>Title:LvMap.java </p>
 * <p>Description: 定义自己的MAP接口</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月8日下午4:00:08
 * @version 1.0
 * @param <K>
 * @param <V>
 */
public interface LvMap<K, V> {
	V put(K key, V value);
	
	V get(K key);
	
	int size();
	
	interface Entry<K, V>{
		K getKey();
		
		V getValue();
	}
	
	
}
