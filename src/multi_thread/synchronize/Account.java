package multi_thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Account
 * @Description: 银行业务问题
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题（dirtyRead）
 * @Author: VictorDan
 * @Date: 19-7-1 上午2:23
 * @Version: 1.0
 **/
public class Account {
    String name;
    double balance;

    public synchronized void set(String name,double balance){
        this.name=name;
        /***
         * try块的代码是放大了线程执行的时间差，也就是set的name之后，
         * 当你准备set的banlance值的时候，中间可能会被其他线程去执行
         * 就是你的业务代码可能被停掉也就是你的getBalance，让其他线程先去执行的
         * 尽管你在set写的方法里加了synchronized锁，锁定了这个对象
         * 锁定这个对象的过程之中，它仍然有可能被那些非同步方法去访问的。
         * 这个时候就会产生脏读dirtyRead问题，因为你只是对set写加了锁
         * 没有对读get方法加锁，这个时候就读取的数据是不一致的
         *
         *  脏读：就是你尽管是对写加了锁，但是没有对读加锁，那么有可能你会读到在写的过程之中还没有完成的数据。
         *
         *  解决方法：在读方法上也加synchronized
         */
        try{
            Thread.sleep(2000);//设置账户的时候，先让它睡2秒钟，
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }
    public /*synchronized*/ double getBalance(String name) {
        return balance;
    }

    public static void main(String[] args) {
        Account account=new Account();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                account.set("张三",100.0);
//            }
//        }).start();
        /***
         * 开一个线程，设置张三，账户100
         */
        new Thread(()->account.set("张三",100.0)).start();
        /***
         * 然后睡一秒钟
         */
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //主线程读取你发现是0
        System.out.println(account.getBalance("张三"));
        //然后再睡2秒中之后，再去拿账户里的钱，读出来才是100
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("张三"));
    }
}
