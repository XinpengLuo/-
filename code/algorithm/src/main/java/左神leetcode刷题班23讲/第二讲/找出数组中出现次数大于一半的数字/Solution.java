package 左神leetcode刷题班23讲.第二讲.找出数组中出现次数大于一半的数字;

public class Solution {
    public int findNumberOverHalf(int[] nums){
        int candi = 0, hp = 0;
        for(int i = 0; i < nums.length; i++){
            if(hp == 0){
                candi = nums[i];
                hp++;
            }
            else{
                if(candi != nums[i])
                    hp--;
                else
                    hp++;
            }
        }
        if(hp == 0)
            return -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == candi)
                count++;
        if(count > nums.length / 2)
            return candi;
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,21,2,2,2};
        System.out.println(solution.findNumberOverHalf(arr));
    }
}
