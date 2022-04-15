package 周赛.第十二次周赛.第二题;

import java.util.*;

public class Solution {
    int[] map = null;
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                if(isGreater(mapping,i,j))
                    return 1;
                return -1;
            }
        });
        for(int i = 0; i < nums.length; i++)
            nums[i] = res.get(i);
        return nums;
    }
    public boolean isGreater(int[] mapping, int a, int b){
        String newA = String.valueOf(a);
        String newB = String.valueOf(b);
        StringBuilder tempA = new StringBuilder();
        StringBuilder tempB = new StringBuilder();
        for(int i = 0; i < newA.length(); i++)
            tempA.append(mapping[newA.charAt(i) - '0']);
        for(int i = 0; i < newB.length(); i++)
            tempB.append(mapping[newB.charAt(i) - '0']);
        if(Integer.parseInt(tempA.toString()) > Integer.parseInt(tempB.toString()))
            return true;
        return false;
    }
    private void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(isGreater(map,num[j],key) && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(!isGreater(map,num[i],key)&& i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
    }

}
