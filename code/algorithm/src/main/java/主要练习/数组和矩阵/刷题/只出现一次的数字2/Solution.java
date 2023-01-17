package 主要练习.数组和矩阵.刷题.只出现一次的数字2;

public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                count +=( (nums[j] >> i) & 1);
            }
            if(count % 3 == 1)
                ans = ans | (1 << i);
        }
        return ans;
    }
}
