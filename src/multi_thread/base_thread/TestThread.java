package multi_thread.base_thread;

/**
 * @Description:通过继承Thread类
 * 1、需要重写Thread类的run()方法。run()方法里放业务逻辑代码
 * 2、创建了Thread对象，通过调用start()方法启动线程。该方法执行对run()方法的调用。
 * @Author: VictorDan
 * @Date: 19-8-12 下午4:11
 * @Version: 1.0
 */
public class TestThread extends Thread {
    private Thread thread;
    private String threadName;

    public TestThread(String threadName) {
        this.threadName = threadName;
        System.out.println("创建线程:"+threadName);
    }

    public TestThread(TestThread testThread, String threadName) {
        this.thread=testThread;
        this.threadName=threadName;
    }

    @Override
    public void run(){
        System.out.println("运行线程："+threadName);
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println("线程为："+threadName+","+i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("线程为"+threadName+"被打断");
        }
        System.out.println("线程"+threadName+"执行完毕并退出");
    }

    @Override
    public void start(){
        System.out.println("开启线程："+threadName);
        if(thread==null){
            thread=new TestThread(this,threadName);
            thread.start();
        }
    }

    public static void main(String[] args) {
        TestThread thread1 = new TestThread("Thread-1");
        thread1.start();
        TestThread thread2 = new TestThread("Thread-2");
        thread2.start();
    }
}
