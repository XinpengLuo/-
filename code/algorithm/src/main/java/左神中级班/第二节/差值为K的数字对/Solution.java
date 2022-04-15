package 左神中级班.第二节.差值为K的数字对;
import java.util.*;

public class Solution {
    public List<List<Integer>> allPair(int[] nums, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++)
            if(set.contains(nums[i] + k))
                res.add(Arrays.asList(nums[i],nums[i] + k));
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,1,7,8};
        Solution solution = new Solution();
    }
}
