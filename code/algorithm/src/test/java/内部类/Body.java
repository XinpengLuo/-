package 内部类;

import java.util.ArrayList;

public class Body {
    private String name = "s";
    public class Heart{
        public void beat(){
            System.out.println("我叫" + name);
        }
    }
    public void methodBody()
    {
        Heart heart = new Heart();
        heart.beat();
    }
}
class Outer{
    public int num = 10;
    public void methodOuter(){
        class Inner{
            int num = 10;
            public void methodInner()
            {
                System.out.println(num);
            }
        }
        Inner inner = new Inner();
        inner.methodInner();
    }
}
interface MyInterface{
    void methodInterface();
}
class myTest{
    public static int a = 1;
    static {
        System.out.println(1);
    }
    public myTest()
    {
        System.out.println("wozai");
    }
    public void myInfo()
    {
        System.out.println("2");
    }
}
class Main{
    public static void main(String[] args) {


    }
}