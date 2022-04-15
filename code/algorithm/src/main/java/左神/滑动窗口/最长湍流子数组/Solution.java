package 左神.滑动窗口.最长湍流子数组;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length <= 1)
            return arr.length;
        if(arr.length == 2)
            return arr[0] == arr[1] ? 1 : 2;
        int res = 1;
        int pre = 1;
        if(arr[1] != arr[0]){
            res = 2;
            pre = 2;
        }
        for(int i = 2; i < arr.length; i++){
            if((arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i]) || (arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i]))
            {
                pre++;
                res = Math.max(res,pre);
            }
            else
            {
                if(arr[i - 1] != arr[i])
                    pre = 2;
                else
                    pre = 1;
                res = Math.max(res,pre);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1,1,0,1,0,1,1,0,0};
        int[] test = {100,100,100};
      System.out.println(solution.maxTurbulenceSize(arr));
        System.out.println(solution.maxTurbulenceSize(test));
    }
}
