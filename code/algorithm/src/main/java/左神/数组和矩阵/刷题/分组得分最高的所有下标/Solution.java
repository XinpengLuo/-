package 左神.数组和矩阵.刷题.分组得分最高的所有下标;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] countOne = new int[nums.length];
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] == 1)
                    count++;
                countOne[i] = count;
            }
        int max = 0;
        //左边0的个数 和右边1的个数
        for(int i = 0; i <= nums.length; i++){
            int left = 0;
            int right = 0;
            if(i == 0)
                right = countOne[nums.length - 1];
            else if(i == nums.length)
                left = nums.length - countOne[nums.length - 1];
            else{
                left = i - countOne[i - 1];
                right = countOne[nums.length - 1] - countOne[i - 1];
            }
            int temp = left + right;
            if(temp < max)
                continue;
            if(temp > max)
                {
                    max = temp;
                    res.clear();
                }
            res.add(i);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,0,1,0};
        System.out.println(solution.maxScoreIndices(arr));
    }
}
