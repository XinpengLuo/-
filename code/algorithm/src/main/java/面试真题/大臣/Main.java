package 面试真题.大臣;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), target = scanner.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                nums[i][j] = scanner.nextInt();
        int[] temp = nums[target - 1];
        int sum = 0;
        for (int i : temp) {
            sum += i;
        }
        int pre = 0;
        for(int i = 0; i < target - 1; i++){
            int[] num = nums[i];
            boolean flag = true;
            for(int j = 0; j < num.length; j++)
                if(num[j] != temp[j]){
                    flag = false;
                    break;
                }
            if(flag)
                pre++;
        }
        Arrays.sort(nums, (t1, t2) -> {
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i < t1.length; i++){
                sum1 += t1[i];
                sum2 += t2[i];
            }
            if(sum2 == sum1)
                return 1;
            return sum2 - sum1;
        });
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            boolean flag = true;
            for(int j = 0; j < temp.length; j++)
                if(temp[j] != nums[i][j]) {
                    flag = false;
                    break;
                }
            if(flag){
                if(pre == 0) {
                    ans = i;
                    break;
                }
                pre--;
            }
        }
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
        System.out.println(ans + 1);
    }
}