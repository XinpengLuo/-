package 左神.二分总结.蜡烛之间的盘子;

public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] count = new int[s.length()];
        int temp = 0;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == '*')
                count[i] = ++temp;
        int[] left = new int[s.length()];
        int tempLeft = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|')
                tempLeft = i;
            left[i] = tempLeft;
        }
        int[] right = new int[s.length()];
        int tempRight = -1;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '|')
                tempRight = i;
            right[i] = tempRight;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = right[queries[i][0]];
            int y = left[queries[i][1]];
            if(x == -1 || y == -1 || x >= y)
                ans[i] = 0;
            else
                ans[i] = count[y] - count[x];
        }
        return ans;
    }
}
