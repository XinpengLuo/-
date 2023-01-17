package 主要练习.位运算.整数转换;

public class Solution {
    public int convertInteger(int A, int B) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((A & (1 << i)) ^ (B & (1 << i))) != 0)
                count++;
        }
        return count;
    }
}
