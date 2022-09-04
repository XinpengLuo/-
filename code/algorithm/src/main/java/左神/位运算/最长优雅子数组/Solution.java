package 左神.位运算.最长优雅子数组;

public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res = 1;
        int j = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            while(!check(temp,nums[i])){
                int num = nums[j];
                temp ^= num;
                j++;
            }
            temp |= nums[i];
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
    public boolean check(int temp, int num){
        for(int i = 0; i < 32; i++){
            int a = (num >> i) & 1;
            int b = (temp >> i) & 1;
            if(a == 1 && b == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr ={1,3,8,48,10};
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubarray(arr));
    }
}
