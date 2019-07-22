package multi_thread.test.ticketseller;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 19-7-21 下午10:50
 * @Version: 1.0
 */
public class TicketSeller2 {
    /**
     * 第一个小程序使用的ArrayList，大家都知道它不是同步的,它的remove方法啊，各种各样的方法都不是同步的，所以在高并发的情况下一定会出问题
     *但是改用Vector容器，它是一个同步容器,它所有的方法都是加锁的
     **/
    static Vector<String> tickets=new Vector<>();
    static{
        for (int i = 0; i <10000 ; i++) {
            tickets.add("票编号,"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
               while(tickets.size()>0){
                   /**
                    * 虽然是在Vector里，它的remove方法是原子的,而且size()也是原子性的，但是两个是分离的
                    * 也就是谁也挡不住在这两个原子操作中间有可能被打断。如果这个地方被打断的话，问题依旧，结果访问越界了。
                    * 可以在中间加一点模拟性的睡眠，它就出问题了，因为在你实际开发的过程中，可能会有各种的逻辑代码 ，在你size()判断操作
                    * 和remove()操作中间。也就是一个线程执行size判断的时候，还没到执行remove操作的时候，由于两个操作中间有其他的逻辑代码
                    * 所以这个线程还是有可能被其他线程打断。也即是A线程判断了size()>0还没等到remove的时候，B线程把最后一张票给拿走了
                    * 这时候等A执行玩睡眠后，再去执行remove就直接报错，访问越界。
                    *
                    * 总结：你只是把这个容器换成同步容器，问题依旧。
                    */
                   try{
                       TimeUnit.MILLISECONDS.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("销售了--"+tickets.remove(0));
               }
            }).start();
        }
    }
}
