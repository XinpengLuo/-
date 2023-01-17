package 主要练习.数组和矩阵.刷题.合并排序数组;

public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, tail = m + n - 1;
        while (i >= 0 || j >= 0){
            int cur = 0;
            if(i == -1)
                cur = B[j--];
            else if(j == -1)
                cur = A[i--];
            else if(A[i] > B[j])
                cur = A[i--];
            else
                cur = B[j--];
            A[tail--] = cur;
        }
    }
}
