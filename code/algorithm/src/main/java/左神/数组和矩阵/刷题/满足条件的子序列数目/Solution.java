package 左神.数组和矩阵.刷题.满足条件的子序列数目;

import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {
        long count = 0;
        int mod = (int)1e9+7;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] * 2 > target)
                break;
            int index = -1;
            int left = i, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[i] + nums[mid] <= target){
                    index = mid;
                    left = mid + 1;
                }
                else
                    right = mid - 1;
            }
            int n = index - i;
            count += fastPow(2,n,mod);
            count %= mod;
        }
        return (int) count;
    }
    public long fastPow(int x, int n, int mod){
        long res = 1, base = x;
        while(n > 0){
            if((n & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            n /= 2;
        }
        return res % mod;
    }
    public long fastPowF(int _x, int n, int MOD){
        long res = 1, x= _x;
        while(n>0){
            if((n&1)==1)
                res =(res * x)%MOD;
            x=(x*x)%MOD;
            n>>=1;
        }
        return res%MOD;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fastPow(2, 10, 10000));
    }
}