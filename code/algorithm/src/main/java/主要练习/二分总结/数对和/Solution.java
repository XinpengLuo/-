package 主要练习.二分总结.数对和;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            int tempSum = nums[i] + nums[j];
            if(tempSum == target)
                res.add(Arrays.asList(nums[i],nums[j]));
            else if(tempSum < target)
                i++;
            else
                j--;
        }
        return res;
    }
}
