package 左神.字符串.构成交替字符串需要的最小交换次数;

public class Solution {
    public int minSwaps(String s) {
        int countZero = 0;
        int countOne = 0;
        int countDiff = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0')
                countZero++;
            else
                countOne++;
        }
        if(Math.abs(countOne - countZero) >= 2)
            return -1;
        int res = Integer.MAX_VALUE;
        if(countOne != countZero)
        {
           char target = ' ';
           if(countOne > countZero)
            target = '1';
           else if(countOne < countZero)
            target = '0';
           for (int i = 0; i < s.length(); i++) {
               char c = s.charAt(i);
               if(c != target)
                   countDiff++;
               if(target == '1')
                   target = '0';
               else
                   target = '1';
           }
           res =  (countDiff + 2 - 1) / 2;
        }
        else{
            for(int j = 0; j < 2; j++){
                char target = (char) (j + 48);
                countDiff = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if(c != target)
                        countDiff++;
                    if(target == '1')
                        target = '0';
                    else
                        target = '1';
                }
                res = Math.min ((countDiff + 2 - 1) / 2, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "111000";
        System.out.println(solution.minSwaps(s));
    }
}
