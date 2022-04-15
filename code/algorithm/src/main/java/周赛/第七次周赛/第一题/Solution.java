package 周赛.第七次周赛.第一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class Solution {
    HashSet<Integer> temp = new HashSet<>();
    public int[] findEvenNumbers(int[] digits) {
        help(digits,0,new StringBuilder());
        int[] ans = new int[temp.size()];
        Object[] objects = temp.toArray();
        for(int i = 0; i < objects.length; i++)
             ans[i] = (int) objects[i];
        Arrays.sort(ans);
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    public void help(int[] disgits, int index, StringBuilder sb){
        if(sb.length() == 3){
            if(sb.charAt(0) == '0')
                return;
            int tempNumber = Integer.parseInt(sb.toString());
            if(tempNumber % 2 == 0)
                temp.add(tempNumber);
            return;
        }

        for(int i = 0; i < disgits.length; i++)
            if(disgits[i] != -1)
                {
                    int num = disgits[i];
                    disgits[i] = -1;
                    sb.append(num);
                    help(disgits,i,sb);
                    disgits[i] = num;
                    sb.deleteCharAt(sb.length() - 1);
                }

    }

    public int[] better(int[] digits){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < digits.length; i++)
            for(int j = 0; j < digits.length; j++)
                for(int k = 0; k < digits.length; k++){
                    if(i == j || i == k || j == k)
                        continue;
                    int tempNumber = 100 * digits[i] + 10 * digits[j] + digits[k];
                    if(tempNumber >= 100 && tempNumber % 2 == 0)
                        set.add(tempNumber);
                }
        int[] res = new int[set.size()];
        Object[] objects = temp.toArray();
        for(int i = 0; i < objects.length; i++)
            res[i] = (int)objects[i];
        Arrays.sort(res);
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,2,8,8,2};
        solution.findEvenNumbers(arr);
    }
}
