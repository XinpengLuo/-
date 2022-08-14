package 左神.数组和矩阵.刷题.搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int minValueIndex = getMinValueIndex(nums);
        System.out.println(minValueIndex);
        if(nums[0] == target)
            return 0;
        else if(nums[0] > target)
            return searchIndex(nums,minValueIndex,nums.length - 1,target);
        else
            {
                if(minValueIndex == 0)
                    return searchIndex(nums,0,nums.length - 1,target);
                return searchIndex(nums,0,minValueIndex - 1,target);
            }
    }
    //获得旋转数组中最小值的下标
    public int getMinValueIndex(int[] nums){
        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i + 1] < nums[i])
                return i + 1;
        return 0;
    }
    //二分法查找
    public int searchIndex(int[] nums, int left, int right, int target){
        if(left > right)
            return -1;
        int middleIndex = (left + right) / 2;
        if(nums[middleIndex] == target)
            return middleIndex;
        else if(nums[middleIndex] < target)
            return searchIndex(nums,middleIndex + 1,right,target);
        else
            return searchIndex(nums,left,middleIndex - 1,target);
    }


    public int better(int[] nums, int target){
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;
        int index = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[0])
                left = mid + 1;
            else{
                index = mid;
                right = mid -1;
            }
        }
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
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }



    //[4,5,6,7,0,1,2]
    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution();
        System.out.println(solution.better(nums, 0));
    }
}
