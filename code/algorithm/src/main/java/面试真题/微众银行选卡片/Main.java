package 面试真题.微众银行选卡片;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] nums = new String[n];
        for(int i = 0; i < n; i++)
            nums[i] = scanner.next();
        String res = "";
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                if(t1.length() != t2.length())
                    return t2.length() - t1.length();
                return t2.compareTo(t1);
            }
        });
        String[] temp = new String[3];
        for(int i = 0; i < temp.length; i++)
            temp[i] = nums[i];
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t2.compareTo(t1);
            }
        });
        System.out.println(temp[0] + temp[1] + temp[2]);
    }
}