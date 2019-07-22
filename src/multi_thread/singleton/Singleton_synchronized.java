package multi_thread.singleton;

/**
 * @Description:使用同步方法的线程安全的单例模式
 * @Author: VictorDan
 * @Date: 19-7-21 下午10:25
 * @Version: 1.0
 */
public class Singleton_synchronized {
    private static Singleton_synchronized instance;
    private Singleton_synchronized(){

    }
    //对获取实例对象的方法进行同步
    public static synchronized Singleton_synchronized getInstance(){
        if(instance==null){
            instance=new Singleton_synchronized();
        }
        return instance;
    }
}
