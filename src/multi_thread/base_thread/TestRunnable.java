package multi_thread.base_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:通过实现Runnable接口的方式创建线程
 * 1、首先是需要实现Runnable的接口的run方法，run()作为线程提供一个入口，完成的业务逻辑写在run()里
 * 2、通过Thread构造函数，去创建一个实例对象
 * 3、对象调用start()方法来启动线程
 * @Author: VictorDan
 * @Date: 19-8-12 下午3:58
 * @Version: 1.0
 */
public class TestRunnable implements Runnable {
    private Thread thread;
    private String threadName;

    public TestRunnable(String threadName) {
        this.threadName = threadName;
        System.out.println("创建线程："+threadName);
    }

    /**
     * 实现Runnable接口，需要重写run方法
     * run方法里一般写的业务逻辑代码
     */
    @Override
    public void run() {
        System.out.println("创建线程："+threadName);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程："+threadName+","+i);
                Thread.sleep(50);
            }
        }catch(InterruptedException e){
            System.out.println("线程："+threadName+"被打断");
        }
        System.out.println("线程:"+threadName+"执行完退出");
    }

    public void start(){
        System.out.println("开启线程："+threadName);
        if(thread==null){
            thread=new Thread(this,threadName);
            thread.start();
        }
    }

    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        TestRunnable thread1 = new TestRunnable("Thread-1");
        thread1.start();
        TestRunnable thread2 = new TestRunnable("Thread-2");
        thread2.start();
    }
}
