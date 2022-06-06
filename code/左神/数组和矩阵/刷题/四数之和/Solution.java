package 左神.数组和矩阵.刷题.四数之和;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == nums[j - 1] && j != i + 1)
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(temp == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while(left < right && nums[left + 1] == nums[left])
                            left++;
                        while(left < right && nums[right - 1] == nums[right])
                            right--;
                        left++;
                        right--;
                    }
                    else if(temp < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr  = {1,-2,-5,-4,-3,3,3,5};
        Solution solution = new Solution();
        solution.fourSum(arr,-11);
    }
}
