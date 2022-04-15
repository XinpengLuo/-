package 周赛.第十次周赛.第四题;

public class Solution {
    public long coutPairs(int[] nums, int k) {
        long count = 0;
        long countEven = 0;
        int countFactor = 0;
        for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] % k == 0)
                {
                    count += (nums.length - 1);
                    countEven++;
                }
                if(k % nums[i] == 0 && nums[i] != k && nums[i] != 1)
                    countFactor++;
            }
        if(countFactor >= 2)
            count += (countFactor - 1);
        if(countEven >= 2)
            return count - countEven + 1;
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8,10,2,5,9,6,3,8,2};
        System.out.println(solution.coutPairs(nums, 6));
    }
}
