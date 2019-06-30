package multi_thread.synchronize;

/**
 * @ClassName: Synchronized_Static
 * @Description: synchronized锁
 * @Author: VictorDan
 * @Date: 19-7-1 上午1:39
 * @Version: 1.0
 **/
public class Synchronized_Static {
    private static int count=10;
    //synchronized修饰static静态方法
    public synchronized static void test(){//这里等同于synchronized(multi_thread.synchronize.Synchronized_Static.class)
        count--;
        System.out.println(Thread.currentThread().getName()+"cont--"+count);
    }

    /***
     * 由于静态的static的时候，没有this可以锁定
     * 因为static的方法，属性，你是不需要new出对象来访问的，所以这个时候是没有this的
     * 所以是不可以写为synchronized(this){}的，static的没有new出来，也就没有this引用的存在
     * 所以当你锁定一个static静态方法的时候，你相当于锁定的是这个类的Class对象
     */
    public static void test1(){
        synchronized (Synchronized_Static.class){//学过反射都知道，Synchronized_Static.class是Class（java.lang.Class里的）的一个对象
            count--;
        }
    }
}
