package 左神.其他专题.离开日期;

public class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aArrive = countDay(arriveAlice);
        int aLeft = countDay(leaveAlice);
        int bArrive = countDay(arriveBob);
        int bLeft = countDay(leaveBob);
        if(Math.max(aArrive,bArrive) > Math.min(aLeft,bLeft))
            return 0;
        return Math.min(aLeft,bLeft) - Math.max(aArrive,bArrive) + 1;
    }
    public int countDay(String s){
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(s.substring(0,2));
        int day = Integer.parseInt(s.substring(3,5));
        int res = 0;
        for(int i = 0; i < month - 1; i++)
            res += arr[i];
        return res + day;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDaysTogether("10-01", "10-31", "11-01", "12-31"));
    }
}
