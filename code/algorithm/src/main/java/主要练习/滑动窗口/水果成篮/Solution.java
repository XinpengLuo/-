package 主要练习.滑动窗口.水果成篮;

import java.util.HashMap;

public class Solution {
    public int totalFruit(int[] fruits) {
        int max = Integer.MIN_VALUE;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < fruits.length; i++){
            int temp = fruits[i];
            map.put(temp,map.getOrDefault(temp,0) + 1);
            count++;
            while (map.size() > 2){
                int left = fruits[j];
                map.put(left,map.get(left) - 1);
                if(map.get(left) == 0)
                    map.remove(left);
                count--;
                j++;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(solution.totalFruit(arr));
    }
}
