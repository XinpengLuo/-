package 面试真题.滴滴刷栅栏;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int[] begin = new int[n];
        int[] end = new int[n];
        int[] type = new int[n];
        for(int i = 0; i < begin.length; i++)
            begin[i] = scanner.nextInt();
        for(int i = 0; i < begin.length; i++)
            end[i] = scanner.nextInt();
        for(int i = 0; i < begin.length; i++)
            type[i] = scanner.nextInt();
        HashMap<Integer,Integer> mapP = new HashMap<>();
        HashMap<Integer,Integer> mapQ = new HashMap<>();
        for(int i = 0; i < n; i++){
            int l = begin[i];
            int r = end[i];
            int t = type[i];
            HashMap<Integer,Integer> map =  t == 1 ? mapP : mapQ;
            for(int j = l; j <= r; j++){
                map.put(j,map.getOrDefault(j,0) + 1);
            }
        }
        int count = 0;
        for (Integer key : mapP.keySet()) {
            int value = mapP.get(key);
            if(value < p)
                continue;
            int qValue = mapP.getOrDefault(key,0);
            if(qValue < q)
                continue;
            count++;
        }
//        for(int i = 1; i < bytesP.length; i++){
//            bytesP[i] = bytesP[i - 1] + bytesP[i];
//        }
        System.out.println(count);
    }
}
