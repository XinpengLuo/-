package 主要练习.二分总结.爱吃香蕉的珂珂;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        int left = 1;
        int right = max;
        int res = -1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int temp = 0;
            for (int pile : piles) {
                temp += (pile / middle + (pile % middle == 0 ? 0 : 1));
            }
            if(temp <= h)
                {
                    right = middle - 1;
                    res = middle;
                }
            else
                left = middle + 1;
        }
        return res;
    }
}
