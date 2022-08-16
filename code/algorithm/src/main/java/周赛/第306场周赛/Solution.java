package 周赛.第306场周赛;

import java.util.*;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - 2][n - 2];
        for(int i = 0; i < res.length; i++)
            for(int j = 0; j < res[i].length; j++){
                int max = 0;
                for(int a = i; a <= i + 2; a++)
                    for(int b = j; b <= j + 2; b++)
                        max = Math.max(grid[a][b],max);
                res[i][j] = max;
            }
        return res;
    }
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        boolean flag = pattern.charAt(0) == 'I';
        for(int i = 1; i <= 9; i++) {
            set.add(i);
            sb.append(i);
            if (dfs(set, pattern, 1, flag, sb))
                break;
            sb.deleteCharAt(sb.length() - 1);
            set.remove(i);
        }
        return sb.toString();
    }
    //pre --> 前一个是I  !pre --> 前一个是D
    public boolean dfs(HashSet<Integer> set, String pattern, int index, boolean pre, StringBuilder sb){
        if(index > pattern.length())
            return true;
        boolean newPre = index != pattern.length() && pattern.charAt(index) == 'I';
        int num = sb.charAt(sb.length() - 1) - '0';
        if(pre){
            for(int i = num + 1; i <= 9; i++){
                if(!set.contains(i)){
                    set.add(i);
                    sb.append(i);
                    if(dfs(set,pattern,index + 1,newPre,sb))
                        return true;
                    set.remove(i);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        else{
            for(int i = 1; i < num; i++){
                if(!set.contains(i)){
                    set.add(i);
                    sb.append(i);
                    if(dfs(set,pattern,index + 1,newPre,sb))
                        return true;
                    set.remove(i);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return false;
    }

    public int countSpecialNumbers(int n) {
        if(n >= Math.pow(10,10))
            n = (int) (Math.pow(10,10) - 1);
        int len = String.valueOf(n).length();
        int sum = 10;
        int add = 9;
        int i;
        for (i = 1; i < len - 1; i++) {
            sum += add * (10 - i);
            add *= (10 - i);
        }
        sum--;
        String s = String.valueOf(n);

        return sum;
    }

    public static void main(String[] args) {
        Object object = new Object();
        synchronized (object){
            System.out.println(object.hashCode());
        }
    }
}
