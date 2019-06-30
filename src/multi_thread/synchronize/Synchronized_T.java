package multi_thread.synchronize;

/**
 * @ClassName: Synchronized_T
 * @Description: 同步方法和非同步方法是否可同时调用
 * @Author: VictorDan
 * @Date: 19-7-1 上午2:07
 * @Version: 1.0
 **/
public class Synchronized_T {
    /***
     * 执行m1方法是同步方法，执行的时候是需要锁定当前对象的
     */
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"m1.start----");
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1.end-----");
    }

    /***
     * m2是非同步方法，执行m2的时候不需要锁定当前对象
     */
    public void m2(){
        System.out.println(Thread.currentThread().getName()+"m2.start----");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m2.end----");
    }

    public static void main(String[] args) {
        Synchronized_T t=new Synchronized_T();
        /***
         * 在执行m1的时候，m2可以打印出来，说明在一个synchronized方法执行过程中
         * 非同步方法是可以执行的。
         */
        //jdk1.7之前的写法
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t.m1();
//            }
//        },"t1");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t.m2();
//            }
//        },"t2");
        //lambda表达式1.8写法
        new Thread(()->t.m1(),"t1").start();
        new Thread(()->t.m2(),"t2").start();
        //另一种写法,等价
        //new Thread(t::m1,"t1").start();
        //new Thread(t::m2,"t2").start();
    }
}
