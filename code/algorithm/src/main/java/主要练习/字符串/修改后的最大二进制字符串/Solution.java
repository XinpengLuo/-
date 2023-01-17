package 主要练习.字符串.修改后的最大二进制字符串;

public class Solution {
    public String maximumBinaryString(String binary) {
        int start = -1;
        int count = 0;
        for(int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0' && start == -1) {
                start = i;
            }
            if(start != -1 && binary.charAt(i) == '1')
                count++;
        }
        if(start == -1 || count == 0)
            return binary;
        int target = binary.length() - count - 1;
        char[] res = new char[binary.length()];
        for(int i = 0; i < res.length; i++)
            if(i != target)
                res[i] = '1';
            else
                res[i] = '0';
        return new String(res);
    }
}
