package 主要练习.字符串.最短补全词;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = getCount(licensePlate);
        int ansIndex = -1;
        int ansLength = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            int[] tempCount = getCount(words[i]);
            boolean flag = true;
            for(int j = 0; j < tempCount.length; j++)
                if(tempCount[j] < count[j])
                {
                    flag = false;
                    break;
                }
            if(flag && ansLength > words[i].length()){
                ansLength = words[i].length();
                ansIndex = i;
            }
        }
        return words[ansIndex];
    }
    public int[] getCount(String word){
        int[] count = new int[26];
        for(int i = 0; i < word.length(); i++){
            char temp = word.charAt(i);
            if(Character.isLetter(temp)){
                temp = Character.toLowerCase(temp);
                count[temp - 'a']++;
            }
        }
        return count;
    }
}
