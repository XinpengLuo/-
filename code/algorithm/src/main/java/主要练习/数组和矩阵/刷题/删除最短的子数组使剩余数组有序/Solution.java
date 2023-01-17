package 主要练习.数组和矩阵.刷题.删除最短的子数组使剩余数组有序;

public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int leftEnd = 0, rightStart = arr.length - 1;
        while (leftEnd < arr.length - 1){
            if(arr[leftEnd + 1] >= arr[leftEnd])
                leftEnd++;
            else
                break;
        }
        while(rightStart >= 1){
            if(arr[rightStart - 1] <= arr[rightStart])
                rightStart--;
            else
                break;
        }
        //如果左边一直递增 那么就是整体递增
        if(leftEnd >= rightStart)
            return 0;
        //如果左边剩下的 和右边剩下的 拼接起来直接满足递增 那么就返回中间没有的
        if(arr[leftEnd] <= arr[rightStart])
            return rightStart - leftEnd - 1;
        //左边直接不要 和 右边直接不要 哪个删除的更少
        int min = Math.min(arr.length - leftEnd - 1, rightStart);
        //左边留一部分 和 右边留一部分
        for(int i = 0; i <= leftEnd; i++){
            int target = arr[i];
            int right = findFirstLargerOrEqual(arr,rightStart,arr.length - 1,target);
            if(right == -1)
                break;
            min = Math.min(min,right - i - 1);
        }
        return min;
    }
    public int findFirstLargerOrEqual(int[] arr, int left, int right, int target){
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target){
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1};
        System.out.println(solution.findLengthOfShortestSubarray(arr));
    }
}
