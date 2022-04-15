package 左神.暴力递归和动态规划.动态规划.标准推导.博弈问题;

public class Solution {
    public int first(int[] arr, int left, int right){
        if(left == right)
            return arr[left];
        return Math.max(arr[left] + second(arr,left + 1,right),arr[right] + second(arr,left,right - 1));
    }
    public int second(int[] arr, int left, int right){
        if(left == right)
            return 0;
        return Math.min(first(arr,left + 1, right),first(arr,left,right - 1));
    }

    public static void main(String[] args) {
        int[] arr = {1,100,13};
        Solution solution = new Solution();
        System.out.println(solution.first(arr, 0, arr.length - 1));
        System.out.println(solution.second(arr,0,arr.length - 1));
    }
}
