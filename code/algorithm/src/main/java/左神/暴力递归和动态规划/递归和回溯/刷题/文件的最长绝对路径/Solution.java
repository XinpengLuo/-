package 左神.暴力递归和动态规划.递归和回溯.刷题.文件的最长绝对路径;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int lengthLongestPath(String input) {
       HashMap<Integer, Integer> preLevel = new HashMap<Integer,Integer>();
       int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int length = s.length() - level;
            if(s.contains(".")){
                res = Math.max(res,preLevel.getOrDefault(level - 1,0) + length);
            }
            else{
                preLevel.put(level, preLevel.getOrDefault(level - 1,0) + length + 1);
            }
        }
        return res;
    }


//    public int help(String input, int index) {
//        if(index >= input.length())
//            return 0;
//
//    }
public static void main(String[] args) {
    String test = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
    Solution solution = new Solution();
    System.out.println(solution.lengthLongestPath(test));
}
}
