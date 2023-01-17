package 主要练习.暴力递归和动态规划.递归和回溯.刷题.字典序排数;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1; i <= 9; i++)
            help(i,n);
        return res;
    }
    public void help(int temp, int n){
        if(temp > n)
            return;
        res.add(temp);
        temp = temp * 10;
        for(int i = 0; i <= 9; i++)
            help(temp + i,n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lexicalOrder(100);
        for (Integer i : solution.res) {
            System.out.print(i + " ");
        }
    }
}
