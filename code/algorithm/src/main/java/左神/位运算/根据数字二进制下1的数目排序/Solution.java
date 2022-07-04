package 左神.位运算.根据数字二进制下1的数目排序;

import java.util.*;

public class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        for (int i : arr) {
            temp.add(i);
        }
        Collections.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                int countOne = getCountOne(t1);
                int countTwo = getCountOne(t2);
                if(countOne == countTwo)
                    return t1 - t2;
                return countOne - countTwo;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.get(i);
        }
        return arr;
    }
    public int getCountOne(int num){
        int count = 0;
        for(int i = 0; i <= 31; i++){
            if((num & (1 << i)) != 0)
                count++;
        }
        return count;
    }
}
