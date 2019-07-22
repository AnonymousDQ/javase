package multi_thread.test.ticketseller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 19-7-21 下午11:05
 * @Version: 1.0
 */
public class TicketSeller3 {
    static List<String> tickets=new LinkedList<>();
    static{
        for (int i = 0; i <1000 ; i++) {
            tickets.add("票编号，"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while(true){
                    /**就是我每卖出一张票的时候，就都会给他加一把锁，会把它锁到代码段里去。相当于把size()判断和
                     * remove()操作都给他加在同一把锁里去了，它一定不会出现问题。
                     * 加锁的这种方式效率并不高，因为你每次销售一张票，都会把整个队列给锁住。
                     */
                    synchronized (tickets){

                        if(tickets.size()<=0){
                            break;
                        }
                        try{
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了--"+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
