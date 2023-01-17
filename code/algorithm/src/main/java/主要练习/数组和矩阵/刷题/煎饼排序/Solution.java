package 主要练习.数组和矩阵.刷题.煎饼排序;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int index = arr.length;
        while (index != 0)
        {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for(int i = 0; i < index; i++){
                if(arr[i] > max){
                    max = arr[i];
                    maxIndex = i;
                }
            }
            if(maxIndex == index - 1){
                index--;
                continue;
            }
            res.add(maxIndex + 1);
            reverseArr(arr,0,maxIndex);
            res.add(index);
            reverseArr(arr,0,index - 1);
            index--;
        }
        return res;
    }
    public void reverseArr(int[] arr, int i, int j){
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,2,4,1};
        List<Integer> res = solution.pancakeSort(arr);
        for (Integer re : res) {
            System.out.println(re);
        }

    }
}
