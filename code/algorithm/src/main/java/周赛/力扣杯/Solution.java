package 周赛.力扣杯;

import 面试真题.快手栈.Main;

import java.util.*;
import java.util.concurrent.locks.*;

public class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int[] A = new int[temperatureA.length - 1];
        int[] B = new int[temperatureB.length - 1];
        for(int i = 1; i < temperatureA.length; i++){
            if(temperatureA[i] == temperatureA[i - 1])
                A[i - 1] = 0;
            else if(temperatureA[i] > temperatureA[i - 1])
                A[i - 1] = 1;
            else
                A[i - 1] = -1;

            if(temperatureB[i] == temperatureB[i - 1])
                B[i - 1] = 0;
            else if(temperatureB[i] > temperatureB[i - 1])
                B[i - 1] = 1;
            else
                B[i - 1] = -1;
        }
        int res = 0;
        int index = 0;
        while (index < A.length){
            int temp = 0;
            while (index < A.length && A[index] == B[index]) {
                index++;
                temp++;
            }
            index++;
            res = Math.max(res,temp);
        }
        return res;
    }
    //上 右 下 左
    int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};

    public int[][] ballGame(int num, String[] plate) {
        List<int[]> list = new ArrayList<>();
        int n = plate.length, m = plate[0].length();
        for(int i = 1; i < m - 1; i++) {
            if(plate[0].charAt(i) == '.' && check(0, i, plate, 2,num))
                list.add(new int[]{0, i});
            if(plate[n - 1].charAt(i) == '.' && check(n - 1,i,plate,0,num))
                list.add(new int[]{n - 1,i});
        }
        for(int i = 1; i < n - 1; i++){
            if(plate[i].charAt(0) == '.' && check(i,0,plate,1,num))
                list.add(new int[]{i,0});
            if(plate[i].charAt(m - 1) == '.' && check(i,m - 1,plate,3,num))
                list.add(new int[]{i,m - 1});
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
    public boolean check(int i, int j, String[] plate, int dIndex, int num){
        while (true){
            String key = i + "_" + j;
            if(i < 0 || j < 0 || i >= plate.length || j >= plate[i].length())
                return false;
            char c = plate[i].charAt(j);

            if(c == 'O')
                break;
            else if(c == 'W'){ //顺时针
                dIndex = (dIndex - 1 + 4) % 4;

            }
            else if(c == 'E'){
                dIndex = (dIndex + 1) % 4;

            }
            if(num == 0)
                return false;
            num--;
            i += direction[dIndex][0];
            j += direction[dIndex][1];
        }
        return true;
    }

    public int transportationHub(int[][] path) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> root = new HashSet<>();
        for (int[] ints : path) {
            int from = ints[0];
            int to = ints[1];
            if(!map.containsKey(from))
                map.put(from,new HashSet<>());
            map.get(from).add(to);
            root.add(from);
            root.add(to);
        }
        int ans = -1;
        for (Integer node : root) {
            if(map.containsKey(node))
                continue;
            int count = 0;
            for (Integer from : map.keySet()) {
                if(!map.get(from).contains(node))
                    continue;
                count++;
            }
            if(count == root.size() - 1)
                ans = node;
        }
        return ans;
    }




    public static void main(String[] args) {
        String[] board = {"E...W..WW",".E...O...","...WO...W","..OWW.O..",".W.WO.W.E","O..O.W...",".OO...W..","..EW.WEE."};
        for (String s : board) {
            System.out.println(s);
        }
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.ballGame(41, board)));
        ReentrantLock lock = new ReentrantLock();
    }
}
