package 主要练习.暴力递归和动态规划.递归和回溯.刷题.剑指OfferII083没有重复元素集合的全排列;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        help(nums,new ArrayList<>());
        return res;
    }
    public void help(int[] nums, ArrayList<Integer> set){
        if(set.size() == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }
        for(int i = 0; i < nums.length; i++)
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                int index = set.size() - 1;
                help(nums,set);
                set.remove(index);
            }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        solution.permute(nums);
    }
}
