package 左神.位运算.汉明距离总和;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        //对于每一位 可以组成的汉明距离总和为 1的数量 乘以 0的数量
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < 32; i++){
            int countOne = 0;
            for (int num : nums) {
                if(((num >> i) & 1) == 1)
                    countOne++;
            }
            count += (countOne * (n - countOne));
        }
        return count;
    }
}
