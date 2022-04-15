package 周赛.第三次周赛.第一题;

public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        while (tickets[k] != 0){
            int count = 0;
            for(int i = 0; i < tickets.length; i++)
            {
                if(tickets[i] != 0){
                    count++;
                    tickets[i]--;
                }
                if(tickets[k] == 0)
                    break;
            }
            ans += count;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5,1,1,1};
        System.out.println(solution.timeRequiredToBuy(arr, 0));
    }
}
