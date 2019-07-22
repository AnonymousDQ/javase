package multi_thread.test.ticketseller;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 19-7-21 下午11:13
 * @Version: 1.0
 */
public class TicketSeller4 {
    /**
     * 使用了一个并发容器，队列
     */
    static Queue<String> tickets=new ConcurrentLinkedQueue<>();
    static{
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号，"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while(true){
                    /**
                     * 这里面我们并没加锁，但是并不会出问题,
                     * 另外poll()的底层实现是CAS（Compare And Set）不是加锁的实现
                     * 它的效率要高很多
                     */
                    String s=tickets.poll();//poll方法就是往外拿一个数据
                    if(s==null){//如果等于null，说明队列里已经没了。则退出
                        break;
                    }else{
                        System.out.println("销售了--"+s);
                    }

                }
            }).start();
        }
    }
}
