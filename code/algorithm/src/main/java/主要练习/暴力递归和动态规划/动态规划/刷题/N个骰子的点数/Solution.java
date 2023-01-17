package 主要练习.暴力递归和动态规划.动态规划.刷题.N个骰子的点数;

public class Solution {
    public double[] twoSum(int n) {
        double[] res = new double[5 * n + 1];
        countTime(n,0,0,res);
        for (int i = 0; i < res.length; i++) {
            res[i] /= Math.pow(6.0,Double.valueOf(n));
        }
        return res;
    }
    public void countTime(int n, int index, int sum, double[] res){
        if(index == n){
            res[sum - n] += 1;
            return;
        }
        for(int i = 1; i <= 6; i++)
            countTime(n,index + 1,sum + i,res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (double v : solution.twoSum(2)) {
            System.out.println(v);
        }
    }
}
