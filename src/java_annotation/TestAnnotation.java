package java_annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: TestAnnotation
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
