package 主要练习.位运算.翻转数位;

public class Solution {
    public int reverseBits(int num) {
        int res = 0;
        int j = 0;
        int countZero = 0;
        for(int i = 0; i < 32; i++){
            int temp = num & (1 << i);
            if(temp == 0)
                countZero++;
            while (countZero == 2){
                if((num & (1 << j)) == 0)
                    countZero--;
                j++;
            }
            res = Math.max(i - j + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(1775));
    }
}
