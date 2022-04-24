package atom;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * 这是测试整型数字原子性的一个测试
 * */
public class TestAtomicInteger {
	private static AtomicInteger acount = new AtomicInteger(0);
	private static Integer count = 0;
	private static volatile Integer count2 = 0;
    public static void main(String[] args) throws Exception {
        test0();
        test2();
        test3();
    }
    static void test0() throws Exception{
        Long starTime = System.currentTimeMillis();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000000; i++){
            	TestAtomicInteger.acount.getAndIncrement();
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(acount);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行了："+(endTime - starTime)+"毫秒");
    }
    
    static void test1() throws Exception{
        Long starTime = System.currentTimeMillis();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000000; i++){
            	TestAtomicInteger.count++;
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行了："+(endTime - starTime)+"毫秒");
    }
    /*第1种使用 count变量没做任何处理修饰 结果是2e次累加后等于不到2e，说明没有实现原子性
     * 101953882
	 *程序运行了：1797毫秒
     * */
    static void test2() throws Exception{
        Long starTime = System.currentTimeMillis();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000000; i++){
            	TestAtomicInteger.count2++;
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count2);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行了："+(endTime - starTime)+"毫秒");
    }
    /*第2种使用 volatile修饰主体类count2 结果是2e次累加后等于不到2e，说明没有实现原子性
     * 120341876
	 *程序运行了：4692毫秒
     * */
    
    static void test3() throws Exception{
        Long starTime = System.currentTimeMillis();
        Runnable runnable = () -> {
            synchronized (TestAtomicInteger.class){
                for (int i = 0; i < 100000000; i++){
                	TestAtomicInteger.count++;
                }
           }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行了："+(endTime - starTime)+"毫秒");
    }
    /*第3种使用 synchronized修饰主体类count变量实现了原子性 结果是想要的2e次累加后等于2e
     * 200000000
	 *程序运行了：707毫秒 效率高啊
     * */
}
