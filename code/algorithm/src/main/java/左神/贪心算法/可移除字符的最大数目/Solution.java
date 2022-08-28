package 左神.贪心算法.可移除字符的最大数目;

import java.util.*;

public class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int res = 0;
        int left = 0, right = removable.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(check(s,p,removable,mid)){
                res = mid + 1;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return res;
    }
    public boolean check(String s, String p, int[] removable, int k){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i <= k; i++)
            set.add(removable[i]);
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()){
            if(set.contains(i)){
                i++;
                continue;
            }
            if(s.charAt(i) == p.charAt(j))
                j++;
            i++;
        }
        return j == p.length();
    }


    public int tupleSameProduct(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < nums.length; j++){
                if(i != j && !set.contains(nums[j])){
                    int temp = nums[i] * nums[j];
                    res += map.getOrDefault(temp,0);
                    map.put(temp,map.getOrDefault(temp,0) + 1);
                    set.add(nums[j]);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,4,6};
        System.out.println(solution.tupleSameProduct(nums));
    }
}
