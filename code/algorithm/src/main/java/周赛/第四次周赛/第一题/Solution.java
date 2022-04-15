package 周赛.第四次周赛.第一题;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < colors.length; i++)
            map.put(colors[i],i);// key -- 颜色 value -- 下标
        //这样的方法是  map记录的每个颜色出现的最后位置 然后每个数组元素再去比较 不是自己的那样
        for (int i = 0; i < colors.length; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() != colors[i])
                    ans = Math.max(Math.abs(entry.getValue() - i),ans);
            }

        }
        return ans;
    }
    public int better(int[] colors){
        if(colors[0] != colors[colors.length - 1])
            return colors.length - 1;
        int ans = 0;
        for(int i = 1; i < colors.length; i++)
            if(colors[i] != colors[0])
                ans = Math.max(i,ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {9,9,9,18,9,9,9,9,9,18};
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(arr));
        System.out.println(solution.better(arr));
    }
}
