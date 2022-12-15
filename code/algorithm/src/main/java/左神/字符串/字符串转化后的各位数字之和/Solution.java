package 左神.字符串.字符串转化后的各位数字之和;

public class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i) - 'a' + 1);
        }
        while (k-- > 0){
            int sum = 0;
            for(int i = 0; i < sb.length(); i++)
                sum += sb.charAt(i) - '0';
            sb.delete(0,sb.length());
            sb.append(String.valueOf(sum));
        }
        return Integer.parseInt(sb.toString());
    }
}
