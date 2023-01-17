package 主要练习.暴力递归和动态规划.动态规划.刷题.三角形的最小路径和;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return help(triangle,0,0);
    }
    public int help(List<List<Integer>> triangle,int level,int index){
        if(index == triangle.get(level).size())
            return Integer.MAX_VALUE;
        if(level == triangle.size() - 1)
            return triangle.get(level).get(index);
        return triangle.get(level).get(index) + Math.min(help(triangle,level + 1,index), help(triangle,level + 1,index + 1));
    }
    public int dp(List<List<Integer>> triangle){
        int size = triangle.size();
        int[][] dp = new int[size][triangle.get(size - 1).size()];
        for(int i = dp.length - 1; i >=0; i--)
            {
                int max = triangle.get(i).size();
                for(int j = 0; j < max;j++){
                    int a = i + 1 >= dp.length ? 0 : dp[i + 1][j];
                    int b = i + 1 >= dp.length ? 0 : dp[i + 1][j + 1];
                    dp[i][j] = triangle.get(i).get(j) +  Math.min(a,b);
                }
            }
        for (int[] t : dp) {
            System.out.println(Arrays.toString(t));
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
    }
}
