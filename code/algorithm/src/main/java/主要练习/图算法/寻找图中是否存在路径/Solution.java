package 主要练习.图算法.寻找图中是否存在路径;

import java.util.*;

public class Solution {
    boolean[] isVisited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[][] path = new int[n][n];
        isVisited = new boolean[n];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            path[a][b] = 1;
            path[b][a] = 1;
        }
        return dfs(n,path,source,destination);
    }
    public boolean dfs(int n , int[][] edges, int source, int dest){
        if(source == dest)
            return true;
        isVisited[source] = true;
        boolean res = false;
        for(int i = 0; i < n; i++){
            if(edges[source][i]  != 0 && !isVisited[i]){
                res = res || dfs(n,edges,i,dest);
            }
        }
        return res;
    }
    public boolean bfs(int n, int[][] edges, int source, int destination) {
        if(source == destination)
            return true;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if(!map.containsKey(a))
                map.put(a,new ArrayList<Integer>());
            if(!map.containsKey(b))
                map.put(b,new ArrayList<Integer>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            if(cur == destination)
                return true;
            visited[cur] = true;
            if(!map.containsKey(cur))
                continue;
            for (Integer child : map.get(cur)) {
                if(!visited[child])
                    queue.add(child);
            }
        }
        return false;
    }
}
