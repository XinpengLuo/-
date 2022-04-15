package 左神.字符串.打开转盘锁;

public class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))
            return 0;
        for (String deadend : deadends) {
            if(deadend.equals(target))
                return -1;
        }
        char[] temp = {'0','0','0','0'};
        return help(deadends,target,0,temp);
    }
    public int help(String[] deadends, String target, int time, char[] temp){
        if(time == 4){
            if(String.valueOf(temp).equals(target))
                return 0;
            return 1000;
            }
        int res = 1000;
        for(int i = 0; i <= 9; i++){
            char cur = temp[time];
            temp[time] = (char) (i + '0');
            if(isValid(deadends,temp))
                res = Math.min(res,i + help(deadends,target,time + 1,temp));
            temp[time] = cur;
        }
        for(int i = 9; i > 0; i--){
            char cur = temp[time];
            temp[time] = (char) (i + '0');
            if(isValid(deadends,temp))
                res = Math.min(res,9 - i + 1 + help(deadends,target,time + 1,temp));
            temp[time] = cur;
        }
        return res;
    }
    public boolean isValid(String[] deadends, char[] temp){
        for (String deadend : deadends) {
            if(deadend.equals(String.valueOf(temp)))
                {
                    System.out.println(String.valueOf(temp));
                    return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] dead = {"0201","0101","0102","1212","2002"};
        String target =  "0202";
        System.out.println(solution.openLock(dead, target));
    }
}
