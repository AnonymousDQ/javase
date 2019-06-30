package multi_thread.synchronize;


/**
 * @ClassName: T
 * @Description: synchronized的使用
 * @Author: VictorDan
 * @Date: 19-7-1 上午1:49
 * @Version: 1.0
 **/
public class Synchronized_Runnable implements Runnable {
    private int count=10;

    /***
     * 如果不加synchronized，会导致线程重入问题，也就是说比如第一个线程执行count--的时候
     * 还没执行打印，然后下一个线程就进来做了count--操作，本来第一个线程应该打印的是9，可能count--多操作了一次，然后打印
     * 所以会导致数据的不一致的问题。
     *
     * 想要得到一致的话，就需要在执行count--和打印的时候给方法加一把锁。也就是我第一个线程在执行count--和打印的时候
     * 不允许有其他线程访问，直到执行完毕，才让其他线程访问，所以这个值一定是正确的。
     *
     * 从这个层面上来讲，一个synchronized代码块相当于一个原子操作，也就是不可分的，在线程执行这块代码快的时候，持有了这把锁
     * 执行这代码块的时候，是不可能被打断的，只有这个线程执行完后，其他线程才能够继续执行同样代码
     * 所以将一个synchronized的代码块它是原子操作，不可分
     */
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"count--"+count);
    }

    public static void main(String[] args) {
        /***
         * 在栈内存里有一个t引用存在，指向堆内存的空间，new出来一个T对象
         * 在T对象里面有一个count值，它是10，这是堆内存空间的情况
         * 接下来我们起了5个线程，每个线程都是去运行T里面的run方法
         */
        Synchronized_Runnable t=new Synchronized_Runnable();//只new了一个t对象出来，而是好多个线程共同访问这一个对象
        for (int i = 0; i < 5; i++) {
            //由于每个线程访问都是同一个t,这里有5个线程，它们共同拥有的都是t这个对象
            //它们访问的都是t里面的这个run方法，而run方法访问的count当然是同一个
            new Thread(t,"THREAD"+i).start();
        }
    }
}
