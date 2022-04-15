package 左神.字符串.银行中的激光束数量;

public class Solution {
    public int numberOfBeams(String[] bank) {
        int pre = 0;
        int count = 0;
        for (String s : bank) {
            int tempCount = 0;
            for(int i = 0; i < s.length(); i++)
                if(s.charAt(i) == '1')
                    tempCount++;
                count += (tempCount * pre);
                if(tempCount != 0)
                    pre = tempCount;
        }
        return count;
    }
}
