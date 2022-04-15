package 周赛.第十三次周赛.第一题;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == key)
                temp.add(i);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < temp.size(); j++)
                if(Math.abs(i - temp.get(j)) <= k)
                    {res.add(i);
                    break;}
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,4,9,1,3,9,5};
        List<Integer> kDistantIndices = solution.findKDistantIndices(arr, 9, 1);
        for (Integer kDistantIndex : kDistantIndices) {
            System.out.println(kDistantIndex);
        }
    }
}
