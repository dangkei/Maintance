package finance;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyTest {
	private static int timeOut = 5000;
	private static int dataBase = 0;
	private static JedisPool pool = null;
	private static Jedis jedis = null;
	
	static float total = 162000;
	static float cash = 162000;
	static float found = 67801;
	
	public static void main(String[] args) {
		
		
		
		initPool();
		
		jedis = pool.getResource();
		
		jedis.set("asset:total", String.valueOf(total));

		
		System.out.println(jedis.get("asset:total"));
	}
	
	
	private static void blance() {
		
	}
	
	public static void commit() {
		
	}
	
	public static void initPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			config.setMaxIdle(1024);		//最大空闲实例数
			config.setMaxTotal(1024);		//最大实例数
			config.setMinIdle(20);			
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(1000 * 10);
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);

			String masterUrl = "localhost";
			String masterPort = "6379";
			String password = "assoft";

			//System.out.println("masterUrl=" + masterUrl + "***masterPort=" +
			//masterPort + "****password=" + password);
			pool = new JedisPool(config, masterUrl,
					Integer.parseInt(masterPort), timeOut, password, dataBase);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
