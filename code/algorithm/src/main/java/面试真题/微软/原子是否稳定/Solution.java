package 面试真题.微软.原子是否稳定;

public class Solution {
    int solution(int A[]) {
        // write your code in C (C99 (gcc 6.2.0))
        long res = 0;
        long[] nums = new long[A.length];
        for(int i = 0; i < A.length; i++)
            nums[i] = A[i];
        int index = 0;
        while (index < nums.length - 1){
            int j = index + 1;
            long diff = nums[j] - nums[index];
            long len = 0;
            while (j + 1 < nums.length && nums[j + 1] - nums[j] == diff){
                j++;
                len = j - index + 1;
            }
            if(len >= 3){
                res += (len - 1) * (len - 2) / 2;
            }
            index = j;
        }
        if(res > 1000000000)
            return -1;
        return (int) res;
    }




    public static void main(String[] args) {
        int[] nums = new int[30000];
        for(int i = 0; i < nums.length; i++)
        {
            if(i % 2 == 0)
                nums[i] = -2000000000;
            else
                nums[i] = 2000000000;
        }
        //int[] arr = {-1,1,3,3,3,2,3,2,1,0};
        Solution solution = new Solution();
        System.out.println(solution.solution(nums));
    }
}
