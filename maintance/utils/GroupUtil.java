package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GroupUtil {
	
	/*
	 * 将一个data， List<E>类型根据条件分组
	 * fun 分组方法
	 *  
	 * */
	public static < K, E > Map < K, List<E>> groupBy(List <? extends E > data, Function <? super E, ? extends K > fun) {
        Map < K, List < E >> result = new HashMap <> ();
        for (E e: data) {
            K k = fun.apply(e);
            List < E > l = result.get(k);
            if (l == null) {
                l = new ArrayList < > ();
                result.put(k, l);
            }
            l.add(e);
        }
        return result;
    }
}
