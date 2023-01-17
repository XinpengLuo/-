package 主要练习.滑动窗口.三个无重叠子数组的最大和;

import java.util.Arrays;

public class Solution {
    //找出数组长度为k的子数组的最大和 即找出数组中长度为k的一个子数组的最大和
    public int findMaxSumByWindowOne(int[] nums, int k){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){ //写笔记时记录下这里是否会越界
            sum += nums[i];
            if(i >= k - 1){
                maxSum = Math.max(sum,maxSum);
                sum -= nums[i - k + 1];
            }
        }
        return maxSum;
    }
    //找出数组长度为k的两个子数组的最大和 即找出数组中长度为k的两个个子数组的最大和 这两个不能重叠 可以不连续
    public int findMaxSumByWindowTwo(int[] nums, int k){
        int ans = Integer.MIN_VALUE;
        int maxSumFirst = Integer.MIN_VALUE;
        int sumFirst = 0;
        int maxSumFirstIndex = -1;
        int a = -1, b = -1;
        int sumSecond = 0;
        for(int i = k; i < nums.length; i++){ //注意这里的起始位置开始非常巧妙
            sumFirst += nums[i - k]; //当两个窗口的值都没有达到k时 注意这里下标的变换 非常好
            sumSecond += nums[k];
            if(i >= (2 * k - 1)){
                if(sumFirst > maxSumFirst){
                    maxSumFirst = sumFirst;
                    maxSumFirstIndex = i - 2 * k + 1; //这些下标-1 自己想想
                }
                if(maxSumFirst + sumSecond > ans){
                    ans = maxSumFirst + sumSecond;
                    a = maxSumFirstIndex; //注意这里第一个的起始下标不能是 直接 i - 2 * k + 1 因为最大的前一个可能不是刚好挨着的 而是之前记录的
                    b = i - k + 1;
                }
                sumFirst -= nums[i - k * 2 + 1];
                sumSecond -= nums[i - k + 1];
            }
        }
        System.out.println(a + " " + b);
        return ans;
    }
    public int[] findMaxSumByWindowThree(int[] nums, int k){
        int ans = Integer.MIN_VALUE;
        int maxSumFirst = Integer.MIN_VALUE;
        int maxSumSecond = Integer.MIN_VALUE;
        int sumFirst = 0, sumSecond = 0, sumThird = 0;
        int maxFirstIndex = -1, maxSecondIndexA = -1,maxSecondIndexB = -1;
        int[] res = new int[3];
        for(int i = 2 * k; i < nums.length; i++){
            sumFirst += nums[i -  2 * k];
            sumSecond += nums[i - k];
            sumThird += nums[i];
            if(i >= 3 * k - 1){
                if(sumFirst > maxSumFirst){
                    maxSumFirst = sumFirst;
                    maxFirstIndex = i - 3 * k + 1;
                }
                if(maxSumFirst + sumSecond > maxSumSecond){
                    maxSumSecond = maxSumFirst + sumSecond;
                    maxSecondIndexA = maxFirstIndex; //因为后面第一个数组的最大值可能改变 但是两个数组的值不一定变
                    maxSecondIndexB = i - 2 * k + 1;
                }
                if(maxSumSecond + sumThird > ans){
                    ans = maxSumSecond + sumThird;
                    res[0] = maxSecondIndexA;
                    res[1] = maxSecondIndexB;
                    res[2] = i - k + 1;
                }
                sumFirst -= nums[i - 3 * k + 1];
                sumSecond -= nums[i - 2 * k + 1];
                sumThird -= nums[i - k + 1];
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,5,10,6,11,17,4,11,1,3};
        System.out.println(solution.findMaxSumByWindowOne(arr, 2));
        System.out.println(solution.findMaxSumByWindowTwo(arr,2));
        System.out.println(solution.findMaxSumByWindowThree(arr,1));
    }
}
