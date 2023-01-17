package 主要练习.滑动窗口.统计优美子数组;

import java.util.HashMap;

public class Solution{
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); //n个奇数出现了n次
        int temp = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0)
                temp++;
            map.put(temp,map.getOrDefault(temp,0) + 1);
            if(temp == k)
                ans++;
            if(temp >= k)
                ans += map.getOrDefault(temp - k,0);
        }
        return ans;
    }
}
