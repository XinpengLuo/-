package 周赛.第七次周赛.第四题;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    ArrayList<Integer> visited = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); //leftValue indexArray
    int[][] ans;
    public void validArrangement(int[][] pairs) {
        ans = new int[pairs.length][pairs[0].length];
        for (int i = 0; i < pairs.length; i++) {
            int[] temp = pairs[i];
            if(map.containsKey(temp[0]))
                map.get(temp[0]).add(i);
            else{
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                map.put(temp[0],arrayList);
            }
        }
        for(int i = 0; i < pairs.length; i++)
        {
            ans[0] = pairs[i];
            if(help(pairs,i,1,pairs[i][1]))
                break;
            ans[0] = null;
        }
    }
    public boolean help(int[][] pairs, int index, int length, int preValue){
        if(visited.contains(index))
            return false;
        if(length == pairs.length)
            return true;
        if(!map.containsKey(preValue))
            return false;
        visited.add(index);
        ArrayList<Integer> list = map.get(preValue);
        for(int i = 0; i < list.size(); i++)
           {
               ans[length] = pairs[list.get(i)];
               if(help(pairs,list.get(i),length + 1,pairs[list.get(i)][1]))
                   return true;
                ans[length] = null;
           }
        visited.remove(visited.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{5,1},{4,5},{11,9},{9,4}};
        solution.validArrangement(arr);
    }
}
