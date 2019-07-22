package multi_thread.singleton;

/**
 * @Description:使用双重同步锁的线程安全单例模式
 * @Author: VictorDan
 * @Date: 19-7-21 下午10:26
 * @Version: 1.0
 */
public class Singleton_double_check {
    private static Singleton_double_check instance;
    private Singleton_double_check(){

    }

    /**
     * 对获取实例的方法进行同步
     * @return
     */
    public static Singleton_double_check getInstance(){
        if(instance==null){
            synchronized (Singleton_double_check.class){
                if(instance==null){
                    instance=new Singleton_double_check();
                }
            }
        }
        return instance;
    }
}
