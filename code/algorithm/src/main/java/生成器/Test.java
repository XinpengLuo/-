package 生成器;

public class Test {

    public static void main(String[] args) {

        String s = new String("aaa");
        System.out.println("原始字符串s的hashcode值："+ s.hashCode());
        Test t = new Test();
        t.change(s);
        System.out.println("方法调用后s的值"+s);
    }
    public void change(String s1){
        System.out.println("方法中s1初始值"+s1);
        System.out.println("方法中s1初始hashcode值"+s1.hashCode());
        s1 ="bbb";
        System.out.println("方法中s1赋值后："+s1);
        System.out.println("方法中s1赋值后hashcode值："+s1.hashCode());

    }

}