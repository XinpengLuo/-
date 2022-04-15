package 左神.字符串.不想交的线;

public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return help(nums1,nums2,0,0);
    }
    public int help(int[] nums1, int[] nums2, int index1, int index2){
        if(index1 == nums1.length || index2 == nums2.length)
            return 0;
        int res = 0;
        for(int i = index1; i < nums1.length; i++)
            for(int j = index2; j < nums2.length; j++){
                if(nums1[i] == nums2[j])
                    res = Math.max(res, 1 + help(nums1,nums2,i + 1,j + 1));
            }
        return res;
    }
    public int dpTwo(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = nums1.length - 1; i >= 0; i--)
            for(int j = nums2.length - 1; j >= 0; j--){
                if(nums1[i] == nums2[j])
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
            }
        return dp[0][0];
    }
    public int dp(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int index1 = dp.length - 2; index1 >= 0; index1--)
            for(int index2 = dp[index1].length - 2; index2 >= 0; index2--){
                int res = 0;
                for(int i = index1; i < nums1.length; i++)
                    for(int j = index2; j < nums2.length; j++){
                        if(nums1[i] == nums2[j])
                            res = Math.max(res,1 + dp[i + 1][j + 1]);
                    }
                dp[index1][index2] = res;
            }
        return dp[0][0];
    }
}
