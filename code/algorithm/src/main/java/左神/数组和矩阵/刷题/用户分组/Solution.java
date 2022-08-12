package 左神.数组和矩阵.刷题.用户分组;

import java.util.*;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            if(!map.containsKey(groupSizes[i]))
                map.put(groupSizes[i],new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
        for (Integer key : map.keySet()) {
            for(int i = 0; i < map.get(key).size() / key; i++){
                List<Integer> temp = new ArrayList<>();
                for(int j = i * key; j < i * key + key; j++)
                    temp.add(map.get(key).get(j));
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,3,3,3,3,1,3};
        System.out.println(solution.groupThePeople(arr));
    }
}
