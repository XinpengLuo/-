package 主要练习.其他专题.最大交换;

import java.util.*;

public class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for(int i = 0; i < arr.length; i++){
            int maxIndex = i;
            for(int j = arr.length - 1; j >= i + 1; j--){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            if(maxIndex != i){
                char temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
                return Integer.parseInt(String.valueOf(arr));
            }
        }

        return num;
    }
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double sum = 0;
        int n = arr.length;
        for(int i = (int) (n * 0.05); i < (int)(n * 0.95); i++){
            sum += arr[i];
        }
        return sum / (double) (n * 0.9);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread();

        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        Solution solution = new Solution();
        System.out.println(solution.trimMean(arr));
    }
}
