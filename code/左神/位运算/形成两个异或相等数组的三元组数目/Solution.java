package 左神.位运算.形成两个异或相等数组的三元组数目;

public class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++)
            for(int j = i + 1; j < arr.length; j++)
               {
                   int temp = 0;
                   for(int k = i; k <= j; k++){
                       temp ^= arr[k];
                   }
                   if(temp == 0)
                       res += (j - i + 1 - 2);
               }
        return res;
    }
    public int better(int[] arr){
        int res = 0;
        int[] pre = new int[arr.length];
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            temp ^= arr[i];
            pre[i] = temp;
            if(temp == 0)
                res += i;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if((pre[i - 1] ^ pre[j]) == 0)
                    res += (j - i + 1 - 1);
            }
        }
        return res;
    }
}
