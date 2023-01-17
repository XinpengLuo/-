package 主要练习.数组和矩阵.刷题.只出现一次的数字3;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        //rightOne = eor & (~eor + 1)
        for(int i = 0; i < nums.length; i++)
            sum ^= nums[i];
        int rightOne = sum & (~sum + 1);
        int oneNumber = 0;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & rightOne) != 0)
                oneNumber ^= nums[i];
        }
        return new int[]{oneNumber,oneNumber ^ sum};
    }
}
