package 左神.字符串.二进制求和;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int z = x + y + add;
            sb.append((char)z % 2);
            add = z / 2;
        }
        if(add != 0)
            sb.append(add);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "11";
        String b = "1";
        System.out.println(solution.addBinary(a, b));
    }
}
