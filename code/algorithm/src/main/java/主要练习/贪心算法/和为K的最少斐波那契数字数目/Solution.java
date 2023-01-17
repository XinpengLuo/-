package 主要练习.贪心算法.和为K的最少斐波那契数字数目;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> temp = new ArrayList<>();
        int a = 1, b = 1;
        temp.add(a);
        while (b <= k){
            temp.add(b);
            int c = b;
            b = a + b;
            a = c;
        }
        int count = 0;
        int i = temp.size() - 1;
        while (k != 0){
            if(temp.get(i) <= k){
                k -= temp.get(i);
                count++;
            }
            i--;
        }
        return count;
    }
    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int max = 0;
        for(int i = 0; i < rectangles.length; i++){
            int temp = Math.min(rectangles[i][0],rectangles[i][1]);
            if(temp == max)
                count++;
            else if(temp > max){
                max = temp;
                count = 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMinFibonacciNumbers(7);
    }
}
