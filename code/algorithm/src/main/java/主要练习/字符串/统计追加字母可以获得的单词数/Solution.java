package 主要练习.字符串.统计追加字母可以获得的单词数;

import java.util.*;

public class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (String startWord : startWords) {
            int state = 0;
            for (int i = 0; i < startWord.length(); i++) {
                state |= (1 << (startWord.charAt(i) - 'a'));
            }
            set.add(state);
        }
        for (String targetWord : targetWords) {
            int state = 0;
            for (int i = 0; i < targetWord.length(); i++) {
                state |= (1 << (targetWord.charAt(i) - 'a'));
            }
            for(int i = 0; i < 32; i++){
                if(((state >> i) & 1) != 1)
                    continue;
                int temp = state ^ (1 << i);
                if(set.contains(temp)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public void quickSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int left = i;
        int right = j;
        int target = arr[i];
        while(i < j){
            while(i < j && arr[j] >= target)
                j--;
            while (i < j && arr[i] <= target)
                i++;
            swap(arr,i,j);
        }
        swap(arr,i,left);
        quickSort(arr,left, i - 1);
        quickSort(arr,i + 1,right);
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] s = {"ant","act","tack"};
//        String[] e = {"tack","act","acti"};
//        System.out.println(solution.wordCount(s, e));
        int[] arr = {3,3,4,5,1,2,3,67,7,3,42};
        solution.quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
