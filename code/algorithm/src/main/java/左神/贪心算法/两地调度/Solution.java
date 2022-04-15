package 左神.贪心算法.两地调度;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        for(int i = 0; i < costs.length; i++)
            sum += costs[i][0];
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return (t1[1] - t1[0]) - (t2[1] - t2[0]);
            }
        });
        for(int i = 0; i < costs.length / 2; i++)
            sum += (costs[i][1] - costs[i][0]);
        return sum;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        Solution solution = new Solution();
        System.out.println(solution.twoCitySchedCost(costs));
    }
}
