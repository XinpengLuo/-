package 左神.位运算.按位或最大的最小子数组长度;

import java.util.*;

public class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] res = new int[nums.length];
        int[] state = new int[32];
        for(int i = nums.length - 1; i >= 0; i--){
            int max = 0;
            for(int j = 31; j >= 0; j--){
                int a = state[j];
                int b = (nums[i] >> j) & 1;
                if(a != 0 && b == 0)
                    max = Math.max(max, a - i + 1);
                if(b == 1)
                    state[j] = i;
            }
            res[i] = max == 0 ? 1 : max;
        }
        return res;
    }

    public int closestToTarget(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>(set);
        for(int i = 0; i < arr.length; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                list.add(arr[i]);
            }
        }
        for(int i = 0; i < list.size(); i++)
        {
            int temp = list.get(i);
            for(int j = i; j < list.size(); j++){
                temp &= list.get(j);
                ans = Math.min(Math.abs(temp - target), ans);
                if(temp <= target)
                {
                    System.out.println(1);
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {59,63,31,53};
        Solution solution = new Solution();
        System.out.println(solution.closestToTarget(arr,21));
    }
}
