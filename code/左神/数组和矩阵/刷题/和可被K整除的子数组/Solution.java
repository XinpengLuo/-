package 左神.数组和矩阵.刷题.和可被K整除的子数组;

import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int temp = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            temp += nums[i];
            int mod = (temp % k + k) % k;
            res += map.getOrDefault(mod % k,0);
            map.put(mod % k,map.getOrDefault(mod % k,0) + 1);
        }
        return res;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        HashMap<Long,Long> map = new HashMap<>();
        map.put(0l,1l);
        long res = 0;
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            long mod = (sum % k + k) % k;
            res += map.getOrDefault(mod,0l);
            map.put(mod,map.getOrDefault(mod,0l) + 1);
        }
        System.out.println(res);
    }
}