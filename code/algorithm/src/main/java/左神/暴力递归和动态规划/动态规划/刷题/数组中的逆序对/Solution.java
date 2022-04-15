package 左神.暴力递归和动态规划.动态规划.刷题.数组中的逆序对;

public class Solution {
    public int reversePairs(int[] nums, int left, int right) {
        if(left >= right)
            return 0;
        int mid = (left + right) / 2;
        int res = reversePairs(nums,left,mid) + reversePairs(nums,mid + 1,right);
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right){
            if(nums[i] > nums[j])
                {
                    temp[index] = nums[j];
                    res += (mid - i + 1);
                    j++;
                }
            else
                {
                    temp[index] = nums[i];
                    i++;
                }
            index++;
        }
        while (j <= right){
            temp[index] = nums[j];
            j++;
            index++;
        }
        while (i <= mid){
            temp[index] = nums[i];
            i++;
            index++;
        }
        for(int p = left,k = 0; p <= right; p++,k++)
            nums[p] = temp[k];
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,3,2,3,1};
        System.out.println(solution.reversePairs(arr,0,arr.length - 1));
    }
}
