package 左神.数组和矩阵.刷题.三数之和;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i - 1] == nums[i])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && nums[left + 1] == nums[left])
                        left++;
                    while (left < right && nums[right - 1] == nums[right])
                        right--;
                    left++;
                    right--;
                }
                else if(temp < 0)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }
    public void quickSort(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int target = nums[left];
        while (i < j){
            while (i < j && nums[j] >= target)
                j--;
            while (i < j && nums[i] <= target)
                i++;
            swap(nums,i,j);
            i++;
            j--;
        }
        quickSort(nums,left,i - 1);
        quickSort(nums,i + 1,right);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
