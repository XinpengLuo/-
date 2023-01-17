package 面试真题.美团.裁缝;

import java.util.*;

public class Main {
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int n = scanner.nextInt();
        String clo = scanner.next();
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += scanner.nextInt();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = scanner.next();
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        if(sum > len)
            System.out.println(0);
        else{
            dfs(clo,0,clo.length() - 1,map);
            System.out.println(res);
        }

    }
    public static void dfs(String clo, int start, int end, HashMap<String,Integer> map){
        if(start > end)
        {
            if(map.size() == 0)
                res++;
        }
        for(int i = start; i <= end; i++){
            String left = clo.substring(start,i + 1);
            if(map.containsKey(left)){
                int count = map.get(left);
                map.put(left,count - 1);
                if(map.get(left) == 0)
                    map.remove(left);
                dfs(clo,i + 1, end,map);
                map.put(left,count);
            }
        }
    }
}
