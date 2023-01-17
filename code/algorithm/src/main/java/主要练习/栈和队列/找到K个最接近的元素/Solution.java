package 主要练习.栈和队列.找到K个最接近的元素;
import java.util.*;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return i == j ? i - j : Math.abs(i - x) - Math.abs(j - x);
            }
        });
        List<Integer> res = list.subList(0, k);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        Solution solution = new Solution();
        for (Integer element : solution.findClosestElements(arr, 3, 5)) {
            System.out.println(element);
        }
    }
}
