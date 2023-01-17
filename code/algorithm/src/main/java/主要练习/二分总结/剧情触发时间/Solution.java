package 主要练习.二分总结.剧情触发时间;

public class Solution {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {

        int[] res = new int[requirements.length];
        int[][] pre = new int[increase.length][3];
        pre[0][0] = increase[0][0];
        pre[0][1] = increase[0][1];
        pre[0][2] = increase[0][2];
        for(int i = 1; i < increase.length; i++){
            pre[i][0] = increase[i][0] + pre[i - 1][0];
            pre[i][1] = increase[i][1] + pre[i - 1][1];
            pre[i][2] = increase[i][2] + pre[i - 1][2];
        }
        for(int i = 0; i < requirements.length; i++){
            if(requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] == 0)
            {
                res[i] = 0;
                continue;
            }
            int left = 0, right = pre.length - 1;
            int temp = -1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if(pre[mid][0] >= requirements[i][0] && pre[mid][1] >= requirements[i][1] && pre[mid][2] >= requirements[i][2])
                {
                    temp = mid + 1;
                    right = mid - 1;
                }else
                    left = mid + 1;
            }
            res[i] = temp;
        }
        return res;
    }
}
