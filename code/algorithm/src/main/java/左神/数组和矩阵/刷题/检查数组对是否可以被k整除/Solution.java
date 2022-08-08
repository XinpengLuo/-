package 左神.数组和矩阵.刷题.检查数组对是否可以被k整除;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] map = new int[k];
        for(int i = 0; i < arr.length; i++){
            int temp = (arr[i] % k + k) % k;
            map[temp]++;
        }
        if(map[0] % 2 != 0)
            return false;
        for(int i = 1; i < k / 2; i++)
            if(map[i] != map[k - i])
                return false;
        return true;
    }

//    public static void main(String[] args) throws ParseException {
//        String s = "1655540200000";
//        String format = format(1638753984071, "yyyy/MM/dd");
//        System.out.println(format);
//    }
//    public static String format(String time,String pattern){
//        Date date = new Date();
//        date.setTime(time);
//        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//
//        return DateTimeFormatter.ofPattern(pattern).format(localDateTime);
//    }
}
