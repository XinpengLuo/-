package 周赛.第十六次周赛.第一题;

import 左神.树专题.视频.消息体处理.求二叉树的最大值和最小值.MaxAndMinValue;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        StringBuilder newKey = new StringBuilder();
        for (int i = 0; i < key.length() && set.size() < 26; i++) {
            char c = key.charAt(i);
            if(c != ' ' && set.add(c)){
                newKey.append(c);
            }
        }
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < newKey.length(); i++) {
            int index = newKey.charAt(i) - 'a';
            char target = (char)(i + 'a');
            map.put(newKey.charAt(i),target);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' ')
                res.append(' ');
            else
            {
                char c = message.charAt(i);
                res.append(map.get(c));
            }

        }
        return res.toString();
    }
public static void main(String[] args) {
    String key = "the quick brown fox jumps over the lazy dog";
    String message = "vkbs bs t suepuv";
    Solution solution = new Solution();
    System.out.println(solution.decodeMessage(key, message));
    System.out.println((char)(1 + 'a'));
}
}
