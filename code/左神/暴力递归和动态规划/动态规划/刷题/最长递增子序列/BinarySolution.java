package 左神.暴力递归和动态规划.动态规划.刷题.最长递增子序列;

public class BinarySolution {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > dp[len])
                dp[++len] = nums[i];
            else{
                int left = 1;
                int right = len;
                int res = -1;
                while (left <= right){
                    int middle = left + (right - left) / 2;
                    if(dp[middle] >= nums[i]){
                        res = middle;
                        right = middle - 1;
                    }
                    else
                        left = middle + 1;
                }
                dp[res] = nums[i];
            }
        }
        return len;
    }
    public static int mylengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lastNumOfLen = new int[n + 1]; // lastNumOfLen[i]：以i为长度的子序列的最小末尾数字
        lastNumOfLen[1] = nums[0];
        int len = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > lastNumOfLen[len]){
                lastNumOfLen[++len] = nums[i];
            }else{
                // 替换掉所有比nums[i]大的元素中最小的那个
                int left = 1, right = len;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(lastNumOfLen[mid] < nums[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                lastNumOfLen[left] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,3};
        System.out.println(lengthOfLIS(arr));
    }
}
