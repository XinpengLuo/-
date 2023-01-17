package 主要练习.其他专题.有效的平方数;

public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        int left = 1;
        int right = num / 2;
        while (left <= right){
            int mid = (left + right) / 2;
            System.out.println(mid);
            long temp =(long) mid * mid;
            if(temp == num)
                return true;
            else if(temp < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(1000000));
        System.out.println(Math.sqrt(808201));
    }
}
