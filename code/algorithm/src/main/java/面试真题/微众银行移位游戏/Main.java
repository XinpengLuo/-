package 面试真题.微众银行移位游戏;

import java.util.*;

public class Main {
    static HashMap<String,Long> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            if(a == b)
            {
                System.out.println(0);
                continue;
            }
            long num = Math.min(a,b);
            long target = Math.max(a,b);
            long count = 0;
            String key = num + "_" + target;
            if(map.containsKey(key))
                count = map.get(key);
            else{
                count = dfs(num,target);
                map.put(key,count);
            }
            if(count >= Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(count);


        }
    }
    public static long dfs(long num, long target){
        if(num == target)
            return 0;
        if(num > target)
            return Integer.MAX_VALUE;
        String key = num + "_" + target;
        if(map.containsKey(key))
            return map.get(key);
        long res = Integer.MAX_VALUE;
        if(target % 8 == 0) {
            long temp = 0;
            String tempKey = num + "_" + target / 8;
            if(map.containsKey(tempKey))
                temp = map.get(tempKey);
            else
            {
                temp =  dfs(num, target / 8);
                map.put(tempKey,temp);
            }
            res = Math.min(res, 1 + temp);
        }
        if(target % 4 == 0) {
            long temp = 0;
            String tempKey = num + "_" + target / 4;
            if(map.containsKey(tempKey))
                temp = map.get(tempKey);
            else
            {
                temp =  dfs(num, target / 4);
                map.put(tempKey,temp);
            }
            res = Math.min(res, 1 + temp);
        }
        if(target % 2 == 0) {
            long temp = 0;
            String tempKey = num + "_" + target / 2;
            if(map.containsKey(tempKey))
                temp = map.get(tempKey);
            else
            {
                temp =  dfs(num, target / 2);
                map.put(tempKey,temp);
            }
            res = Math.min(res, 1 + temp);
        }
        map.put(key,res);
        return res;
    }

}
