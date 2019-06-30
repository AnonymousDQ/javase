package multi_thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Synchronized_Sync
 * @Description: synchronized的应用
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
 * 也就是说synchronized获得对象的锁是可重入的
 * @Author: VictorDan
 * @Date: 19-7-1 上午2:45
 * @Version: 1.0
 **/
public class Synchronized_Sync {
    /***
     * 在m1方法中它是被synchronized修饰的，锁定的当前对象等同于synchronized(this)
     * 然后m1里面调用m2
     *
     * m2也是需要加锁的，但是发现m2也是被synchronized修饰的，它也等同于synchronized(this)锁
     * 也即是在堆内存中申请了一个Synchronized_Sync对象，m1执行的然后给它加了一把锁，然后m1里调用了m2
     * 发现锁的是同一个对象，相当于又给Synchronized_Sync对象在加了一次锁，只不过是从1变成了2，所以说这个锁就是可重入的
     * 可重入的意思：获得锁之后还可以再获得一遍
     */
    public synchronized void m1(){
        System.out.println("m1.start---");
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }
    public synchronized void m2(){
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2.end---");
    }
}
