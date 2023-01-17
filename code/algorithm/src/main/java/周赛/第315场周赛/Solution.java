package 周赛.第315场周赛;

import java.util.*;

public class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
            if(num > 0){
                if(num > max && set.contains(-num))
                    max = num;
            }
        }
        return max;
    }



    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            String reverse = sb.reverse().toString();
            System.out.println(reverse);
            int i = Integer.parseInt(reverse);
            set.add(i);
        }
        return set.size();
    }


    public boolean sumOfNumberAndReverse(int num) {
        int max = num / 2;
        for(int i = 1; i <= num; i++){
            int left = num - i;
            if(isPara(i,left))
                return true;
        }
        return false;
    }
    public boolean isPara(int left, int right){
        StringBuilder sb = new StringBuilder(String.valueOf(left));
        sb = sb.reverse();
        if(Integer.parseInt(sb.toString()) != right)
            return false;
        return true;
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            while (!map.isEmpty() && (map.firstKey() < minK || map.lastKey() > maxK)){
                if(j <= i){
                    int left = nums[j];
                    if(map.get(left) == 1)
                        map.remove(left);
                    else
                        map.put(left,map.get(left) - 1);
                    j++;
                }
            }
            //1  1 3  5 5 2
            if(!map.isEmpty())
                if(map.firstKey() == minK && map.lastKey() == maxK)
                    res += map.get(map.firstKey()) * map.get(map.lastKey());
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,3,5,5,2};
        System.out.println(solution.countSubarrays(arr,1,5));
    }
}
