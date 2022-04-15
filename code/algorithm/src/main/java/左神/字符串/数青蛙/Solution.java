package 左神.字符串.数青蛙;

public class Solution {
    //返回叫声中最少有多少只青蛙在叫
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0,r = 0, o = 0, a = 0, k = 0;
        int num = 0;
        int res = 0;
        char[] chars = croakOfFrogs.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(croakOfFrogs.charAt(i) == 'c'){
                c++;
                num++;
                res = Math.max(res,num);
            }
            if(croakOfFrogs.charAt(i) == 'r')
                r++;
            if(croakOfFrogs.charAt(i) == 'o')
                o++;
            if(croakOfFrogs.charAt(i) == 'a')
                a++;
            if(croakOfFrogs.charAt(i) == 'k'){
                k++;
                num--;
            }
            if(!(c >= r && r >= o && o >= a && a >= k))
                return -1;
        }
        return num == 0 ? res : -1;
    }
}
