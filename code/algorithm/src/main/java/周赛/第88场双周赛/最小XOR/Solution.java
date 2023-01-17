package 周赛.第88场双周赛.最小XOR;

public class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = 0;
        for(int i = 0; i < 32; i++)
            if(((num2 >> i) & 1) == 1)
                count++;
        int state = 0;
        for(int i = 31; i >= 0 && count > 0; i--)
            if(((num1 >> i) & 1) != 1)
                continue;
            else{
                state |= (1 << i);
                count--;
            }
        for(int i = 0; i <= 31 && count != 0; i++)
            if(((state >> i) & 1) == 0)
            {
                state |= (1 << i);
                count--;
            }

        return state;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeXor(1, 12));
    }
}
