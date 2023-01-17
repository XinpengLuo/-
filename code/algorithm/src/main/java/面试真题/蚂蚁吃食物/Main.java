package 面试真题.蚂蚁吃食物;

import java.util.*;

public class Main {
    public int better(int[][] points){
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int x = 0, y = 0;
        int res = 0;
        for (int[] point : points) {
            res += Math.abs(x - point[0]) + Math.abs(y - point[1]);
            x = point[0];
            y = point[1];
        }
        return res;
    }
    int max = Integer.MAX_VALUE;
    HashSet<String> set = new HashSet<>();
    public int getMinLen (int[][] points) {

        // write code here
     Arrays.sort(points, new Comparator<int[]>() {
         @Override
         public int compare(int[] t1, int[] t2) {
             return t1[1] * t1[1] + t1[0] * t1[0] - t2[0] * t2[0] - t2[1] * t1[1];
         }
     });
     int res = 0, x = 0, y = 0;
     for(int i = 0; i < points.length; i++){
         res += Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
         x = points[i][0];
         y = points[i][1];
     }
     return res;
    }
    public void dfs(int i, int j, boolean[][] flag, int sum, int count){
        if(i < 0 || i >= 100 || j < 0 || j >= 100 || flag[i][j])
            return;
        if(count == 0)
        {
           max = Math.min(max,sum);
           return;
        }
        flag[i][j] = true;
        String key = i + " " + j;
        int carry = set.contains(key) ? -1 : 0;
        System.out.println(key);
        dfs(i + 1,j,flag,sum + 1,count + carry);
        dfs(i - 1,j,flag,sum + 1,count + carry);
        dfs(i,j + 1,flag,sum + 1,count + carry);
        dfs(i,j - 1,flag,sum + 1,count + carry);
        flag[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{0,3}};
        Main main = new Main();
        System.out.println(main.getMinLen(arr));
    }
}
