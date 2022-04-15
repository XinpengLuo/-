package 周赛.第二次周赛.第三题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] res = new int[queries.length];
        HashMap<Integer,Integer> map = new HashMap<>(); //第一个版本 key 对应 价格 value 对应价格的最大美丽值;
        for (int i = 0; i < items.length; i++) {
            int price = items[i][0];
            int beau = items[i][1];
            if(!map.containsKey(price))
                map.put(price,beau);
            else{
                int tempValue = map.get(price);
                if(beau > tempValue)
                    map.put(price,beau);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int tempAns = 0;
            int tempKey = queries[i];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() <= tempKey)
                    tempAns = Math.max(tempAns,entry.getValue());
            }
            res[i] = tempAns;
        }
        return res;
    }
    public int[] maximumBeautyBetter(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        int preMax = Integer.MIN_VALUE;
        for(int i = 0; i < items.length; i++){
            preMax = Math.max(preMax,items[i][1]);
            items[i][1] = preMax;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = findLastIndex(items,queries[i]);
            if(index != -1)
                res[i] = items[index][1];
        }
        return res;
    }
    public int findLastIndex(int[][] items, int target){
        int l = 0;
        int r = items.length - 1;
        int index = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(items[mid][0] <= target){
                l = mid + 1;
                index = mid;
            }
            else
                r = mid - 1;
        }
        return index;
    }
    public int[] maximumBeautySecondTime(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        int preMax = Integer.MIN_VALUE;
        for(int i = 0; i < items.length; i++){
            preMax = Math.max(preMax,items[i][1]);
            items[i][1] = preMax;
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int index = findIndex(items,queries[i]);
            if(index == -1)
                res[i] = 0;
            else
                res[i] = items[index][1];
        }
        return res;
    }
    //查找最后一个小于等于target的下标
    public int findIndex(int[][] items, int target){
        int left = 0;
        int right = items.length - 1;
        int index = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(items[mid][0] <= target){
                index = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return index;
    }
}
