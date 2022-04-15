package 左神leetcode刷题班23讲.第二讲.找出数组中出现次数大于K的数字;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findOverK(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>(); //key -- candi value -- hp
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else{
                if(map.size() == k - 1)
                    removeOne(map);
                else
                    map.put(nums[i],1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> real = getAllReal(map,nums);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(real.get(entry.getKey()) > nums.length / k)
                ans.add(entry.getKey());
        }
        return ans;
    }
    public void removeOne(HashMap<Integer,Integer> map){
        List<Integer> removeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value == 1)
                removeList.add(key);
            map.put(key,value - 1);
        }
        for (Integer integer : removeList) {
            map.remove(integer);
        }
    }
    public HashMap<Integer,Integer> getAllReal(HashMap<Integer,Integer> map, int[] nums){
        HashMap<Integer,Integer> real = new HashMap<>(); //key -- num value -- realCount
        for(int i = 0; i < nums.length; i++){
            int curVal = nums[i];
            if(map.containsKey(curVal))
                real.put(curVal,real.getOrDefault(curVal,0) + 1);
        }
        return real;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2,2,3,2,3,3,3,4,4,4,2,3};
        List<Integer> ans = solution.findOverK(nums, 3);
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
