package 周赛.第九次周赛.第二题;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> even = new HashMap<>(); //偶数
        HashMap<Integer,Integer> odd = new HashMap<>(); //奇数
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0)
                even.put(nums[i],even.getOrDefault(nums[i],0) + 1);
            else
                odd.put(nums[i],odd.getOrDefault(nums[i],0) + 1);
        }
        int maxEven1 = 0, maxEven2 = 0, maxNumber1 = 0;
        int maxOdd1 = 0, maxOdd2 = 0, maxNumber2 = 0;
        //求出偶数出现次数最多的数字 和 第二大数字
        for (Integer key : even.keySet()) {
            if(even.get(key) > maxEven1)
               {
                   maxNumber1 = key;
                   maxEven2 = maxEven1;
                   maxEven1 = even.get(key);
               }else if(even.get(key) >maxEven2)
                   maxEven2 = even.get(key);
        }
        //求出奇数出现次数最多的数字 和 第二大数字
        for (Integer key : odd.keySet()) {
            if(odd.get(key) > maxOdd1){
                maxNumber2 = key;
                maxOdd2 = maxOdd1;
                maxOdd1 = odd.get(key);
            }
            else if(odd.get(key) > maxOdd2)
                maxOdd2 = odd.get(key);
        }
        int len = nums.length;
        int evenLength = len % 2 == 0 ? len / 2 : (len / 2) + 1;
        int oddLength = len - evenLength;
        if(maxNumber1 != maxNumber2)
            return (evenLength - maxEven1) + (oddLength - maxOdd1);
        return Math.min((evenLength - maxEven2) + (oddLength - maxOdd1), (evenLength - maxEven1) + (oddLength - maxOdd2));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {69,91,47,74,75,94,22,100,43,50,82,47,40,51,90,27,98,85,47,14,55,82,52,9,65,90,86,45,52,52,95,40,85,3,46,77,16,59,32,22,41,87,89,78,59,78,34,26,71,9,82,68,80,74,100,6,10,53,84,80,7,87,3,82,26,26,14,37,26,58,96,73,41,2,79,43,56,74,30,71,6,100,72,93,83,40,28,79,24};
        System.out.println(1 ^ 1);
    }
}
