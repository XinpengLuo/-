package 周赛.第五次周赛.第三题;


public class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans = 0;
        int x = startPos[0], y = startPos[1];
        int targetX = homePos[0], targetY = homePos[1];
        if(x < targetX){
            while (x < targetX){
                ans += rowCosts[x + 1];
                x++;
            }
        }
        else{
            while (x > targetX){
                ans += rowCosts[x - 1];
                x--;
            }
        }
        if(y < targetY){
            while (y < targetY){
                ans += colCosts[y + 1];
                y++;
            }
        }
        else{
            while (y > targetY){
                ans += colCosts[y - 1];
                y--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] startPos = {1,0};
        int[] homePost = {2,3};
        int[] rowCosts = {5,4,3};
        int[] colCosts = {8,2,6,7};
        System.out.println(solution.minCost(startPos, homePost, rowCosts, colCosts));
    }
}

