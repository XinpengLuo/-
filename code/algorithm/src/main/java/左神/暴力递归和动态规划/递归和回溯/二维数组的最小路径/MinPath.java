package 左神.暴力递归和动态规划.递归和回溯.二维数组的最小路径;

import java.util.ArrayList;

public class MinPath {
    //这种方法是列出所有路径 然后比较出所有路径的大小
    public static void countPath(ArrayList<Integer> result,int[][] m, int i, int j,int temp){
        if(i == m.length - 1 && j == m[0].length - 1)
            {
                result.add(temp + m[i][j]);
                return;
            }
        if(i + 1 < m.length)
            countPath(result,m,i + 1,j,temp + m[i][j]);
        if(j + 1 < m[0].length)
            countPath(result,m,i,j + 1,temp + m[i][j]);
    }
    //这种方法是真的求最小路径
    public static int countMinPath(int[][] m,int i, int j){
        if(i == m.length - 1 && j == m[0].length - 1)
            return m[i][j];
        //如果已经到了最后一行 那么一直向右走即可
        if(i == m.length - 1)
            return m[i][j] + countMinPath(m,i,j + 1);
        if(j == m[0].length - 1)
            return m[i][j] + countMinPath(m,i + 1,j);
        //如果一个点既可以向右走 也可以 向下走 那么比较两者的大小
        int right = m[i][j] + countMinPath(m,i,j + 1);
        int down = m[i][j] + countMinPath(m,i + 1,j);
        return Math.min(right,down);
    }
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>();
        int[][] test = {{3,2,1,0},{7,5,0,1},{3,7,6,2}};
        countPath(result,test,0,0,0);
        int min = Integer.MAX_VALUE;
        for (Integer integer : result) {
            System.out.println(integer);
            min = min < integer ? min : integer;
        }
        System.out.println(min);
        //
        System.out.println("另一种方法");
        System.out.println(countMinPath(test, 0, 0));
    }
}
