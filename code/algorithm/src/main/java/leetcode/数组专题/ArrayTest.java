package leetcode.数组专题;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ArrayTest {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                return result;
            if(i > 0 && nums[i - 1] == nums[i])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && nums[left] == nums[left + 1])  left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if(temp < 0){
                    left++;
                }
                else if(temp > 0){
                    right--;
                }
            }
        }
        return result;
    }
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int num = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i - 1] != num)
                return false;
        }
        return true;
    }
    //二分查找
    public boolean twoSearch(int[] arr, int target){
       int l = 0;
       int r = arr.length - 1;
       int mid = 0;
       while (l < r){
           mid = (l + r) / 2;
           if(arr[mid] == target)
               return true;
           else if(arr[mid] < target){
               l = mid + 1;
           }
           else {
               r = mid - 1;
           }
       }
       return false;
    }
    public static int test(int[] arr){
        int index = -1;
        int left = 0;
        int right = arr.length - 2;
        int target = arr[arr.length - 1];
        while (left <= right){
            int min = (left + right) / 2;
            if(arr[min] <= target)
                {
                    index = min;
                    left = min + 1;

                }
            else
                right = min - 1;
        }
        System.out.println(index);
        return arr[index];
    }
    public static void swap(int i,int j){
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;

        System.out.println(i);
        System.out.println(j);
    }
    public static void swapManOrMin(int[] arr, int target){
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < target){
                if(j + 1 != i){
                    int temp = arr[i];
                    arr[i] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                    j = j + 1;
            }
        }
    }
    public static void swapNetherlands(int[] arr, int target){
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while (cur < more){
            if(arr[cur] < target){
                swap(arr,++less,cur++);
            }else if(arr[cur] > target)
                swap(arr,--more,cur);
            else
                cur++;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,3,5,8,1,6,5};
        swapNetherlands(arr,5);
        System.out.println(Arrays.toString(arr));
    }
}
