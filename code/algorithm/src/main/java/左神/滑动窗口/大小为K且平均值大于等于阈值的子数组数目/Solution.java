package 左神.滑动窗口.大小为K且平均值大于等于阈值的子数组数目;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(i >= k - 1){
                if(sum / k >= threshold)
                    ans++;
                sum -= arr[i - k + 1];
            }
        }
        return ans;
    }
}
