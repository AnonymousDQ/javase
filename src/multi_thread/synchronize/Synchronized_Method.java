package multi_thread.synchronize;

/**
 * @ClassName: TestSynchronized2
 * @Description: synchronized锁
 * @Author: VictorDan
 * @Date: 19-7-1 上午1:31
 * @Version: 1.0
 **/
public class Synchronized_Method {
    private int count=10;

    /***
     * 还有一简单的写法：直接把synchronized修饰方法，这里锁定的是this对象，也就是等方法结束的时候才会释放这把锁
     * 不是锁整段代码，而不是在执行代码的时候，锁定的是当前对象。
     */
    public synchronized void test(){//等同于方法的代码执行的时候要synchronized(this){}
        count--;
        System.out.println(Thread.currentThread().getName()+"count--"+count);
    }
}
