package 左神中级班.第四节.洗衣机问题;

public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int i = 0; i < machines.length; i++)
            sum += machines[i];
        if(sum % machines.length != 0)
            return -1;
        int avg = sum / machines.length;
        int ans = 0;
        int leftSum = 0;
        for (int i = 0; i < machines.length; i++) {
            int leftNeed = leftSum - i * avg;
            int rightNeed = (sum - leftSum - machines[i]) - (machines.length - i - 1) * avg;
            if(leftNeed < 0 && rightNeed < 0)
                ans = Math.max(ans,Math.abs(leftNeed) + Math.abs(rightNeed));
            else
                ans = Math.max(ans,Math.max(Math.abs(leftNeed),Math.abs(rightNeed)));
            leftSum += machines[i];
        }
        return ans;
    }
}
