package Reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

class Student{
    public void sleep(){
        System.out.println("sleep");
    }
}
class Person{
    public void eat(){
        System.out.println("eat");
    }
}
public class Reflect {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象 可以执行任意的方法
        //在不改变任何代码的前提下
        //1 将需要创建对象的全类名和需要执行的方法放在配置文件中
        //2 在程序中加载读取配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = Reflect.class.getClassLoader();
        InputStream is = Reflect.class.getResource("/pro.properties").openStream();
        pro.load(is);
        //3 使用反射技术加载类文件进内存
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        Class cls = Class.forName(className);
        //4 创建对象
        Object object = cls.newInstance();
        //5 执行方法
        Method method = cls.getMethod(methodName);
        method.invoke(object);
    }
}
