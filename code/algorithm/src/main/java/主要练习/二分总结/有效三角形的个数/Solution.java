package 主要练习.二分总结.有效三角形的个数;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                continue;
            for(int j = i + 1; j < nums.length; j++){
                int c = nums[i] + nums[j];
                //去寻找最后一个不大于c的下标 因为第三条边 不能大于两边之和
                int left = j + 1;
                int right = nums.length - 1;
                int index = -1;
                while (left <= right){
                    int middle = left + (right - left) / 2;
                    if(nums[middle] < c){
                        index = middle;
                        left = middle + 1;
                    }
                    else
                        right = middle - 1;
                }
                if(index != -1){
                    count += (index - j);
                }
            }
        }
        return count;
    }
    public int better(int[] nums){
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                continue;
            int k = i;
            for(int j = i + 1; j < nums.length; j++){
                int c = nums[i] + nums[j];
                while (k < nums.length && nums[k] < c)
                    k++;
                count += (k - 1 - j);
            }
        }
        return count;
    }
}
