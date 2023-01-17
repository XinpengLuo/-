package 面试真题.蚂蚁除草;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] nums = new int[n][m];
        int[][] pre = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
                pre[i][j] = 1;
            }
        int o = scanner.nextInt();
        long ans = 0;

        while (o-- > 0){
            int time = scanner.nextInt();
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            int h = scanner.nextInt();
            for(int i = x - 2; i <= x + 2; i++)
                ans += check(nums,i,y,h,pre,time);
            for(int j = y - 2; j < y; j++)
                ans += check(nums,x,j,h,pre,time);
            for(int j = y + 1; j <= y + 2; j++)
                ans += check(nums,x,j,h,pre,time);
        }
        System.out.println(ans);
    }
    public static long check(int[][] nums, int i, int j, int h, int[][] pre, int t){
        if(i < 0 || j < 0 || i >= nums.length || j >= nums[i].length)
            return 0;
        nums[i][j] += t - pre[i][j];
        pre[i][j] = t;
        if(h >= nums[i][j]){
            int ans = nums[i][j];
            nums[i][j] = 0;
            return ans;
        }
        else{
            nums[i][j] -= h;
            return h;
        }
    }
}
