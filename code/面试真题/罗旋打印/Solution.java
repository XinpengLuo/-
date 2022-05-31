package 面试真题.罗旋打印;

import java.util.*;

public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length, bottom = matrix.length, top = 0;
        int n = matrix.length * matrix[0].length;
        while(res.size() != n){
            for(int i = left; i < right; i++)
                res.add(matrix[top][i]);
            if(res.size() == n)
                break;
            for(int i = top + 1; i < bottom; i++)
                res.add(matrix[i][right - 1]);
            if(res.size() == n)
                break;
            for(int i = right - 2; i >= left; i--)
                res.add(matrix[bottom - 1][i]);
            if(res.size() == n)
                break;
            for(int i = bottom - 2; i > top; i--)
                res.add(matrix[i][left]);
            if(res.size() == n)
                break;
            left++;
            right--;
            top++;
            bottom--;

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(arr);
    }
}
