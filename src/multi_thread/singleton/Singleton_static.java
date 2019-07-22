package multi_thread.singleton;


/**
 * https://www.cnblogs.com/xudong-bupt/p/3433643.html
 * @Description:单例模式
 * 系统中对于某个类的只能有一个对象，不可能出现第二个
 *
 * 线程安全的单例模式（不使用同步锁）,直接new的出来没有了懒加载
 * 缺点：类加载的时候就会直接new一个静态对象出来，当系统中这样的静态类比较多时，就会启动速度变慢。
 * @Author: VictorDan
 * @Date: 19-7-21 下午10:19
 * @Version: 1.0
 */
public class Singleton_static {
    //直接初始化一个实例对象
    private static Singleton_static singleton=new Singleton_static();

    /**
     * private类型的构造方法，保证其他类对象不能直接new一个该对象的实例
     */
    private Singleton_static(){

    }

    /**
     * 暴露一个静态的类来获取单例对象
     * @return
     */
    public static Singleton_static getInstance(){
        return singleton;
    }
}
