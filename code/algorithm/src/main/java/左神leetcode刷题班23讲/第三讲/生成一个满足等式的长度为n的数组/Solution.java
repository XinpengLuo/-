package 左神leetcode刷题班23讲.第三讲.生成一个满足等式的长度为n的数组;


import java.util.Arrays;

//等式为对于 数组中任选 i j k 其中 i < j < k 都满足a[i] + a[k] != a[j] * 2
public class Solution {
    public int[] createArr(int n){
        int[] arr = {1};
        while (arr.length != n){
            int[] tempOdd = new int[arr.length]; //奇数变换的数组
            int[] tempEven = new int[2 * arr.length > n ? n - arr.length : arr.length]; //偶数变换的数组
            for(int i = 0; i < tempOdd.length; i++)
                tempOdd[i] = 2 * (arr[i]) + 1;
            for(int i = 0; i < tempEven.length; i++)
                tempEven[i] = 2 * arr[i];
            int[] temp = new int[tempEven.length + tempOdd.length];
            System.arraycopy(tempOdd,0,temp,0,tempOdd.length);
            System.arraycopy(tempEven,0,temp,tempOdd.length,tempEven.length);
            arr = temp;
        }
        return arr;
    }
    public int[] makeNo(int size){
        if(size == 1)
            return new int[]{1};
        int halfSize = (size + 1) / 2;
        int[] base = makeNo(halfSize);
        int[] ans = new int[size];
        int index = 0;
        for(; index < halfSize;index++)
            ans[index] = base[index] * 2 + 1;
        for(int i = 0; index < size; i++,index++)
            ans[index] = base[i] * 2;
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arrOne = solution.createArr(5);
        System.out.println(Arrays.toString(arrOne));
        System.out.println(solution.isValid(arrOne));
        int[] arrTwo = solution.makeNo(5);
        System.out.println(Arrays.toString(arrTwo));
        System.out.println(solution.isValid(arrTwo));
    }
    public boolean isValid(int[] arr){
        for(int i = 0; i < arr.length; i++)
            for(int j = i + 1; j < arr.length; j++)
                for(int k = j + 1; k < arr.length; k++)
                    if(arr[i] + arr[k] == 2 * arr[j])
                        {
                            System.out.println(arr[i] + " " + arr[k] + " " + arr[j]);
                            return false;
                        }
        return true;
    }
}
