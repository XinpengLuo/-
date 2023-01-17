package 主要练习.暴力递归和动态规划.递归和回溯.刷题.连续差相同的数字;


import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<Integer> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i <= 9; i++)
            help(n - 1,k,i,i);
        int[] nums = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }
    public void help(int n, int k, int temp, int pre){
        if(n == 0){
                if(!res.contains(temp))
                res.add(temp);
                return;
        }
        if(pre + k <= 9)
            help(n - 1,k,temp * 10 + pre + k,pre + k);
        if(pre - k >= 0)
            help(n - 1,k,temp * 10 + pre - k, pre - k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numsSameConsecDiff(2,0);
    }
}
