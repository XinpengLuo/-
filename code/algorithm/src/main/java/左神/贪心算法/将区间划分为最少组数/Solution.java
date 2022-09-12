package 左神.贪心算法.将区间划分为最少组数;

import java.util.*;

public class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0] == t2[0])
                    return t1[1] - t2[1];
                return t1[0] - t2[0];
            }
        });
        int count = 0;
        int res = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++)
            list.add(intervals[i]);
        while(count != intervals.length){
            int start = list.get(0)[1];
            list.remove(0);
            count++;
            if(!list.isEmpty()){
                while (true){
                    int nextIndex = search(list,start);
                    if(nextIndex == -1)
                        break;
                    count++;
                    start = list.get(nextIndex)[1];
                    list.remove(nextIndex);
                }
            }
            res++;
        }
        return res;
    }
    public int search(List<int[]> list, int target){
        int index = -1;
        int left = 0, right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid)[0] > target){
                index = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return index;
    }
    public static void main(String[] args) {
        int[][] arr = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        Solution solution = new Solution();
        System.out.println(solution.minGroups(arr));
    }
}
