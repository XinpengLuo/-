package 自己写的排序专题.荷兰国旗快速排序;

import java.util.Arrays;

public class Solution {
    //partition 小于等于target的放左边 大于放右边
    public void partition(int[] arr, int target){
        int less = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= target){
                swap(arr,i,++less);
            }
        }
    }
    //荷兰国旗问题 小于的放左边 等于的放中间 大于的放右边 返回等于区间的左边界和右边界 闭区间
    public int[] partitionFlag(int[] arr, int i, int j){
        int target = arr[i];
        int left = i - 1;
        int right = j + 1;
        int cur = i;
        while(cur < right){
            if(arr[cur] < target){
                swap(arr,cur++,++left);
            }else if(arr[cur] > target){
                swap(arr,cur,--right);
            }
            else
                cur++;
        }
        return new int[]{left + 1,cur - 1};
    }
    public void quickSortFlag(int[] arr, int left, int right){
        if(left >= right)
            return;
        int[] flag = partitionFlag(arr,left,right);
        quickSortFlag(arr,left,flag[0] - 1);
        quickSortFlag(arr,flag[1] + 1,right);
    }

    public void quickSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int left = i;
        int right = j;
        int base = arr[i];
        while(i < j){
            while(i < j && arr[j] >= base)
                j--;
            while(i < j && arr[i] <= base)
                i++;
            swap(arr,i,j);
        }
        swap(arr,left,i);
        quickSort(arr,left,i - 1);
        quickSort(arr,i + 1, right);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,2,3,1,3,2,5,6,7,3,2,4};
        solution.quickSortFlag(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] test = {3,2,3,1,3,2,5,6,7,3,2,4};
        solution.quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
