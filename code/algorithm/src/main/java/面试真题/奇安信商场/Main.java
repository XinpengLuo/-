package 面试真题.奇安信商场;

import java.util.*;

public class Main {
    static long res = Long.MAX_VALUE;
    public static void main(String[] args) {
        long sum = 111;
        sum = (long) (sum * 0.6);
        System.out.println(sum);
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.next().split(",");
        String[] b = scanner.next().split(",");
        long[] A = new long[a.length];
        long[] B = new long[b.length];
        for(int i = 0; i < a.length; i++){
            A[i] = Long.parseLong(a[i]);
            B[i] = Long.parseLong(b[i]);
        }
        dfs(A,B,0,new ArrayList<>(), new ArrayList<>());
        System.out.println(res);
    }
    public static void dfs(long[] a, long[] b, int index, List<Long> listA, List<Long> listB){
        if(index == a.length){
            long sumA = 0, sumB = 0;
            for (Long integer : listA)
                sumA += integer;
            if(listA.size() >= 3)
                sumA = (long) (sumA * 0.6);
            for (Long integer : listB) {
                sumB += integer;
            }
            if(listB.size() >= 3){
                List<Long> temp = new ArrayList<>(listB);
                int n = listB.size() / 3;
                Collections.sort(temp);
                for(int i = 0; i < n; i++)
                    sumB -= temp.get(i);
            }
            res = Math.min(res,sumA + sumB);
            return;
        }
        //在a这里买
        listA.add(a[index]);
        dfs(a,b,index + 1,listA,listB);
        listA.remove(listA.size() - 1);
        //在b这里买

        listB.add(b[index]);
        dfs(a,b,index + 1,listA,listB);
        listB.remove(listB.size() - 1);
    }
}
