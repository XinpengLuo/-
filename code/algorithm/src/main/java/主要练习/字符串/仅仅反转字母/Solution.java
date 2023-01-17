package 主要练习.字符串.仅仅反转字母;

public class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j){
            while (i < j && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')))
                {
                    chars[i] = s.charAt(i);
                    i++;
                }
            while (i < j && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')))
            {
                chars[j] = s.charAt(j);
                j--;
            }
            char temp = s.charAt(i);
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c: chars) {
            sb.append(c);
        }
        return sb.toString();
    }
    public String better(String s){
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j){
            while (i < j && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')))
            {
                chars[i] = s.charAt(i);
                i++;
            }
            while (i < j && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')))
            {
                chars[j] = s.charAt(j);
                j--;
            }
            char temp = s.charAt(i);
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "7_28]";
        System.out.println(solution.reverseOnlyLetters(str));
        System.out.println(solution.better(str));

    }
}
