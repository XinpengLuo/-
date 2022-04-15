package 左神.暴力递归和动态规划.动态规划.刷题.跳跃游戏3;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        return help(arr,start);
    }
    public boolean help(int[] arr, int index){
        if(index < 0 || index >= arr.length || arr[index] == -1)
            return false;
        if(arr[index] == 0)
            return true;
        arr[index] = -1;
        return help(arr,index + arr[index]) || help(arr,index - arr[index]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,0,2,1,2};
        if(solution.canReach(arr,2))
            System.out.println(1);
    }
}
