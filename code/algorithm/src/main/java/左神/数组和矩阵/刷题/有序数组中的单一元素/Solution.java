package 左神.数组和矩阵.刷题.有序数组中的单一元素;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(mid % 2 == 0){ //如果是偶数 那么应该后面一个相等
                if(mid + 1 < nums.length && nums[mid + 1] == nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else
            {
                if(mid - 1 >= 0 && nums[mid - 1] == nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(arr));
    }
}
