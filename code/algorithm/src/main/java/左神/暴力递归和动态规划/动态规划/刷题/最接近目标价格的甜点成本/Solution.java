package 左神.暴力递归和动态规划.动态规划.刷题.最接近目标价格的甜点成本;

public class Solution {
    int ans = 0;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int i = 0; i < baseCosts.length; i++)
            help(toppingCosts,target,0,2,baseCosts[i]);
        return ans;
    }
    public void help(int[] toppingCosts, int target, int index, int time, int tempValue){
        if(time < 0)
            return;
        if(index == toppingCosts.length)
        {
            if(Math.abs(tempValue - target) < Math.abs(target - ans))
                ans = tempValue;
            return;
        }
       help(toppingCosts,target,index + 1,time,tempValue);
       help(toppingCosts,target,index + 1,time - 1,tempValue + toppingCosts[index]);
       help(toppingCosts,target,index + 1,time - 2,tempValue + 2 * toppingCosts[index]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
