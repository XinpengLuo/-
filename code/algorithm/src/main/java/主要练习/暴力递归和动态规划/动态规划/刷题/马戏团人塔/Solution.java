package 主要练习.暴力递归和动态规划.动态规划.刷题.马戏团人塔;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] person = new int[height.length][weight.length];
        for(int i = 0; i < height.length; i++){
            person[i][0] = height[i];
            person[i][1] = weight[i];
        }
        Arrays.sort(person, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        return newDp(person);
    }
    public int help(int[][] person, int index, int preIndex){
        if(index == person.length)
            return 0;
        if(preIndex != person.length){
            int res = help(person, index + 1,preIndex);
            if(person[index][0] > person[preIndex][0] && person[index][1] > person[preIndex][1])
                res = Math.max(res,1 + help(person,index + 1,index));
            return res;
        }
        return Math.max(help(person,index + 1,preIndex), 1 + help(person,index + 1,index));
    }
    public int dp(int[][] person){
        int[][] dp = new int[person.length + 1][person.length + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j <= person.length; j++){
                if(j != person.length){
                    int res = dp[i + 1][j];
                    if(person[i][0] > person[j][0] && person[i][1] > person[j][1])
                        res = Math.max(res,1 + dp[i + 1][i]);
                    dp[i][j] = res;
                }
                else
                    dp[i][j] = Math.max(1 + dp[i + 1][i],dp[i + 1][j]);
            }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();

        return dp[0][person.length];
    }
    public int newDp(int[][] person){

        int[] dp = new int[person.length + 1];
        for(int i = 0; i < dp.length - 1; i++)
            if(person[person.length - 1][0] > person[i][0] && person[person.length - 1][1] > person[i][1])
                dp[i] = 1;
        dp[dp.length - 1] = 1;

        for(int i = person.length - 2; i >= 0; i--)
            {
                int[] tempDp = new int[person.length + 1];
                for(int j = 0; j <= person.length; j++){
                    if(j != person.length){
                        int res = dp[j];
                        if(person[i][0] > person[j][0] && person[i][1] > person[j][1])
                            res = Math.max(res,1 + dp[i]);
                        tempDp[j] = res;
                    }
                    else
                        tempDp[j] = Math.max(1 + dp[i],dp[j]);
                }
                dp = tempDp;
            }
        return dp[person.length];
    }
    //2021年10月2日 新思想
    public int testDp(int[] height, int[] weight){
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i)
            person[i] = new int[]{height[i], weight[i]};
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 1;
        int[] dp = new int[person.length];
        dp[0] = 1;
        for(int i = 1; i < person.length; i++){
            int temp = 1;
            for(int j = 0; j < i; j++){
                if(person[i][1] > person[j][1])
                    temp = Math.max(temp,1 + dp[j]);
            }
            dp[i] = temp;
            res = Math.max(dp[i],res);
        }
        return res;
    }
    public String test(int num){
        if(num == 0)
            return "0";
        long res = num;
        if(num < 0)
            res = (long) (Math.pow(2, 32) + num);
        System.out.println(res);
        char s[] = "0123456789abcdef".toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        while(res > 0){
            stringBuffer.append(s[(int) (res % 16)]);
            res = res / 16;
        }
        return stringBuffer.reverse().toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.test(-1));
    }
}
