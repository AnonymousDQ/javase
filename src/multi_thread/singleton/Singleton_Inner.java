package multi_thread.singleton;

import java.util.Arrays;

/**
 * @Description:更好的是采用下面的方式，既不用加锁，也能实现懒加载
 * 什么叫懒加载？
 * 也就是当我需要的时候，我才会把它给new出来，当我们执行到getInstance()的时候
 * Inner.instance执行到的时候才开始初始化，创建对象
 * @Author: VictorDan
 * @Date: 19-7-21 下午10:31
 * @Version: 1.0
 */
public class Singleton_Inner {
    private Singleton_Inner(){
        System.out.println("single");
    }

    /**
     * 使用静态内部类的方式
     */
    private static class Inner{
        private static Singleton_Inner instance=new Singleton_Inner();
    }

    /**
     * 返回的是内部类的静态对象
     * @return
     */
    public static Singleton_Inner getInstance(){
        return Inner.instance;
    }

    /**
     * 无论如何就只有一个实例对象
     * @param args
     */
    public static void main(String[] args) {
        Thread[] threads=new Thread[200];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(()->{
                Singleton_Inner.getInstance();
            });
        }
        Arrays.asList(threads).forEach(o->o.start());
    }
}
