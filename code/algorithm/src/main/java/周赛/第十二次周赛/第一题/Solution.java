package 周赛.第十二次周赛.第一题;

import java.util.HashMap;

public class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == key){
                int target = nums[i + 1];
                map.put(target,map.getOrDefault(target,0) + 1);
                if(map.get(target) > max){
                    max = map.get(target);
                    res = target;
                }
            }
        }
        return res;
    }
}
