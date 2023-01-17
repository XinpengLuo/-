package 主要练习.滑动窗口.第K小的子数组和;

public class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max += num;
            min = Math.min(min,num);
        }
        int i = min, j = max;
        int ans = -1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            System.out.println(mid);
            int temp = getLessAndEqualNumber(mid, nums);
            if(temp < k)
                i = mid + 1;
            else{
                j = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    public int better(int[] nums, int k){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max += num;
            min = Math.min(min,num);
        }
        int i = min, j = max;
        int ans = -1;
        while (i <= j){
            int mid = i + (j - i) / 2;

            int temp = getLess(mid, nums);
            System.out.println(mid + " ：" + temp);
            if(temp == k - 1)
                return mid;
            else if(temp > k - 1){
                j = mid - 1;
            }
            else
                i = mid + 1;
        }
        return ans;
    }
    public int getLess(int target, int[] nums){
        int count = 0;
        int sum = 0, j = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum >= target){
                sum -= nums[j];
                j++;
            }
            count += (i - j + 1);
        }
        return count;
    }
    public int getLessAndEqualNumber(int target, int[] nums){
        int count = 0;
        int sum = 0, j = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum > target){
                sum -= nums[j];
                j++;
            }
            if(sum <= target)
                count += (i - j + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3};
        Solution solution = new Solution();
        System.out.println(solution.better(arr, 4));
    }
}
