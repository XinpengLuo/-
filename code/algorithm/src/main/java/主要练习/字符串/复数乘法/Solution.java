package 主要练习.字符串.复数乘法;

public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] s1 = num1.split("\\+");
        String[] s2 = num2.split("\\+");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1].substring(0,s1[1].length() - 1));
        int c = Integer.parseInt(s2[0]);
        int d = Integer.parseInt(s2[1].substring(0,s2[1].length() - 1));
        return (a * c - b * d) + "+" + (a * d + b * c) + "i";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.complexNumberMultiply("ss+s","ss");
    }
}
