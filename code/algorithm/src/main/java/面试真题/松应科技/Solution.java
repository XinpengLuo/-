package 面试真题.松应科技;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * max increasing subsequence
     * @param arr int整型ArrayList the array
     * @return int整型
     */
    public int MLS (int[] arr) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        arr = new int[set.size()];
        int j = 0;
        for (Integer integer : set) {
            arr[j] = integer;
            j++;
        }
        Arrays.sort(arr);
        int max = 1;
        int index = 0;
        while(index < arr.length){
            int temp = 1;
            while(index + 1 < arr.length && arr[index + 1] == arr[index] + 1){
                temp++;
                index++;
            }
            max = Math.max(max,temp);
            index++;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
       int[] arr = {100,4,200,1,3,2};
       Solution solution = new Solution();
        System.out.println(solution.MLS(arr));
    }
}