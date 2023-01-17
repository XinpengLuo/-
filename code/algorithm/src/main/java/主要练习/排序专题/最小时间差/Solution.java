package 主要练习.排序专题.最小时间差;
import java.util.Collections;
import java.util.List;
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < timePoints.size(); i++){
            ans = Math.min(getMinutes(timePoints.get(i)) - getMinutes(timePoints.get(i - 1)), ans);
        }
        int first = getMinutes(timePoints.get(0));
        int last = getMinutes(timePoints.get(timePoints.size() - 1));
        ans = Math.min(ans,first - last + 1440);
        return ans;
    }
    public int getMinutes(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        return hour * 60 + minute;
    }
}
