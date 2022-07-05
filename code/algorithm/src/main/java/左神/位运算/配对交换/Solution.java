package 左神.位运算.配对交换;

public class Solution {
    public int exchangeBits(int num) {
        int res = 0;
        int index = 0;
        while(index <= 31){
            int a = (num & (1 << index)) != 0 ? 1 : 0;
            int b = (num & (1 << (index + 1))) != 0 ? 1 : 0;
            res += (b << index);
            res += (a << (index + 1));
            index += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exchangeBits(2));
    }
}
