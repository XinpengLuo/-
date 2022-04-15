package 左神.滑动窗口.最少交换次数来组合所有的1II;

public class Solution {
    public int minSwaps(int[] nums) {
        int countOne = 0;
        for (int num : nums)
            if(num == 1)
                countOne++;
        int temp = 0;
        int res = Integer.MAX_VALUE;
        int j = 0, i = 0;
        while (j < nums.length){
            if(nums[i] == 1)
                temp++;
            if(i >= countOne - 1 || j > i){
                res = Math.min(res,countOne - temp);
                if(res == 0)
                    return res;
                if(nums[j] == 1)
                    temp--;
                j++;
            }
            i = (i + 1) % nums.length;
        }
        return res;

    }
}
