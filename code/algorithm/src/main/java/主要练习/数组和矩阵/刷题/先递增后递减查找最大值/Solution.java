package 主要练习.数组和矩阵.刷题.先递增后递减查找最大值;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2};
        Solution solution = new Solution();
        System.out.println(solution.binarySearch(arr));
    }
    public int binarySearch(int[] arr){
        int left = 0, right = arr.length - 1;
        int index = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(mid == arr.length - 1 || mid == 0 || (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]))
                return arr[mid];
            else if(arr[mid] < arr[mid + 1]){
                index = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return arr[index];
    }
}
