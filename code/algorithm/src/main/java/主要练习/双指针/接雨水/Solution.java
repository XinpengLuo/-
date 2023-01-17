package 主要练习.双指针.接雨水;

import java.util.Arrays;

public class Solution {
    public int trap(int[] height) {
        if(height.length < 2)
            return 0;
      int ans = 0;
      for(int i = 1; i < height.length - 1; i++){
          int leftMax = Integer.MIN_VALUE;
          for(int j = 0; j < i; j++)
              leftMax = Math.max(leftMax,height[j]);
          int rightMax = Integer.MIN_VALUE;
          for(int j = i + 1; j < height.length; j++)
              rightMax = Math.max(rightMax,height[j]);
          System.out.println(rightMax);
          ans += Math.max(Math.min(leftMax,rightMax) - height[i],0);
      }
      return ans;
    }
    public int trapBetter(int[] height){
        if(height.length < 2)
            return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[right.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++)
            if(height[i] > left[i - 1])
                left[i] = height[i];
            else
                left[i] = left[i - 1];
        for(int i = right.length - 2; i >= 0; i--)
            if(height[i] > right[i + 1])
                right[i] = height[i];
            else
                right[i] = right[i + 1];
        int ans = 0;
        for(int i = 1; i < height.length - 1; i++)
            ans += Math.max(Math.min(left[i - 1],right[i + 1]) - height[i],0);
        return ans;
    }
    public int trapBetterBetter(int[] height){
        if(height.length < 2)
            return 0;
        int[] right = new int[height.length];
        right[right.length - 1] = height[height.length - 1];
        for(int i = right.length - 2; i >= 0; i--)
            if(height[i] > right[i + 1])
                right[i] = height[i];
            else
                right[i] = right[i + 1];
        int ans = 0;
        int leftMax = height[0];
        for(int i = 1; i < height.length - 1; i++)
        {
            ans += Math.max(Math.min(leftMax,right[i + 1]) - height[i],0);
            leftMax = height[i] > leftMax ? height[i] : leftMax;
        }
        return ans;
    }
    public int doublePoint(int[] height){
        if(height.length < 2)
            return 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int ans = 0;
        int i = 1, j = height.length - 2;
        while (i <= j){
            if(leftMax < rightMax){
                ans += Math.max(leftMax - height[i],0);
                leftMax = Math.max(leftMax,height[i]);
                i++;
            }
            else{
                ans += Math.max(rightMax - height[j],0);
                rightMax = Math.max(rightMax,height[j]);
                j--;
            }
        }
        
        return ans;
    }
    public void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++)
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(arr));
        solution.bubbleSort(arr);
    }
}
