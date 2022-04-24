package cache;

import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo {
	public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<String,Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("one", 101);
        // map.put(null, 0);     //不能为空
        // map.put("zero",null);   //不能为空，Exception in thread "main" java.lang.NullPointerException
        System.out.println(map);  // {two=2, one=101}
	}
}
