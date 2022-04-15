package 左神.暴力递归和动态规划.动态规划.标准推导.机器人左右走;

public class Solution {
    public int getAllMethod(int[] arr, int index, int target, int times){
        if(index < 0 || index >= arr.length)
            return 0;
        if(times == 0){
            if(target == index)
                return 1;
            else
                return 0;
        }

        return  getAllMethod(arr,index + 1,target,times - 1) + getAllMethod(arr,index - 1,target,times - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        Solution solution = new Solution();
        System.out.println(solution.getAllMethod(arr, 2, 3, 3));
    }
}
