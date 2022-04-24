package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import com.soft.cms.spring.SpringContext;

public class Paradigm<ES,E> {

	public static void main(String[] args) {
		Paradigm<String,Integer> p1=new Paradigm<String,Integer>();
		String s1 = p1.entityService();
		System.out.println(s1);
	}
	
	public  ES entityService(){
		try {
			Class<ES> clazz=getTclass(); //得到泛型参数类
			return gainActionService(clazz);  //根据泛型参数类得到对应
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public Class<ES> getTclass() throws InstantiationException, IllegalAccessException {
         Type sType = getClass().getDeclaringClass();  //得到包含泛型参数的当前类的父类
         Type[] generics = ((ParameterizedType) sType).getActualTypeArguments(); //得到当前父类的所有泛型参数
         Class<ES> mTClass = (Class<ES>) (generics[0]);  //第一个参数
         return mTClass;
	}
	
	@SuppressWarnings("unchecked")
	public ES gainActionService(Class<ES> interClazz){
		Map<String, ES> map=SpringContext.getApplicationContext().getBeansOfType(interClazz);
		if(map.size()==1){
			return (ES)map.values().toArray()[0];
		}else if(map.size()==0){
			return null;
		}
		return (ES)map.get(interClazz.getName());
	}
	
	
}
