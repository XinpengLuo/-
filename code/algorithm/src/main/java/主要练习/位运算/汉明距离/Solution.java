package 主要练习.位运算.汉明距离;

import java.util.*;

public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((x & (1 << i)) ^ (y & (1 << i))) != 0) {
                count++;
            }
        }
        return count;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,12,1,4,1,5,4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(arr));
    }
}
