package 主要练习.数组和矩阵.刷题.数组中第k大的元素;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums,i);
        }
        int res = 0;
        int size = nums.length;
        while (k > 0){
            swap(nums,0,--size);
            res = nums[size];
            heapFy(nums,size);
            k--;
        }
        return res;
    }
    //建堆
    public void heapInsert(int[] nums,int index){
        while (nums[index] > nums[(index - 1) / 2]){
            swap(nums,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    //堆化
    public void heapFy(int[] nums, int heapSize){
        int index = 0;
        int left = 2 * index + 1;
        while (left < heapSize){
            int larger = left;
            if(larger + 1 < heapSize && nums[larger + 1] > nums[larger])
                larger = left + 1;
            if(nums[index] < nums[larger]){
                swap(nums,larger,index);
                index = larger;
                left = 2 * index + 1;
            }
            else
                break;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
