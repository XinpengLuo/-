package 左神.数组和矩阵.刷题.统计作战单位数;

public class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for(int i = 0; i < rating.length; i++){
            int temp = rating[i];
            int leftLess = 0;
            int leftGreater = 0;
            int rightLess = 0;
            int rightGreater = 0;
            for(int j = i - 1; j >= 0; j--){
                if(rating[j] > temp)
                    leftGreater++;
                if(rating[j] < temp)
                    leftLess++;
            }
            for(int j = i + 1; j < rating.length; j++){
                if(rating[j] > temp)
                    rightGreater++;
                if(rating[j] < temp)
                    rightLess++;
            }
            res += (leftLess * rightGreater);
            res += (leftGreater * rightLess);
        }
        return res;
    }
}
