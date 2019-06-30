package multi_thread.synchronize;

/**
 * @ClassName: TestSynchronized1
 * @Description: synchronized的使用
 * @Author: VictorDan
 * @Date: 19-7-1 上午1:23
 * @Version: 1.0
 **/
public class Synchronized_This {
    private int count=10;
    //private Object obj=new Object();

    /***
     * 因为这把锁是我们自己给new出来的，但是每次new出来一个不干别的就来当锁的对象，实在是太麻烦了
     * 可有一个简单的写法，就是synchronized(this){
     *
     * }
     * 如果有人想要执行这个方法，肯定要先new一个TestSynchronized1对象出来，来指向自身，把自身的对象锁定
     * 每次执行这个test方法的时候，首先锁定自身
     *
     * 注意：synchronized锁定的是一个对象，而不是一个代码块
     */

    public void test(){
        synchronized (this){//任何线程要执行下面代码，需要先获取this的锁
            count--;
            System.out.println(Thread.currentThread().getName()+"count--"+count);
        }
    }
}
