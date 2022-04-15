package 周赛.第六次周赛.第四题;

import java.util.*;

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashSet<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[2] - t2[2];
            }
        });
        int index = 0;
        while (index < meetings.length){
            int j = index;
            while (j < meetings.length && meetings[j][2] == meetings[index][2])
                j++;
            boolean flag = true;
            while (flag){
                int preSize = res.size();
                for(int k = index; k < j; k++)
                    if(res.contains(meetings[k][0]) || res.contains(meetings[k][1])){
                        res.add(meetings[k][0]);
                        res.add(meetings[k][1]);
                    }
                if(preSize == res.size())
                    flag = false;
                else
                    flag = true;
            }
            index = j == index ? j + 1 : j;
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{3,4,2},{1,3,1},{4,5,1}};
        System.out.println(solution.findAllPeople(6, arr, 1));
    }
}
