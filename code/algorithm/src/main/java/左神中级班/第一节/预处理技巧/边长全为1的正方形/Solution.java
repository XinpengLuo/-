package 左神中级班.第一节.预处理技巧.边长全为1的正方形;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Solution {
    public int getAllOneSquare(int[][] map){
        int m = map.length;
        int n = map[0].length;
        int[][] right = new int[m][n]; //每一个元素它到它的最右侧有几个1
        int[][] down = new int[m][n]; //每一个元素它到它的最下侧有几个1
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] != 1)
                    continue;
                int count = 0;
                for(int k = j; k < map[i].length; k++)
                    {
                        if(map[i][k] == 1)
                        count++;
                        else break;
                    }
                right[i][j] = count;
            }
        }
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                if(map[j][i] != 1)
                    continue;
                int count = 0;
                for(int k = j; k < m; k++){
                    if(map[k][i] == 1)
                        count++;
                    else break;
                }
                down[j][i] = count;
            }
        for (int[] ints : right) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        for (int[] ints : down) {
            System.out.println(Arrays.toString(ints));
        }
        int maxPath = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                for(int border = 0; i + border < m && j + border < n; border++)
                    if(right[i][j] >= border + 1 && down[i][j] >= border + 1 && right[i + border][j] >= border + 1 && down[i][j + border] >= border + 1)
                        maxPath = Math.max(maxPath,border + 1);
            }
        return maxPath;
    }

    public static void main(String[] args) {
        int[][] map = {{1,1,1},{1,1,0},{1,1,1},{0,1,1},{1,1,1}};
        Solution solution = new Solution();
        System.out.println(solution.getAllOneSquare(map));
    }
}
