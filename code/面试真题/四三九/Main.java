package 面试真题.四三九;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    }
    public void example(){
        String[] words = new String[3];
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t1.length() - t2.length();
            }
        });
        PriorityQueue<String> test = null;
    }
}
