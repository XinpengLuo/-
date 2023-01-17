package 主要练习.数组和矩阵.刷题.优势洗牌或者田忌赛马;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        //每次在a中寻找大于b的最小值 若没有则返回a中的最小值
        List<Integer> temp = new ArrayList<>();
        for (int i : nums1) {
            temp.add(i);
        }
        int j = 0;
        for(int i = 0; i < nums2.length; i++){
            int index = -1, left = 0, right = temp.size() - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(temp.get(mid) > nums2[i]){
                    index = mid;
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            index = index == -1 ? 0 : index;
            res[j] = temp.get(index);
            temp.remove(index);
            j++;
        }
        return res;
    }
}
