package 左神.暴力递归和动态规划.递归和回溯.刷题.顺次数;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Solution {
    //暴力枚举法
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = low; i <= high; i++){
            int number = i;
            int pre = number % 10;
            number = number / 10;
            while (number != 0){
                if(number % 10 != pre - 1)
                    break;
                pre = number % 10;
                number = number / 10;
            }
            if(number == 0)
                res.add(i);
        }
        return res;
    }
    //自己构造法
    public List<Integer> sequentialDigitsTwo(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            int num = i;
            for(int j = i + 1; j <= 9;j++){
                num = num * 10 + j;
                if(num >= low && num <= high)
                    res.add(num);
                if(num > high)
                    break;
            }
        }
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sequentialDigits(10, 1000000000));
    }
}
