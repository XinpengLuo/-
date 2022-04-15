package 左神leetcode刷题班23讲.第三讲.求第k小的数值对;

import java.util.Arrays;

public class Solution {
    public int[] getNumber(int[] arr, int k){
        int indexA = (k - 1) / arr.length;
        int indexB = (k - 1) % arr.length;
        System.out.println(indexA);
        System.out.println(indexB);
//        indexB = indexB <= 0 ? (indexA + 1) * arr.length : indexB;
//        indexB = indexB % arr.length;
        Arrays.sort(arr);
        System.out.println(indexB);
        return new int[]{arr[indexA],arr[indexB]};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={3,1,2};
        System.out.println(Arrays.toString(solution.getNumber(arr,9)));
    }
}
