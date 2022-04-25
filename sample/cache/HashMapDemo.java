package cache;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("one",1);
        map.put("two",2);
        map.put("one",101);    //key重复
        map.put(null,0);       //key为null
        map.put("zero",null);    //value为null
        System.out.println(map.get("one"));    //key存在：101
        System.out.println(map.get(null));    //key存在：0
        System.out.println(map.get("ten"));     //key不存在：null
	}

}
