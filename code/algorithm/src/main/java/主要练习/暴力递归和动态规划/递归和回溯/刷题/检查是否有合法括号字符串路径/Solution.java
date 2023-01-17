package 主要练习.暴力递归和动态规划.递归和回溯.刷题.检查是否有合法括号字符串路径;

public class Solution {
    public boolean hasValidPath(char[][] grid) {

        return dp(grid);
    }
    public boolean dfs(char[][] grid, int i, int j, int temp){
        if(i >= grid.length || j >= grid[i].length || temp < 0)
            return false;
        char c = grid[i][j];
        temp += c == '(' ? 1 : -1;
        if(i == grid.length - 1 && j == grid[i].length - 1) {
            return temp == 0;
        }
        return dfs(grid, i + 1, j, temp) || dfs(grid, i, j + 1, temp);
    }

    public boolean dp(char[][] grid) {
        int n = grid.length, m = grid[0].length, max = n + m - 1;
        boolean[][][] dp = new boolean[n + 1][m + 1][max + 1];
        dp[n - 1][m - 1][1] = true;
        for(int i = n - 1; i >= 0; i--)
            for(int j = m - 1; j >= 0; j--)
                for(int k = 0; k <= max; k++){
                    char c = grid[i][j];
                    int temp = k + (c == '(' ? 1 : -1);
                    if(temp < 0 || temp >= max)
                        continue;
                    dp[i][j][k] = dp[i + 1][j][temp] || dp[i][j + 1][temp];
                    dp[n - 1][m - 1][1] = true;
                }
        return dp[0][0][0];
    }



    public static void main(String[] args) {
        char[][] grid = {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
        Solution solution = new Solution();
        System.out.println(solution.hasValidPath(grid));

    }
}
