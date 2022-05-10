package 左神.字符串.多次搜索;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public static int[][] multiSearch(String big, String[] smalls) {
        int[][] ans = new int[smalls.length][1];
        int index = 0;
        for (String small : smalls) {
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i <= big.length() - small.length(); i++)
                {
                    String temp = big.substring(i,i + small.length());
                    if(temp.equals(small) && !small.equals(""))
                       tempList.add(i);
                }
            int[] arr = new int[tempList.size()];
            for(int j = 0; j < tempList.size(); j++)
                arr[j] = tempList.get(j);
            ans[index++] = arr;
        }
        return ans;
    }

    public static void main(String[] args) {

        String big = "abc";
        String[] smalls = {""};
        int[][] res = multiSearch(big, smalls);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
