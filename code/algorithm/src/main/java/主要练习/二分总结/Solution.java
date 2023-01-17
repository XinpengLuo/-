package 主要练习.二分总结;

public class Solution {
    //用二分法查找有序数值中是否有某个target
    public boolean findTarget(int[] arr, int target){
        if(arr == null || arr.length == 0)
            return false;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
    //查找第一个大于等于 target的下标 如果有这个target的话 就是target第一次出现的位置
    public int findFirstTarget(int[] arr, int target){
        if(arr == null || arr.length == 0)
            return -1;
        int ans = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] >= target)
            {
                r = mid - 1;
                ans = mid;
            }
            else if(arr[mid] < target)
                l = mid + 1;
        }
        return ans;
    }
    //查找第一个大于target的下标
    public int findGreaterTarget(int[] arr, int target){
        if(arr == null || arr.length == 0)
            return -1;
        int ans = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] > target)
            {
                r = mid - 1;
                ans = mid;
            }
            else
                l = mid + 1;
        }
        return ans;
    }
    //查找最后一个小于或者等于target的下标
    public int findLessTarget(int[] arr, int target){
        if(arr == null || arr.length == 0)
            return -1;
        int ans = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] <= target)
            {
                l = mid + 1;
                ans = mid;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,4,5};
        Solution solution = new Solution();
        System.out.println(solution.findTarget(arr,4));
        System.out.println(solution.findFirstTarget(arr,4));
        System.out.println(solution.findGreaterTarget(arr,4));
        System.out.println(solution.findLessTarget(arr,4));
    }
}
