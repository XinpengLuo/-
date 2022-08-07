package 周赛.第84场双周赛;

import java.util.*;

public class Solution {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int[] ints : items1) {
            int value = ints[0];
            int weight = ints[1];
            map.put(value,map.getOrDefault(value,0) + weight);
        }
        for (int[] ints : items2) {
            int value = ints[0];
            int weight = ints[1];
            map.put(value,map.getOrDefault(value,0) + weight);
        }
        for (Integer key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            temp.add(map.get(key));
            res.add(temp);
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> t1, List<Integer> t2) {
                return t1.get(0) - t2.get(0);
            }
        });
        return res;
    }

    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long res = (n * (n - 1)) / 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i] - i;
            res -= map.getOrDefault(temp,0);
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }
        return res;
    }
    //4 + 3 + 2 + 1
    //4 1 3 3
    //3 0 2 2
    //0 1 2 3

    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        HashMap<Integer,Long> map = new HashMap<>();
        int index = 0;
        while(index < tasks.length){
            int type = tasks[index];
            if(map.isEmpty() || !map.containsKey(type) || map.get(type) + space + 1 <= res){
                map.put(type,res);
                index++;
            }
            else{
                res = map.get(type) + space;
            }
            res++;
        }
        return res;
    }


    public long minimumReplacement(int[] nums) {
        long res = 0;
        int last = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] <= last){
                last = nums[i];
                continue;
            }
            int k = (nums[i] + last - 1) / last;
            res += k - 1;
            last = nums[i] / k;
        }
        return res;
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,10,3};
        System.out.println(solution.minimumReplacement(arr));
    }
}
