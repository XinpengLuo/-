package 左神.数组和矩阵.刷题.至少是其他数字两倍的最大数;

public class Solution {
    public int dominantIndex(int[] nums) {
        int first = -1;
        int second = -1;
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > first){
                second = first;
                first = nums[i];
                index = i;
            }
            else if(nums[i] > second)
                second = nums[i];
        }
        if(first >= 2 * second)
            return index;
        return -1;
    }
}
