package 左神.字符串.最长特殊序列2;

public class Solution {
    public int findLUSlength(String[] strs) {
        int ans = 0;
        for(int i = 0; i < strs.length; i++){
            boolean flag = true;
            for(int j = 0; j < strs.length; j++){
                if(i != j){
                    //一个字符串如果它的子序列 是它独有的 那么这个字符串本身就是独有的子序列
                    if(isSubString(strs[i],strs[j])){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                ans = Math.max(ans, strs[i].length());
        }
        return ans;
    }

    private boolean isSubString(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()){
            char a = str1.charAt(i);
            char b = str2.charAt(j);
            if(a == b)
                i++;
            j++;
        }
        return i == str1.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "ab";
        String str2 = "acc";
        System.out.println(solution.isSubString(str1,str2));
    }
}
