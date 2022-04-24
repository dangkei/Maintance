package lang.sample;

import java.lang.Object;
import java.lang.String;
import java.lang.System;

public class TestisAssignableFrom {
	public static void main(String[] args) {
        A a = new A();
        B b = new B();
        B b1 = new B();
        C c = new C();
        System.out.println(a.getClass().isAssignableFrom(a.getClass()));
        System.out.println(a.getClass().isAssignableFrom(b.getClass()));
        System.out.println(a.getClass().isAssignableFrom(c.getClass()));
        System.out.println(b1.getClass().isAssignableFrom(b.getClass()));

        System.out.println(b.getClass().isAssignableFrom(c.getClass()));

        System.out.println("=====================================");
        System.out.println(A.class.isAssignableFrom(a.getClass()));
        System.out.println(A.class.isAssignableFrom(b.getClass()));
        System.out.println(A.class.isAssignableFrom(c.getClass()));
        System.out.println(C.class.isAssignableFrom(a.getClass()));

        System.out.println("=====================================");
        System.out.println(Object.class.isAssignableFrom(a.getClass()));
        System.out.println(Object.class.isAssignableFrom(String.class));
        System.out.println(String.class.isAssignableFrom(Object.class));
    }
}


class A{
}
class B extends A{
}
class C extends B{
}