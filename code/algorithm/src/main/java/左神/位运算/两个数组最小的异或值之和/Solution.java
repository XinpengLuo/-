package 左神.位运算.两个数组最小的异或值之和;

import java.util.*;

/**
 * @author luoxinpeng
 */
public class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int res = 0;
        int state = 0;
        for(int i = 0; i < nums2.length; i++)
        {
            state += (1 << i);
        }
        res = dfs(nums1,nums2,state,0);
        return res;
    }
    /**
        0 --> 不可选 1 --> 可选
     **/
    public int dfs(int[] nums1, int[] nums2, int state, int index){
        if(index == nums1.length){
            return 0;
        }
        int num = nums1[index];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums2.length; i++){
            if(((state >> i) & 1) == 1){
                state ^= (1 << i);
                String target = state + " " + (index + 1);
                if(map.containsKey(target)){
                    res = Math.min(res, (num ^ nums2[i]) + map.get(target));
                }
                else{
                    int temp = (dfs(nums1,nums2,state,index + 1));
                    res = Math.min(res, (num ^ nums2[i]) + temp);
                    map.put(target,temp);
                }
                state |= (1 << i);
            }
        }
        String target = state + " " + index;
        map.put(target,res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {2,3};
        System.out.println(solution.minimumXORSum(nums1, nums2));
    }
}
