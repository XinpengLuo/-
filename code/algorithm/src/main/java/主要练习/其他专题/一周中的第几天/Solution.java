package 主要练习.其他专题.一周中的第几天;

public class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int sum = 0;
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] ans = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        for(int i = 1971; i < year; i++)
            if(isRun(i))
                sum += 366;
            else
                sum += 365;
        for(int i = 0; i < month - 1; i++)
            sum += monthDays[i];
        sum += day;
        if(month > 2 && isRun(year))
            sum++;
        sum = sum % 7;
        if(sum <= 3)
            return ans[3 + sum];
        return ans[sum - 4];
    }
    public boolean isRun(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        return false;
    }
}
