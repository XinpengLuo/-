package 左神.滑动窗口.替换后的最长重复字符;

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int j = 0;
        int maxIndex = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'A';
            count[index]++;
            if(count[index] > count[maxIndex])
                maxIndex = index;
            if(count[maxIndex] + k >= (i - j + 1))
                res = Math.max(res,i - j + 1);
            else{
                count[s.charAt(j) - 'A']--;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "AABBCDFFFFFFF";
        solution.characterReplacement(test,3);
    }
}
