package 周赛.第304场周赛;

import java.util.*;

public class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int index = 0;
        while(index < nums.length && nums[index] == 0)
            index++;
        while(index < nums.length){
            if(nums[index] != 0)
                count++;
            for(int i = index + 1; i < nums.length; i++)
                nums[i] -= nums[index];
            index++;
        }
        return count;
    }
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int count = 0;
        int target = 1;
        while(true){
            if(n >= target){
                count++;
                n -= target;
                target++;
            }
            else
                break;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,0,3,5};
        Solution solution = new Solution();
        HashMap<String,String> map = new HashMap<>();
        map.put("22","22");
        System.out.println(solution.minimumOperations(arr));
    }
}
