package 周赛.第十次周赛.第三题;

import javafx.scene.web.WebHistory;

import java.util.TreeMap;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i = 0; i < cnt.length; i++)
            if(cnt[i] != 0)
                map.put((char)('a' + i), cnt[i]);
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        char temp = map.lastKey();
        int time = map.get(temp);
        while (true){
            int count = 0;
            for(int i = 0; i < (flag ? Math.min(time,repeatLimit) : 1); i++)
                {
                    res.append(temp);
                    count++;
                }
            map.remove(temp);
            if(map.isEmpty())
                break;
            char newTemp = map.lastKey();
            int newTime = map.get(newTemp);
            if(time > count)
                {
                    map.put(temp,time - count);
                    if(newTemp > temp)
                        flag = true;
                    else
                        flag = false;
                }
            else
                flag = true;
            temp = newTemp;
            time = newTime;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "robnsdvpuxbapuqgopqvxdrchivlifeepy";
        System.out.println(solution.repeatLimitedString(str, 2));
    }
}
