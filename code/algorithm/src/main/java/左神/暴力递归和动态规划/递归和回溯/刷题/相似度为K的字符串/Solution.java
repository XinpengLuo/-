package 左神.暴力递归和动态规划.递归和回溯.刷题.相似度为K的字符串;

public class Solution {
    int res = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
         dfs(s1.toCharArray(),s2.toCharArray(),0,0);
         return res;
    }
    public void dfs(char[] s1, char[] s2, int index, int temp){
        if(temp >= res)
            return;
        int i = index;
        for(; i < s1.length; i++){
            if(s1[i] == s2[i])
                continue;
            for(int j = i + 1; j < s2.length; j++){
                if(s2[j] != s1[i])
                    continue;
                swap(s2,j,i);
                dfs(s1,s2,i  + 1,temp + 1);
                swap(s2,i,j);
            }
        }
        if(i == s1.length && String.valueOf(s1).equals(String.valueOf(s2)))
            res = Math.min(res,temp);
    }
    public void swap(char[] arr, int i, int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kSimilarity("abc", "bca"));
    }
}
