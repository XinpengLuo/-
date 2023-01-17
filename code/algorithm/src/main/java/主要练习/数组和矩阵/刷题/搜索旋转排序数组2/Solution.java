package 主要练习.数组和矩阵.刷题.搜索旋转排序数组2;

class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)
            return false;
        if(nums.length == 1)
            return nums[0] == target ? true : false;
        int left = 0, right = nums.length - 1;
        int index = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == nums.length - 1 || mid == 0 || (nums[mid] >= nums[mid - 1] && nums[mid] <= nums[mid + 1]))
                left = mid + 1;
            else{
                index = mid;
                right = mid -1;
            }
        }
        System.out.println(index);
        if(target >= nums[0])
        {
            left = 0;
            right = index - 1;
        }else {
            left = index;
            right = nums.length - 1;
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1};
        Solution solution = new Solution();
        System.out.println(solution.search(arr, 0));
    }
}