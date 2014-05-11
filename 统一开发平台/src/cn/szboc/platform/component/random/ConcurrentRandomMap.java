package cn.szboc.platform.component.random;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cn.szboc.platform.commons.thread.annotation.ThreadSafe;

/**
 * 实现一个对于某个固定的KEY,会有多个VALUE存储于内部,但每次调用GET操作的时候,只会返回一个随机的VALUE
 */
@ThreadSafe
public class ConcurrentRandomMap<K, V> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	/**
	 * 内存存储的数据结构,对于此缓存,要控制,写阻塞写,写阻塞读,读不阻塞读
	 */
	private Map<K, List<V>> cache;

	public ConcurrentRandomMap() {
		cache = new HashMap<K, List<V>>();
	}

	public V get(K key) {
		r.lock();
		try {
			List<V> datas = this.cache.get(key);
			if (datas == null) {
				return null;
			}
			int size = datas.size();
			int rdIdx = new Random().nextInt(size);
			return datas.get(rdIdx);
		} finally {
			r.unlock();
		}
	}

	public void put(K key, V value) {
		w.lock();
		try {
			List<V> datas = this.cache.get(key);
			if (datas == null) {
				datas = new ArrayList<V>();
				this.cache.put(key, datas);
			}
			datas.add(value);
		} finally {
			w.unlock();
		}
	}

	public void remove(K key, V value) {
		w.lock();
		try {
			List<V> datas = this.cache.get(key);
			if (datas == null) {
				datas = new ArrayList<V>();
				this.cache.put(key, datas);
			}
			datas.remove(value);
		} finally {
			w.unlock();
		}
	}

	public void remove(K key) {
		w.lock();
		try {
			this.cache.remove(key);
		} finally {
			w.unlock();
		}
	}

	public void clear() {
		w.lock();
		try {
			this.cache.clear();
		} finally {
			w.unlock();
		}
	}

}
