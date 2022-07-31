package 左神.位运算.两个回文子序列长度的最大乘积;

public class Solution {
    int ans = 0;
    public int maxProduct(String s) {
        dfs(s,new StringBuilder(),new StringBuilder(),0);
        return ans;
    }
    public void dfs(String s, StringBuilder first, StringBuilder second, int index){
        if(index == s.length()){
            if(check(first) && check(second)) {
                ans = Math.max(ans, first.length() * second.length());
            }
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
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public int maxProduct(String s, int stateA, int stateB, int index, int lenA, int lenB) {
        if(index == s.length()){
            return lenA * lenB;
        }
        int res = 0;
        int charIndex = s.charAt(index) - 'a';
        res = Math.max(maxProduct(s,stateA,stateB,index + 1,lenA,lenB),res);
        //如果a添加
        boolean flag = false;
        if(((stateA >> charIndex) & 1) == 1) {
            flag = true;
        }else{
            stateA = stateA | (1 << charIndex);
        }
        if(checkByBinary(stateA,stateB)){
            res = Math.max(maxProduct(s,stateA,stateB,index + 1,lenA + 1,lenB),res);
        }
        if(!flag){
            stateA = stateA ^ (1 << charIndex);
        }
        //如果是B添加
        flag = false;
        if(((stateB >> charIndex) & 1) == 1) {
            flag = true;
        }else{
            stateB = stateB | (1 << charIndex);
        }
        if(checkByBinary(stateA,stateB)){
            res = Math.max(maxProduct(s,stateA,stateB,index + 1,lenA,lenB + 1),res);
        }
        if(!flag){
            stateB = stateB ^ (1 << charIndex);
        }
        return res;
    }

    public boolean checkByBinary(int stateA, int stateB){
        for(int i = 0; i < 32; i++){
            if((stateA >> i) == 1 && (stateB >> i) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
