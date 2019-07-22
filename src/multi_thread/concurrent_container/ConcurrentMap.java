package multi_thread.concurrent_container;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**https://blog.csdn.net/sunxianghuang/article/details/52221913
 * @Description:
 *
 * @Author: VictorDan
 * @Date: 19-7-21 下午11:25
 * @Version: 1.0
 */
public class ConcurrentMap {
    public static void main(String[] args) {

        //Map<String,String> map=new HashMap<>();//哈希表实现,
        //Collections.synchronizedMap(map);
        /**
         * Hashtable是最老的一种实现了，默认都是加了锁的,现在已经用的非常非常少了，因为它的效率比较低
         */
        Map<String,String> map=new Hashtable<>();

        //TreeMap<String,String> map=new TreeMap<>();//树实现

        //Map<String,String> map=new ConcurrentHashMap<>();
        //Map<String,String> map=new ConcurrentSkipListMap<>();//跳表实现

        Random random=new Random();
        Thread[] threads=new Thread[100];
        //我弄了一个门栓，而这个门栓的计数器是100
        CountDownLatch latch=new CountDownLatch(threads.length);
        long start=System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            //把线程数组做了初始化，
            threads[i]=new Thread(()->{
                //往map里装了10000个随机字符串
                for (int j = 0; j <10000 ; j++) {
                    map.put("a"+random.nextInt(100000),"a"+random.nextInt(100000));
                    //每执行玩一个线程后，latch.countDown()，门栓计数器总数减1
                    latch.countDown();
                }
            });
        }
        //然后10000个线程启动
        Arrays.asList(threads).forEach(t->t.start());
        try{
            //主线程在这等着，latch.await().然后所有的线程 执行完后，我们算一下最终的执行时间
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

}
