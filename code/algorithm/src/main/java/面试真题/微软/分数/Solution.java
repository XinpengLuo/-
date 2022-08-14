package 面试真题.微软.分数;

import java.util.*;

public class Solution {
    public int findGcd(int a, int b){
        return b == 0 ? a : findGcd(b, a % b);
    }
    public int solution(int[] X, int[] Y) {
        // write your code in Java 11 (Java SE 11)
        long res = 0;
        int mod = (int) (Math.pow(10,9) + 7);
        HashMap<String,Long> map = new HashMap<>();
        int n = X.length;
        for(int i = 0; i < n; i++){
            int child = X[i];
            int parent = Y[i];
            if(parent < child)
                continue;
            if(child == 0){
                parent = 0;
            }
            else{
                int gcd = findGcd(child,parent);
                parent /= gcd;
                child /= gcd;
            }
            String temp = child + "/" + parent;
            map.put(temp,map.getOrDefault(temp, 0L) + 1);
        }
        for (String s : map.keySet()) {
            if(!map.containsKey(s))
                continue;
            long temp = map.get(s);
            if(temp == 0L)
                continue;
            if(s.equals("1/1") || s.equals("0/0")){
                Long target = map.getOrDefault("0/0",0L);
                temp = map.getOrDefault("1/1",0L);
                res = (res + temp * target) % mod;
                map.put("1/1",0L);
                map.put("0/0",0L);
            }
            else if(s.equals("1/2")){
                if(temp <= 1)
                    continue;
                res = (res + (temp - 1) * temp / 2) % mod;
                map.put(s, 0L);
            }
            else {
                int index = s.indexOf('/');
                int child = Integer.parseInt(s.substring(0,index));
                int parent = Integer.parseInt(s.substring(index + 1,s.length()));
                String str = (parent - child) + "/" + parent;
                if(!map.containsKey(str))
                    continue;
                Long target = map.get(str);
                map.put(str,0L);
                map.put(s,0L);
                res = (res + temp * target) % mod;
            }
        }
        return (int) (res % mod);
    }

    public static void main(String[] args) {
        int[] X = {1,2,3,1,2,12,8,4,16,1,1};
        int[] Y = {5,10,15,2,4,15,10,5,17,17,1};
        Solution solution = new Solution();
        System.out.println(solution.solution(X, Y));
    }
}
