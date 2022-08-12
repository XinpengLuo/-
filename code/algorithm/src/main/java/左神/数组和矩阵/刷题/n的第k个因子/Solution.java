package 左神.数组和矩阵.刷题.n的第k个因子;

import java.util.*;

public class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                k--;
                if(k == 0)
                    return i;
                if(n / i != i)
                    temp.add(i);
            }
        }
        return temp.size() >= k ? n / temp.get(temp.size() - k) : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthFactor(4, 4));
    }
}
