package 主要练习.字符串.旋转字符串;

public class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        if((s + s).contains(goal))
            return true;
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

}
}
