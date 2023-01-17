package 面试真题.微软.加油站;

import 面试真题.华为机试.火车进站.Main;

import java.util.*;

class Solution {
    int res = 0;
    public int solution(int[] A, int[] B) {
        // write your code in Java 11 (Java SE 11)
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            int parent = A[i];
            int child = B[i];
            if(parent != 0 && child != 0)
                continue;
            if(child == 0){
                child = parent;
                parent = 0;
            }
            map.get(0).add(child);
            map.put(child,new ArrayList<>());
            set.add(i);
        }
        while (set.size() < A.length){
            for(int i = 0; i < A.length; i++){
                if(set.contains(i))
                    continue;
                int parent = A[i];
                int child = B[i];
                if(!map.containsKey(parent) && !map.containsKey(child))
                    continue;
                if(map.containsKey(child)){
                    int temp = parent;
                    parent = child;
                    child = temp;
                }
                map.get(parent).add(child);
                map.put(child,new ArrayList<>());
                set.add(i);
                if(set.size() >= A.length)
                    break;
            }
        }
        dfs(map,0);
        return res;
    }
    public int dfs(HashMap<Integer,List<Integer>> map, int parent){
        List<Integer> children = map.get(parent);
        if(children == null)
            return 1;
        int sum = parent == 0 ? 0 : 1;
        for (Integer child : children) {
            int temp = dfs(map,child);
            res += (temp + 4) / 5;
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {0,1,1};
        int[] b = {1,2,3};
//        int[] a = {1,1,1,9,9,9,9,7,8};
//        int[] b = {2,0,3,1,6,5,4,0,0};
        Solution solution = new Solution();
        System.out.println(solution.solution(a, b));
    }
}
