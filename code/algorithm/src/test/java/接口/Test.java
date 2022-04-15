package 接口;
//接口是多个类的公共规范
//接口是一种引用数据类型 最重要的就是其中的抽象方法
//定一个接口的格式 抽象类中的所有方法都是抽象方法
interface MyInterfaceAbstract{
    public abstract int getType();
    
}

abstract class A{
    abstract void test();
}
class B extends A{

    void test()
    {
        System.out.println("EZZZZ");
    }
}
public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.test();
    }
    int tff(int... args){
        return 1;
    }
}
