package 周赛.第14次周赛.第二题;
import java.net.Socket;
import java.util.*;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> map = new HashMap<>(); //几号 输了 几场
        HashSet<Integer> zero = new HashSet<>();
        HashSet<Integer> one = new HashSet<>();
        for (int[] match : matches) {
            int win = match[0];
            int lose = match[1];
            map.put(lose,map.getOrDefault(lose, 0) + 1);
            if(!map.containsKey(win))
                zero.add(win);
            if(zero.contains(lose))
                zero.remove(lose);
            if(map.get(lose) == 1)
                one.add(lose);
            if(map.get(lose) >= 2)
                one.remove(lose);
        }
        List<Integer> loseZero = new ArrayList<>(zero);
        List<Integer> loseOne = new ArrayList<>(one);
        Collections.sort(loseZero);
        Collections.sort(loseOne);
        List<List<Integer>> res = new ArrayList<>();
        res.add(loseZero);
        res.add(loseOne);
        return res;
     }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr ={{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        solution.findWinners(arr);
    }
}
