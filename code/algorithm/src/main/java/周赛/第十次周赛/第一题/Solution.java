package 周赛.第十次周赛.第一题;

public class Solution {
    public int countEven(int num) {
        int res = 0;
        for(int i = 1; i <= num; i++){
            int sum = 0;
            int temp = i;
            while (temp != 0){
                sum += (temp % 10);
                temp /= 10;
            }
            if(sum % 2 == 0)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countEven(30));
    }
}
