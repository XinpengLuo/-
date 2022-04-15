package 左神.随想录.第一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {
    public int getAnsByHash(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i] * arr[i]);
        }
        return hashSet.size();
    }
    public int getAnsBySort(Integer[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr,0,arr.length,new Comparator<Integer>() {//自定义排序，绝对值大的在前
            public int compare(Integer a,Integer b) {
                return Math.abs(b)-Math.abs(a);
            }
        });

        int ans = 1;
        int pre = arr[0] * arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] * arr[i] != pre)
                ans++;
            pre = arr[i] * arr[i];
        }
        return ans;
    }
    public int getAnsByDoublePoint(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        while (left <= right){
            ans++;
            int leftAbs = Math.abs(arr[left]);
            int rightAbs = Math.abs(arr[right]);
            if(leftAbs > rightAbs)
                while (left < arr.length && Math.abs(arr[left]) == leftAbs)
                    left++;
            else if(leftAbs < rightAbs)
                while (right >= 0 && Math.abs(arr[right]) == rightAbs)
                    right--;
            else{
                while (left <= right && Math.abs(arr[left]) == leftAbs)
                    left++;
                while (left <= right && Math.abs(arr[right]) == rightAbs)
                    right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-7,-7,-7,-5,-5,-4,-4,-3,0,1,4,4,5,6};
        Integer[] nums = {-7,-5,-5,-4,-4,-3,0,1,4,4,5,6};
        System.out.println(solution.getAnsByHash(arr));
        System.out.println(solution.getAnsBySort(nums));
        System.out.println(solution.getAnsByDoublePoint(arr));
    }
}
