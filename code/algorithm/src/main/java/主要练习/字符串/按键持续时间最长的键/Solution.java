package 主要练习.字符串.按键持续时间最长的键;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for(int i = 1; i < keysPressed.length(); i++){
            char temp = keysPressed.charAt(i);
            int count = releaseTimes[i] - releaseTimes[i - 1];
            if(count > max || (count == max && temp > ans)){
                ans = temp;
                max = count;
            }
        }
        return ans;
    }
}
