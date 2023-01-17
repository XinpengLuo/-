package 主要练习.数组和矩阵.刷题.和为奇数子数组的数目;

public class Solution {
    public int numOfSubarrays(int[] arr) {
       int countOdd = 0; //统计奇数的数目
       int countEven = 1; //统计偶数的数目
       int preSum = 0;
       int ans = 0;
       int mod = 1000000007;
       for(int i = 0; i < arr.length; i++){
           preSum += arr[i];
           if(preSum % 2 == 0){
               countEven++;
               ans = (ans + countOdd) % mod;
           }
           else{
               countOdd++;
               ans = (ans + countEven) % mod;
           }
       }
       return ans;
    }
}
