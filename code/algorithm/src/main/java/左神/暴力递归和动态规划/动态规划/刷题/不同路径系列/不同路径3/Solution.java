package 左神.暴力递归和动态规划.动态规划.刷题.不同路径系列.不同路径3;

public class Solution {
    public int uniquePathsIII(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int startI = 0, startJ = 0, endI = 0, endJ = 0, count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    startI = i;
                    startJ = j;
                }
                if(grid[i][j] == 2){
                    endI = i;
                    endJ = j;
                }
                if(grid[i][j] != -1)
                    count++;
            }
        }
//        System.out.println(startI + " " + startJ + " " + endI + " " + endJ + " " + count);
        return help(grid,flag,startI,startJ,endI,endJ,count);
    }
    public int help(int[][] arr, boolean[][] flag,int i, int j, int endI, int endJ,int count){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || flag[i][j] || arr[i][j] == -1)
            return 0;
        if(i == endI && j == endJ)
            {
                if(count == 1)
                    return 1;
                return 0;
            }
        int res = 0;
        flag[i][j] = true;
        res += help(arr,flag,i + 1,j,endI,endJ,count - 1);
        res += help(arr,flag,i - 1,j,endI,endJ,count - 1);
        res += help(arr,flag,i ,j + 1,endI,endJ,count - 1);
        res += help(arr,flag,i,j - 1,endI,endJ,count - 1);
        flag[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsIII(arr));
    }
}
