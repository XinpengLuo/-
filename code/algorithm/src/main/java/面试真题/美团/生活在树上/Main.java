package 面试真题.美团.生活在树上;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nodes = new int[n];
        for(int i = 0; i < n; i++)
            nodes[i] = scanner.nextInt();
        System.out.println(dfs(nodes,1));
    }
    public static int dfs(int[] arr, int index){
        if(index > arr.length)
            return 0;
        int res = Math.max(dfs(arr,index * 2),dfs(arr,index * 2 + 1));
        return res + arr[index - 1];
    }
}
