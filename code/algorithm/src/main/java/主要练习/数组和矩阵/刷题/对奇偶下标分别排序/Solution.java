package 主要练习.数组和矩阵.刷题.对奇偶下标分别排序;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>(); //偶数下标
        List<Integer> even = new ArrayList<>(); //奇数下标
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0)
                odd.add(nums[i]);
            else
                even.add(nums[i]);
        }
        Collections.sort(odd);
        Collections.sort(even, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        List<Integer> res = new ArrayList<>();
        boolean flag = true;
        int i = 0, j = 0;
        while (res.size() != nums.length){
            if(flag)
                {
                    res.add(odd.get(i));
                    i++;
                    flag = false;
                }
            else{
                res.add(even.get(j));
                j++;
                flag = true;
            }
        }
        for(int k = 0; k < nums.length; k++)
            nums[k] = res.get(k);
        return nums;
    }
}
