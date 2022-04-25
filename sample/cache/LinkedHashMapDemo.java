package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("one", 101);
        map.put("null", 0);
        map.put("zero", null);
        System.out.println(map);    //{one=101, two=2, null=0, zero=null}
    }
}
