package 周赛.第308场周赛;


import java.util.*;

public class Solution {


    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int sum = 0;
            int j = -1;
            for(int i = 0; i < nums.length; i++){
                if(sum + nums[i] <= queries[k]) {
                    sum += nums[i];
                    j = i;
                }
            }
            res[k] = j == -1 ? 0 : j + 1;
        }

        return res;
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        while (index < sb.length()){
            char c = sb.charAt(index);
            if(c == '*'){
                sb.deleteCharAt(index);
                if(index - 1 >= 0)
                    sb.deleteCharAt(index - 1);
                index--;
                continue;
            }
            index++;
        }
        return sb.toString();
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int lastP = -1, lastM = -1, lastG = -1;
        for (int j = 0; j < garbage.length; j++) {
            String s = garbage[j];
            int countG = 0, countP = 0, countM = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'G')
                    countG++;
                else if(c == 'M')
                    countM++;
                else
                    countP++;
            }
            if(countG != 0){
                res += countG;
                int start = lastG == -1 ? 0 : lastG;
                for(int k = start; k < j; k++)
                    res += travel[k];
                lastG = j;
            }
            if(countM != 0){
                res += countM;
                int start = lastM == -1 ? 0 : lastM;
                for(int k = start; k < j; k++)
                    res += travel[k];
                lastM = j;
            }
            if(countP != 0){
                res += countP;
                int start = lastP == -1 ? 0 : lastP;
                for(int k = start; k < j; k++)
                    res += travel[k];
                lastP = j;
            }
        }
        return res;
    }


    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] res = new int[k][k];

        return res;
    }






    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] g = {"G","P","GP","GG"};
        int[] arr = {2,4,3};
        System.out.println(solution.garbageCollection(g,arr));
    }
}
