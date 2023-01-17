package 主要练习.数组和矩阵.刷题.根据给定数字划分数组;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessArr = new ArrayList<>();
        List<Integer> equalArr = new ArrayList<>();
        List<Integer> greatArr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot)
                lessArr.add(nums[i]);
            else if(nums[i] == pivot)
                equalArr.add(nums[i]);
            else
                greatArr.add(nums[i]);
        }
        lessArr.addAll(equalArr);
        lessArr.addAll(greatArr);
        for(int i = 0; i < nums.length; i++)
            nums[i] = lessArr.get(i);
        return nums;
    }
    public int[] better(int[] nums, int pivot){
        int[] res = new int[nums.length];
        Arrays.fill(res,pivot);
        int left = 0;
        int right = res.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot)
                res[left++] = nums[i];
            else if(nums[i] > pivot)
                res[right--] = nums[i];
        }
        int k = nums.length - 1;
        right++;
        while (right < k){
            int temp = res[right];
            res[right] = res[k];
            res[k] = temp;
            k--;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9,12,5,10,14,3,10};
        System.out.println(Arrays.toString(solution.better(arr, 10)));
    }
}
