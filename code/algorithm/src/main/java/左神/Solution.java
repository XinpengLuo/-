package 左神;
import java.util.*;

public class Solution {
    //两个证书数组 共同的证书 数组arraylist 返回list 重复的元素
    public List<Integer> getBothInt(List<Integer> arr1, List<Integer> arr2){
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.size() && j < arr2.size()){
            int a = arr1.get(i), b = arr2.get(j);
            if(a < b){
                i++;
            }
            else if(a > b){
                j++;
            }
            else{
                res.add(a);
                while (i < arr1.size() && arr1.get(i) == a)
                    i++;
                while (j < arr2.size() && arr2.get(j) == b)
                    j++;
            }
        }
        return res;
    }
    //整数数组 求最频繁出现 m = 10 数组有哪些十个数字最频繁
    public int[] getMaxTime(int[] arr, int m){
        PriorityQueue<int[]> queue = new PriorityQueue<>((t1, t2) -> t2[1] - t1[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        for (Integer key : map.keySet()) {
            int num = key;
            int time = map.get(num);
            int[] temp = new int[]{num,time};
            queue.add(temp);
        }
        if(m > queue.size())
            return null;
        int[] res = new int[m];
        for(int i = 0; i < res.length; i++){
            res[i] = queue.poll()[0];
        }
        return res;
    }


    //stack 三个方法 push pop getMin
    //top




    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3,4,4,4,5,5,5,5,1};
        Solution solution = new Solution();
        int[] res = solution.getMaxTime(arr, 3);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }
}
