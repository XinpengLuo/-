package 主要练习.字符串.最长回文串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i),1);
        }
        int res = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> temp : map.entrySet()) {
            if(temp.getValue() % 2 == 0)
                res += temp.getValue();
            else
               {
                   flag = true;
                   res += temp.getValue() - 1;
               }
        }
        return flag ? res + 1 : res;
    }
    public void testSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++)
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {12,4,1,2,3,56,7,7,9};
        Solution solution = new Solution();
        solution.testSort(arr);
    }
}
