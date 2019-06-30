package multi_thread.synchronize;

/**
 * @ClassName: TestSynchronized
 * @Description: synchronized关键字
 * 对某个对象加锁，锁的是堆内存里的对象
 * @Author: VictorDan
 * @Date: 19-7-1 上午1:09
 * @Version: 1.0
 **/
public class Synchronized_Object {
    private int count=10;
    /***
     * obj这个变量它指向堆内存里new出来的一个对象Object，Object里有一些属性，方法。
     * synchronized(obj)说的是要执行里面的代码，请你先拿到这个对象的锁，这个对象锁是堆内存里new出来的对象
     * 而不是obj这个引用，也就是说真正申请锁的时候，这个锁的信息是记录在堆内存对象里的。Java中堆内存是线程共享的，而栈是线程私有的
     *
     * 如果第二个线程也来执行这段代码，首先也要是申请这把锁，但是第一个线程还没执行完，所以需要等待第一个线程执行完
     * 也就是synchronized代码块结束后，就会释放锁，然后第二个线程获取到这个堆内存里的对象锁，才能执行。
     * 这是个互斥锁，发现这把锁被别人锁了，自己就执行不了，只要有一个线程拿到这把锁，其他线程就拿不到这把锁，所以叫互斥锁
     * 最简单的synchronized
     */
    private Object obj=new Object();

    public void test(){
        synchronized (obj){//任何线程要执行下面的代码的时候，请你先去申请这个对象的锁，
            count--;
            System.out.println(Thread.currentThread().getName()+"count--"+count);
        }
    }
}
