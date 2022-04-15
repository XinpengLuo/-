package 左神中级班.第四节.螺旋打印矩阵系列;

import java.util.ArrayList;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];
        int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (tR <= dR && tC <= dC)
            help(arrayList,matrix,tR++,tC++,dR--,dC--);
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
    public void help(ArrayList<Integer> result, int[][] matrix, int tR, int tC, int dR, int dC){
       if(tR == dR){
            for(int i = tC; i <= dC; i++)
                result.add(matrix[tR][i]);
        }
        else if(tC == dC){
            for(int i = tR; i <= dR; i++)
                result.add(matrix[i][tC]);
        }
        else{
            for(int i = tC; i <= dC; i++)
                result.add(matrix[tR][i]);
            for(int i = tR + 1; i <= dR; i++)
                result.add(matrix[i][dC]);
            for(int i = dC - 1; i >= tC; i--)
                result.add(matrix[dR][i]);
            for(int i = dR - 1; i > tR; i--)
                result.add(matrix[i][tC]);
        }
    }
    //给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    public int[][] generateMatrix(int n) {
        if(n <= 0)
            return new int[0][0];
        int[][] res = new int[n][n];
        int num = 1;
        int tR = 0, tC = 0, dR = res.length - 1, dC = res[0].length - 1;
        while (tR <= dR && tC <= dC)
            num = helpTwo(res,tR++,tC++,dR--,dC--,num);
        return res;
    }
    public int helpTwo( int[][] res, int tR, int tC, int dR, int dC, int num){
        if(tR == dR){
            for(int i = tC; i <= dC; i++)
                res[tR][i] = num++;
        }
        else if(tC == dC){
            for(int i = tR; i <= dR; i++)
                res[i][tC] = num++;
        }
        else{
            for(int i = tC; i <= dC; i++)
                res[tR][i] = num++;
            for(int i = tR + 1; i <= dR; i++)
                res[i][dC] = num++;
            for(int i = dC - 1; i >= tC; i--)
                res[dR][i] = num++;
            for(int i = dR - 1; i > tR; i--)
                res[i][tC] = num++;
        }
        return num;
    }
    public static void main(String[] args) {

    }
}
