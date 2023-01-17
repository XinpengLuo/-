package 主要练习.位运算.构建回文串检测;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];
            res.add(isValid(s,left,right,k));
        }
        return res;
    }
    public Boolean isValid(String s, int left, int right, int k){
        if(k >= 13)
            return true;
        HashSet<Character> set = new HashSet<>();
        for(int i = left; i <= right; i++)
            if(!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        return set.size() / 2 <= k;
    }
    public List<Boolean> better(String s, int[][] queries){
        List<Boolean> res = new ArrayList<>();
        int state = 0;
        int[] map = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            state = state ^ (1 << (s.charAt(i) - 'a'));
            map[i] = state;
        }
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];
            if(left == 0)
            {
                if(map[right] == 0 || countOne(map[right]) / 2 <= k)
                    res.add(true);
                else
                    res.add(false);
            }
            else if(map[left - 1] == map[right] || (countOne((map[left - 1] ^ map[right])) / 2 <= k))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
    public int countOne(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
