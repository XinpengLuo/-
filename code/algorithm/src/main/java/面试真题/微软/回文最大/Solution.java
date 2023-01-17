package 面试真题.微软.回文最大;

import java.util.*;
class Solution {
    public String solution(String S) {
        // write your code in Java 11 (Java SE 11)
        int[] count = new int[10];
        for(int i = 0; i < S.length(); i++)
            count[S.charAt(i) - '0']++;
        if(count[0] == S.length())
            return "0";
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        int maxEvenNum = -1;
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0)
                continue;
            int num = -1, n = 0;
            if((count[i] & 1) == 1){ //The number is odd
                maxEvenNum = i;
                if(count[i] >= 3){
                    num = i;
                    n = count[i] - 1;
                }
                else{
                    continue;
                }
            }
            else{ //The number is even
                if(i != 0)
                    flag = true;
                num = i;
                n = count[i];
            }
            for(int j = 0; j < n / 2; j++){
                sb.insert(0,num);
                sb.insert(sb.length(),num);
            }
        }
        if(!flag)
            return "" + maxEvenNum;
        if(maxEvenNum != -1)
            sb.insert(sb.length() / 2,maxEvenNum);
        return sb.toString();
    }


}
