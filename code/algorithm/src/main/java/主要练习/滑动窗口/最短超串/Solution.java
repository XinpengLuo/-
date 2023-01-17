package 主要练习.滑动窗口.最短超串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        int[] ans = new int[2];
        int j = 0;
        boolean flag = false;
        for(int i = 0; i < small.length; i++)
            set.add(small[i]);
        for(int i = 0; i < big.length; i++){
            if(set.contains(big[i]))
                map.put(big[i],map.getOrDefault(big[i],0) + 1);
            while (map.size() == small.length){
                flag = true;
                if(i - j < res){
                    res = i - j;
                    ans[0] = j;
                    ans[1] = i;
                }
                if(map.containsKey(big[j])){
                    if(map.get(big[j]) > 1)
                        map.put(big[j],map.get(big[j]) - 1);
                    else
                        map.remove(big[j]);
                }
                j++;
            }
        }
        return flag ? ans : new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = {1,5,9};
        System.out.println(Arrays.toString(solution.shortestSeq(big, small)));
    }
}
