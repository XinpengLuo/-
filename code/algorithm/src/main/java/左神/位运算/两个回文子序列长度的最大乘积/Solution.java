package 左神.位运算.两个回文子序列长度的最大乘积;

public class Solution {
    int ans = 0;
    public int maxProduct(String s) {
        dfs(s,new StringBuilder(),new StringBuilder(),0);
        return ans;
    }
    public void dfs(String s, StringBuilder first, StringBuilder second, int index){
        if(index == s.length()){
            if(check(first) && check(second))
                ans = Math.max(ans, first.length() * second.length());
            return;
        }
        dfs(s,first,second,index + 1);
        dfs(s,first.append(s.charAt(index)),second, index + 1);
        first.deleteCharAt(first.length() - 1);
        dfs(s,first,second.append(s.charAt(index)),index + 1);
        second.deleteCharAt(second.length() - 1);
    }
    public boolean check(StringBuilder s){
        int i = 0, j = s.length() - 1;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer a = 101;
        System.out.println(Integer.bitCount(a));
//        Solution solution = new Solution();
//        String s = "leetcodecom";
//        solution.maxProduct(s);
//        System.out.println(solution.ans);
    }
}
