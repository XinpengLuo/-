package 左神.位运算.或运算的最小翻转次数;

public class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            int target = (c & (1 << i)) != 0 ? 1 : 0;
            int x = (a & (1 << i)) != 0 ? 1 : 0;
            int y = (b & (1 << i)) != 0 ? 1 : 0;
            if((x | y) == target)
                continue;
            if(target == 1)
                count++;
            else if(target == 0)
            {
                count += x == 0 ? 0 : 1;
                count += y == 0 ? 0 : 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlips(2, 6, 5));
    }
}
