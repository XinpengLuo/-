package 主要练习.数组和矩阵.刷题.子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        help(nums,0,new ArrayList<>());
        return new ArrayList<>(res);
    }
    public void help(int[] nums, int index, List<Integer> list){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        help(nums,index + 1,list);
        list.add(nums[index]);
        help(nums,index + 1,list);
        list.remove(list.size() - 1);
    }
}
