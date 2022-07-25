package 面试真题;

import 左神.挑战困难专题.乘法表第k小的数字.Solution;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
    }
    public static long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int j = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(j != -1) {
                    long len = i - j;
                    System.out.println(len);
                    count += ((long)((len * (len + 1))) / 2);
                    j = -1;
                }
            }
            else{
                if(j == -1)
                    j = i;
            }
        }
        if(j != -1){
            int len = nums.length - j;
            count += ((len * (len + 1)) / 2);
        }
        return count;
    }
}
class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> numToIndex;
    HashMap<Integer,Integer> indexToNum;
    public NumberContainers() {
        numToIndex = new HashMap<>();
        indexToNum = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer pre = indexToNum.get(index);
        if(pre != null) {
            numToIndex.get(pre).remove(index);
        }
        indexToNum.put(index,number);
        TreeSet<Integer> queue = numToIndex.get(number);
        if(queue == null){
            queue = new TreeSet<>();
            numToIndex.put(number,queue);
        }
        queue.add(index);
    }

    public int find(int number) {
        TreeSet<Integer> queue = numToIndex.getOrDefault(number, new TreeSet<>());
        return queue.isEmpty() ? -1 : queue.first();
    }
}
