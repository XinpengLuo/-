package 临时测试;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        HashSet<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1111);
        list.add(22222);
        List<Integer> list1 = new ArrayList<>(list);
        ans.add(list1);
        List<Integer> list2 = new ArrayList<>(list);
        ans.add(list2);
        list1.hashCode();
        System.out.println(list1.equals(list2));
//        for (List<Integer> an : ans) {
//            System.out.println(an);
//        }
    }
    public static void test(){
        String s1 = "hello";
        String s2 = s1 + ",world";
        String s3 = "hello" + ",world";
        String s4 = "hello,world";
        String s5 = new String("hello,world");
        int a = 1;
        int b = 1;

//        System.out.println(s1 == "hello");
//        System.out.println(s2.equals(s4)); true
        // System.out.println(s2==s4);　 false　　　　
        // System.out.println(s3==s4);　　true　　　
        // System.out.println(s4==s5);　 false　　　　
    }
}
