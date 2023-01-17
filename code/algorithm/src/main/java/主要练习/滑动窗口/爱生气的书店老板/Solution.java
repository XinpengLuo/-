package 主要练习.滑动窗口.爱生气的书店老板;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] != 1)
               { ans += customers[i];
                 customers[i] = 0;
               }
        }
        int windowsAns = 0;
        int sum = 0;
        for(int i = 0; i < customers.length; i++){
            sum += customers[i];
            if(i >= minutes - 1){
                windowsAns = Math.max(windowsAns,sum);
                sum -= customers[i - minutes + 1];
            }
        }
        return ans + windowsAns;
    }
}
