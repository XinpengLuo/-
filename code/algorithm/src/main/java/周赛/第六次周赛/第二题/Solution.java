package 周赛.第六次周赛.第二题;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int countLess = 0;
        int countEqual = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target)
                countEqual++;
            if(nums[i] < target)
                countLess++;
        }
        while (countLess < nums.length && countLess <= countEqual){
            ans.add(countLess);
            countLess++;
        }
        return ans;
    }
}
