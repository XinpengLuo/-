package 主要练习.字符串.删除字符串两端相同字符后的最短长度;

public class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j){
            int tempA = s.charAt(i), tempB = s.charAt(j);
            if(tempA != tempB)
                break;
            i++;
            j--;
            while (s.charAt(i) == tempA && i < j)
                i = i + 1;
            while (s.charAt(j) == tempB && i - 1 < j)
                j = j - 1;
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
