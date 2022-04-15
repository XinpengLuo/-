package 临时;

import java.util.*;

public class Test {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int insertValue = arr[i];
            while (j >= 0 && arr[j] > insertValue){
                {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }
            arr[j + 1] = insertValue;
        }
    }
    //求数组的最小值
    public static int getMin(int[] arr, int index){
        if(index + 1 < arr.length)
            return Math.min(arr[index],getMin(arr,++index));
        else
            return arr[index];
    }
    public static int getMinPath(int[][] arr, int sum, int i, int j){
        if(i >= arr.length - 1 && j >= arr[0].length - 1)
            return sum + arr[i][j];
        sum += arr[i][j];
        if(i == arr.length - 1)
            return getMinPath(arr,sum,i,j + 1);
        if(j == arr[0].length - 1)
            return getMinPath(arr,sum,i + 1,j);
        return Math.min(getMinPath(arr,sum, i + 1,j) , (getMinPath(arr,sum,i,j + 1)));
    }
    public static int getMinPathDeepPlan(int[][] arr,int i, int j){
        int r = arr.length;
        int c = arr[0].length;
        int[][] result = new int[r][c];
        result[r - 1][c - 1] = arr[r - 1][c - 1];
        for(int k = 2; k <= r; k++){
            result[r - k][c - 1] = result[r - k + 1][c - 1] + arr[r - k][c - 1];
        }
        for(int k = 2; k <= c; k++){
            result[r - 1][c - k] = result[r - 1][c - k + 1] + arr[r - 1][c - k];
        }
        int k = r - 2;
        int l = c - 2;
        while (k != i || l != j){
            result[k][l] = arr[k][l] + Math.min(result[k + 1][l],result[k][l + 1]);
            if(l - 1 >= 0)
                l = l - 1;
            else{
                l = c - 2;
                k = k - 1;
            }
        }

        result[i][j] = arr[i][j] + Math.min(result[i + 1][j],result[i][j + 1]);
        return result[i][j];
    }

    //求数组中是否存在组合等于sum
    public static boolean isSum(int[] arr, int sum, int index, int preSum){
        if(index == arr.length)
            return sum == preSum;
        return isSum(arr,sum,index + 1,preSum) || isSum(arr,sum,index + 1,preSum + arr[index]);
    }
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        if (isSum(arr,5,0,0)) {
            System.out.println(1);
        }
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(j > nums.length / 2)
                return nums[j];
            if(nums[i + 1] == nums[i])
                j++;
            else
                j = 1;
        }
        return -1;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
             else{
                 if(Math.abs(map.get(nums[i]) - i) < k)
                     return true;
                 else
                     map.put(nums[i],i);
            }
        }
        return false;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m - 1;
        int b = n - 1;
        int len = nums1.length - 1;
        while (a >= 0 && b >= 0){
            nums1[len--] = nums1[a] >= nums2[b] ? nums1[a--] : nums2[b--];
        }
        System.arraycopy(nums2,0,nums1,0,b + 1);
    }
    public void test(){

    }
}

