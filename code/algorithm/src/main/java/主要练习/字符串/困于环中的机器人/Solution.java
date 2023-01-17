package 主要练习.字符串.困于环中的机器人;

import java.util.Arrays;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int[] directions = {1,-1,-1,1}; //北 西 南 东
        int directionIndex = 0;
        for (char c : instructions.toCharArray()) {
            if(c == 'G'){
                if(directionIndex == 0 || directionIndex == 2)
                    y += directions[directionIndex];
                else
                    x += directions[directionIndex];
            }
            else if(c == 'L')
                directionIndex = (directionIndex + 1) % 4;
            else
                directionIndex = (directionIndex + 3) % 4;
        }
        if((x == 0 && y == 0) || directionIndex != 0)
            return true;
        return false;
    }
    public void sortArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int max = 0;
            for(int j = 0; j <= n - 1 - i; j++)
                if(arr[j] > arr[max]){
                    max = j;
                }
            swap(arr,max,n - i - 1);
        }
    }
    public void swap(int[] arr, int i, int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,4,7,9};
        Solution solution = new Solution();
        solution.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
