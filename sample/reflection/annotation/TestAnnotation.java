package reflection.annotation;

import java.lang.annotation.Annotation;

public class TestAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class aClass = TheClass.class;
		Annotation[] annotations = aClass.getAnnotations();
		for(Annotation a:annotations) {
			if(a instanceof MyAnnotation) {
				MyAnnotation a1 = (MyAnnotation)a;
				System.out.println(a1.name());
				System.out.println(a1.value());
			}
		}
		
		Annotation a2 = aClass.getAnnotation(MyAnnotation.class);
		if(a2 instanceof MyAnnotation) {
			MyAnnotation a1 = (MyAnnotation)a2;
			System.out.println(a1.name());
			System.out.println(a1.value());
		}
	}

}
