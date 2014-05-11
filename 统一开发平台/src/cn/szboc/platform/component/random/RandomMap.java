package cn.szboc.platform.component.random;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.szboc.platform.commons.thread.annotation.NotThreadSafe;

/**
 * 实现一个对于某个固定的KEY,会有多个VALUE存储于内部,但每次调用GET操作的时候,只会返回一个随机的VALUE
 */
@NotThreadSafe
public class RandomMap<K, V> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 内存存储的数据结构
	 */
	private Map<K, List<V>> cache;

	public RandomMap() {
		cache = new HashMap<K, List<V>>();
	}

	public V get(K key) {
		List<V> datas = this.cache.get(key);
		if (datas == null) {
			return null;
		}
		int size = datas.size();
		int rdIdx = new Random().nextInt(size);
		return datas.get(rdIdx);
	}

	public void put(K key, V value) {
		List<V> datas = this.cache.get(key);
		if (datas == null) {
			datas = new ArrayList<V>();
			this.cache.put(key, datas);
		}
		datas.add(value);
	}

	public void remove(K key, V value) {
		List<V> datas = this.cache.get(key);
		if (datas == null) {
			datas = new ArrayList<V>();
			this.cache.put(key, datas);
		}
		datas.remove(value);
	}

	public void remove(K key) {
		this.cache.remove(key);
	}

	public void clear() {
		this.cache.clear();
	}

}
