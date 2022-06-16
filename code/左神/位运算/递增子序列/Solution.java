package 左神.位运算.递增子序列;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums,0,new ArrayList<>(),-101);
        return res;
    }
    public void dfs(int[] nums, int i, List<Integer> temp, int preVal){
        if(i == nums.length)
            res.add(new ArrayList<>(temp));
        if(nums[i] != preVal){
            dfs(nums, i + 1,temp,preVal);
        }
        temp.add(nums[i]);
        dfs(nums, i + 1,temp,nums[i]);
        temp.remove(temp.size() - 1);

    }

    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(9);
        temp.remove(9);
    }
}
