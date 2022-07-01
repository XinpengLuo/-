package 左神.位运算.每个查询的最大异或值;

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++)
            temp ^= nums[i];
        int max = (1 << maximumBit) - 1;
        int[] res = new int[nums.length];
        int maxIndex = 0;
        for(int i = 31; i >= 0; i--)
            if(((1 << i) & max) != 0){
                maxIndex = i;
                break;
            }
        for(int i = 0; i < res.length; i++){
            int cur = 0;
            for(int j = maxIndex; j >= 0; j--){
                int target = ((1 << j) & temp) != 0 ? 0 : 1;
                if(target == 1)
                    cur += (1 << j);
            }
            res[i] = cur;
            temp ^= nums[nums.length - i - 1];
        }
        return res;
    }
}