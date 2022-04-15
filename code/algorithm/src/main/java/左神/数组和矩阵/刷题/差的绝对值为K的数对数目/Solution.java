package 左神.数组和矩阵.刷题.差的绝对值为K的数对数目;

import javax.swing.*;
import java.util.HashMap;

public class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            count += map.getOrDefault(temp + k,0);
            count += map.getOrDefault(temp - k,0);
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }
        return count;
    }
}
