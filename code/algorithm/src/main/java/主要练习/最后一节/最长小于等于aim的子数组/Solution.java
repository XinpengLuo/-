package 主要练习.最后一节.最长小于等于aim的子数组;

public class Solution {
    public int maxLength(int[] arr, int aim){
        if(arr == null || arr.length == 0)
            return 0;
        int[] sum = new int[arr.length];
        int[] end = new int[arr.length];
        sum[sum.length - 1] = arr[arr.length - 1]; //每个元素开头的最小累加和
        end[end.length - 1] = end.length - 1 ;//每个元素最小累加和的右边界
        for(int i = arr.length - 2; i >= 0; i--){
            if(sum[i + 1] < 0){
                sum[i] = arr[i] + sum[i + 1];
                end[i] = end[i + 1];
            }else{
                sum[i] = arr[i];
                end[i] = i;
            }
        }
        int R = 0;
        int tempSum = 0;
        int len = 0;
        for (int start = 0; start < arr.length; start++) {
            while (R < arr.length && tempSum + sum[R] <= aim){
                tempSum += sum[R];
                R = end[R] + 1;
            }
            tempSum -= R > start ? arr[start] : 0;
            len = Math.max(len,R - start);
            R = Math.max(R, start + 1);
        }
        return len;
    }
    public int countVowelSubstrings(String word) {
        int sum = 0;
        for(int i = 0; i < word.length(); i++)
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
                sum++;
        return sum;
    }
}
