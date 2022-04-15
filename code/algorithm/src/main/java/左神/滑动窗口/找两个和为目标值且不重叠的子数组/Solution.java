package 左神.滑动窗口.找两个和为目标值且不重叠的子数组;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            while (sum > target){
                sum -= arr[j];
                j++;
            }
            if(sum == target){
                int length = i - j + 1;
                dp[i] = Math.min(length,i - 1 >= 0 ? dp[i - 1] : Integer.MAX_VALUE);
                if(j - 1 >= 0 && dp[j - 1] != Integer.MAX_VALUE)
                    ans = Math.min(length + dp[j - 1],ans);
            }
            else{
                dp[i] = i - 1 >= 0 ? dp[i - 1] : Integer.MAX_VALUE;
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7,3,4,7};
        System.out.println(solution.minSumOfLengths(arr, 7));
    }
}
