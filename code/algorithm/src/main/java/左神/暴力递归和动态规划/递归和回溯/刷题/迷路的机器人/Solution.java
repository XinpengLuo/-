package 左神.暴力递归和动态规划.递归和回溯.刷题.迷路的机器人;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            help(obstacleGrid,0,0,new ArrayList<>());
            return res;
    }
    public void help(int[][] arr, int i, int j, List<List<Integer>> list){
        if(i >= arr.length || j >= arr[0].length || arr[i][j] == 1)
            return;
        List<Integer> temp = new ArrayList<>();
        temp.add(i);
        temp.add(j);
        list.add(temp);
        arr[i][j] = 1;
        if(i == arr.length - 1 && j == arr[0].length - 1)
            res = new ArrayList<>(list);
        help(arr,i + 1,j,list);
        list.remove(list.size() - 1);
        list.add(temp);
        help(arr,i,j + 1,list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution.pathWithObstacles(arr));
    }
}
