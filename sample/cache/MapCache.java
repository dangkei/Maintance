package cache;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.springframework.stereotype.Component;

@Component
public class MapCache<K,V> {

	public ConcurrentHashMap<K,V> pool = new ConcurrentHashMap<K,V>();
	
	
	public MapCache() {	}
	
	//增加
	public void put(K key,V value) {
		pool.put(key, value);
	}
	//查询
	public V get(K key) {
		return pool.get(key);
	}
	//删除
	public void remove(K key) {
		pool.remove(key);
	}
	
	public int size() {
		return pool.size();	
	}
	
	private class clearCach extends Thread {
		public void run() {
			while(true) {
				//Set<Object> tempSet = new HashSet<>();
				KeySetView<K,V> set = pool.keySet();
				Iterator<K> it = set.iterator();
				while(it.hasNext()) {
					K key = it.next();
					pool.remove(key);
				}
				
			}
		}
	}
}


/*ConcurrentHashMap
 *  
 * */
