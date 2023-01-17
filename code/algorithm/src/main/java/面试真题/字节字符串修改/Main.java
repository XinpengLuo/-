package 面试真题.字节字符串修改;

//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        while(n-- > 0){
//            int len = scanner.nextInt(), k = scanner.nextInt();
//            String s = scanner.next();
//            String flag = scanner.next();
//            int[] count = new int[26];
//            int j = 0;
//            int temp = 0;
//            for(int i = 0; i < s.length(); i++){
//                int index = s.charAt(i) - 'a';
//                if(index != getMax(count)){
//                    if(flag.charAt(i) == '1'){
//                        if(temp < k){
//                            temp--;
//                        }
//                        else{
//
//                        }
//                    }else{
//                        count = new int[26];
//                        count[index]++;
//                        j = i;
//                    }
//                }
//            }
//        }
//    }
//    public static int getMax(int[] count){
//        int max = 0;
//        for(int i = 0; i < count.length; i++)
//        {
//            if(count[i] > max){
//                max = i;
//            }
//        }
//        return max;
//    }
//}

//3
//        5 2
//        abcda
//        01110
//        7 2
//        abbaccb
//        1001001
//        3 0
//        aab
//        101

// 3

//4

//2