package 左神.暴力递归和动态规划.递归和回溯.刷题.祖玛游戏;

import java.util.HashMap;

public class Solution {
    public int findMinStep(String board, String hand) {
        HashMap<String,Integer> map = new HashMap<>();
        int res = help(board,hand.toCharArray(),map);

        return res > hand.length() ? -1 : res;
    }
    public int help(String board, char[] hand,HashMap<String,Integer> map){
        if(board.length() == 0 || board.equals(""))
            return 0;
        if(map.containsKey(board))
            return map.get(board);
        int res = 16;
        for(int i = 0; i < hand.length; i++){
            char c = hand[i];
            if(c != '0')
            {
                for(int j = 0; j < board.length(); j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(board.substring(0,j));
                    sb.append(c);
                    sb.append(board.substring(j));
                    removeBoardSame(sb,j);
                    hand[i] = '0';
                    res = Math.min(help(sb.toString(),hand,map) + 1,res);
                    hand[i] = c;
                 }
            }
        }
        map.put(board,res);
        return res;
    }
    public void removeBoardSame(StringBuilder sb,int index){
        if(index < 0)
            return;

        char c = sb.charAt(index);
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && sb.charAt(left) == c)
            left--;
        while (right < sb.length() && sb.charAt(right) == c)
            right++;
        int length = right - left - 1;
        if(length >= 3)
        {
            sb.delete(left + 1,right);
            removeBoardSame(sb,left);
        }
    }
    public void test(){
        StringBuilder sb = new StringBuilder("sfafa");

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String board = "R";
        String hand = "RR";
        solution.test();
        System.out.println(solution.findMinStep(board, hand));
    }
}
