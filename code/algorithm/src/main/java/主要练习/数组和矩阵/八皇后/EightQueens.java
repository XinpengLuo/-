package 主要练习.数组和矩阵.八皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class EightQueens {

     List<List<String>> result = new ArrayList<>();
     int count = 0;
    public  void solveQueens(int n){
        if(n <= 0)
            return;
        int[][] map = new int[n][n];
        //存放一个解法的表示
        List<String> list = new ArrayList<>();
        solveQueensHelp(map,0,list);
    }
    public  void solveQueensHelp(int[][] map,int i,List<String> list){ //n代表n * n 的棋盘 i代表目前第几行
        String temp = "";
        char[] row = new char[map.length];
        Arrays.fill(row,'.');
        for (int j = 0; j < map[0].length; j++) {
            map[i][j] = 1;
            row[j] = 'Q';
            if(isValid(map,i,j)){
                list.add(new String(row));
                if(i == map.length - 1)
                    {
                        //show(map);
                        count++;
                        result.add(new ArrayList<>(list));
                    }
                if(i + 1 < map.length)
                    solveQueensHelp(map,i + 1,list);
                list.remove(list.size() - 1);
            }
            row[j] = '.';
            map[i][j] = 0;
        }
    }
    public  boolean isValid(int[][] map,int i, int j){
        //检查列
        for(int k = 0; k < i; k++){
            if(map[k][j] == 1)
                return false;
        }
        //检查45度角
        for(int k = i - 1, m = j - 1; k >= 0 && m >=0; k--,m--){
            if(map[k][m] == 1)
                return false;
        }
        //检查135度角
        for(int k = i - 1, m = j + 1; k >= 0 && m < map[0].length; k--,m++){
            if(map[k][m] == 1)
                return false;
        }
        return true;
    }
    public static void show(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("--------------");
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.solveQueens(4);
        System.out.println(eightQueens.result);
    }
}
