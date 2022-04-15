package 左神.数组和矩阵.刷题.子集1;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        help(nums,0,new ArrayList<>());
        return res;
    }
    public void help(int[] nums, int index, List<Integer> temp){
        if(index == nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        help(nums,index + 1,temp);
        temp.add(nums[index]);
        help(nums,index + 1,temp);
        temp.remove(temp.size() - 1);
    }
}
