package 左神.暴力递归和动态规划.动态规划.刷题.和为奇数的子数组数目;

public class Solution {
    public int numOfSubarrays(int[] arr) {
        return help(arr,0,0,"");
    }
    public int help(int[] arr, int index, int value, String temp){
        if(index == arr.length){

            if(value % 2 != 0)
                {
                    System.out.println(temp + " sum :" + value);
                    return 1;
                }
            return 0;
        }
        return help(arr,index + 1,value,temp)
                + help(arr,index + 1,value + arr[index],temp + " " + arr[index]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(solution.numOfSubarrays(arr));
    }
}
