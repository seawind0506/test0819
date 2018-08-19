/**
*
*
*/
package com.wind.hashmap;

/**
 * <p>Title:LvHashMap.java </p>
 * <p>Description: LvHashMap.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月8日下午4:07:17
 * @version 1.0
 * @param <K>
 * @param <V>
 */
public class LvHashMap<K, V> implements LvMap<K, V> {
	
	private static int defaultLength = 16;
	
	private static double defaultLoad = 0.75;
	
	private Entry<K, V>[] table = null;
	
	private int index;
	
	//记录数组元素个数
	private int size = 0;
	
	public LvHashMap(int defaultLength, double defaultLoad){
		this.defaultLength = defaultLength;
		this.defaultLoad = defaultLoad;
		
		table = new Entry[defaultLength];
	}
	
	public LvHashMap(){
		this(defaultLength,defaultLoad);
	}
	
	
	public V put(K key, V value) {
		//1、根据key和hash函数计算对应的index
		index = getIndex(key);
		//2、获取index处的entry对象
		Entry<K, V> e = table[index];
		
		if(null == e){
			table[index] = new Entry(key, value, null, index);
			size++;
		}else {
			Entry newEntry = new Entry(key, value, e, index);
			table[index] = newEntry;
			size++;
		}
		return table[index].getValue();
	}

	public int getIndex(K key) {
		int m = defaultLength-1;
		
		return index = key.hashCode() % m;
	}
		
	
	public V get(K key) {
		//1、根据key和hash函数计算对应的index
		index = getIndex(key);
		//2、获取index处的entry对象
		Entry<K, V> e = table[index];
		
		return table[index] == null ? null : table[index].getValue();
		
	}

	public int size() {
		return size;
	}
	
	class Entry<K, V> implements LvMap.Entry<K, V>{
		K key;
		
		V value;
		
		Entry<K, V> next;
		
		int index;
		
		private Entry(K k, V v, Entry<K, V> n, int inx) {
			key = k;
			value = v;
			next = n;
			index = inx;
		}

		
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
		
	}
}
