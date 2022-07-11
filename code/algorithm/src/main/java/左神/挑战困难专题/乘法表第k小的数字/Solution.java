package 左神.挑战困难专题.乘法表第k小的数字;

public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int right = m * n, left = 1;
        int res = -1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            int count = 0;
            for(int i = 1; i <= m; i++)
                count += Math.min(middle / i, n);
            if(count >= k)
            {
                res = middle;
                right = middle - 1;
            }
            else
                left = middle + 1;
        }
        return res;
    }
}
