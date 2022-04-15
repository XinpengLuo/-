package 左神.滑动窗口.定长子串中元音的最大数目;

public class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int count = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(isVowel(temp))
                count++;
            if(i >= k - 1){
                ans = Math.max(ans,count);
                if(isVowel(s.charAt(j)))
                    count--;
                j++;
            }
        }
        return ans;
    }
    public boolean isVowel(char temp){
        if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abciiidef";
        System.out.println(solution.maxVowels(str, 3));
    }
}
