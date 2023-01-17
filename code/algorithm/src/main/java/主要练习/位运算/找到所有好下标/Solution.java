package 主要练习.位运算.找到所有好下标;
import java.util.*;

public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums.length < 2 * k + 1)
            return res;
        int[] dpTop = new int[nums.length];
        int[] dpBot = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dpBot[i] = 1;
            dpTop[i] = 1;
            if(i == 0)
                continue;
            if(nums[i] >= nums[i - 1])
                dpTop[i] += dpTop[i - 1];
            if(nums[i] <= nums[i - 1])
                dpBot[i] += dpBot[i - 1];
        }
        for(int i = k; i < nums.length - k; i++){
            if(dpBot[i - 1] >= k && dpTop[i + k] >= k)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {478184,863008,716977,921182,182844,350527,541165,881224};
        Solution solution = new Solution();
        System.out.println(solution.goodIndices(arr, 1));
    }
}
