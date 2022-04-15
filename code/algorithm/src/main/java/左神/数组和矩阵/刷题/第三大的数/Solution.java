package 左神.数组和矩阵.刷题.第三大的数;

public class Solution {
    public int thirdMax(int[] nums) {
        Long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        int flag = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > a){
                c = b;
                b = a;
                a = Long.valueOf(nums[i]);
                flag++;
            }
            else if(nums[i] > b && nums[i] < a){
                c = b;
                b = Long.valueOf(nums[i]);
                flag++;
            }
            else if(nums[i] > c && nums[i] < b){
                c = Long.valueOf(nums[i]);
                flag++;
            }
        }
        return Math.toIntExact(flag >= 3 ? c : a);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(nums));
    }
}
