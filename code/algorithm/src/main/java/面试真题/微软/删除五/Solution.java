package 面试真题.微软.删除五;

public class Solution {
    public int solution(int N) {
        // write your code in Java 8 (Java SE 8)
        String s = String.valueOf(N);
        long res = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '5'){
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                res = Math.max(res, Long.parseLong(sb.toString()));
            }
        }
        return (int) res;
    }
public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(15958));
    System.out.println(solution.solution(-5859));
    System.out.println(solution.solution(-999));
}
}
