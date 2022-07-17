package 左神.数组和矩阵.刷题.k次取反;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author luoxinpeng
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        int ans = Arrays.stream(nums).sum();
        int min = Integer.MAX_VALUE;
        while (index < nums.length && nums[index] < 0 && k > 0){
            ans += Math.abs(nums[index]) * 2;
            min = Math.min(Math.abs(nums[index]),min);
            k--;
            index++;
        }
        if(k < 0 || (index < nums.length && nums[index] == 0) || k % 2 == 0) {
            return ans;
        }
        return index < nums.length ? ans - 2 * Math.min(nums[index],min) : ans - 2 * min;
    }
    public int better(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int ans = Arrays.stream(nums).sum();
        while (k > 0){
            int temp = queue.poll();
            if(temp < 0) {
                ans += 2 * Math.abs(temp);
            }
            else {
                ans -= 2 * temp;
            }
            queue.add(-temp);
            k--;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,-3,-1,5,-4};
        System.out.println(solution.largestSumAfterKNegations(arr,2));
        System.out.println(solution.better(arr,2));
    }
}
