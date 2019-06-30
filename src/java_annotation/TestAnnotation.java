package java_annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: TestAnnotation
 * 使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口
 * @interface用来声明一个注解
 * 格式：public @interface name{
 *     定义体
 * }
 * 其中的每一个方法实际上是声明了一个配置参数。
 * 方法的名称就是参数的名称
 * 返回值类型就是参数的类型（返回值类型只能是基本类型，Class,String,enum）
 * 可以通过default来声明参数的默认值
 * 注解元素必须要有值，定义默认值的时候，经常使用空字符串，0为默认值
 * 也经常使用负数(-1)表示不存在的含义
 * 如果只有一个参数成员，一般参数名为value
 * @Description: 自定义注解
 * @Author: VictorDan
 * @Date: 19-6-30 下午7:25
 * @Version: 1.0
 **/
//表示只能用在方法前面的注解
@Target(value= {ElementType.METHOD,ElementType.TYPE})//可以注解在方法，和类，接口上
@Retention(RetentionPolicy.RUNTIME)//定义为RUNTIME可以使用反射来读取，如果是SOURCE反射就读取不到
public @interface TestAnnotation {
    String studentName() default "";//参数类型 参数名
    int age() default 0;
}
