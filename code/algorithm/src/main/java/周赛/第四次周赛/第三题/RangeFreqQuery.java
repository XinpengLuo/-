package 周赛.第四次周赛.第三题;

import 周赛.第四次周赛.第二题.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class RangeFreqQuery {
    private int[] nums;
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        nums = arr;
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(nums[i])){
                List<Integer> temp = map.get(nums[i]);
                temp.add(i);
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> temp = map.get(value);
        int first = findFirstTarget(temp,left);
        if(first == -1)
            return 0;
        int last = findGreaterTarget(temp,right);
        return last - first;
    }
    public int findFirstTarget(List<Integer> arr, int target){
        if(arr == null || arr.size() == 0)
            return -1;
        int ans = -1;
        int l = 0;
        int r = arr.size() - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr.get(mid) >= target)
            {
                r = mid - 1;
                ans = mid;
            }
            else if(arr.get(mid) < target)
                l = mid + 1;
        }
        return ans;
    }
    //查找第一个大于target的下标
    public int findGreaterTarget(List<Integer> arr, int target){
        if(arr == null || arr.size() == 0)
            return -1;
        int ans = arr.size();
        int l = 0;
        int r = arr.size() - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr.get(mid) > target)
            {
                r = mid - 1;
                ans = mid;
            }
            else
                l = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {8,4,2,5,4,5,8,6,2,3};
        RangeFreqQuery ra = new RangeFreqQuery(arr);
        System.out.println(ra.query(6, 8, 4));
//        System.out.println(ra.query(0,11,33));
    }
}
