package multi_thread.test.ticketseller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:高并发的实际业务场景
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票，读写一个模拟程序
 *
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？
 * @Author: VictorDan
 * @Date: 19-7-21 下午10:41
 * @Version: 1.0
 */
public class TicketSeller1 {
    static List<String> tickets=new ArrayList<>();
    //list初始化，放10000张票
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号，"+i);
        }
    }

    public static void main(String[] args) {
        /**
         * 写了10个线程，每次往外买票，每次都会进行判断一下票是否卖完了
         */
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size()>0){
                    System.out.println("销售了--"+tickets.remove(0));//因为remove操作不是原子性的，而且没有锁，可能会导致票卖重，或者票卖超了
                }
            }).start();
        }
    }
}
