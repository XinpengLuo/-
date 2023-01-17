package 面试真题.思科挑队员;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        HashMap<Integer,Character> map = new HashMap<>();
        boolean flag = true;
        while (map.size() != arr.length){
            Character c = flag ? 'A' : 'B';
            int max = -1, maxIndex = -1;
            for(int i = 0; i < arr.length; i++){
                if(map.containsKey(i))
                    continue;
                if(arr[i] > max){
                    max = arr[i];
                    maxIndex = i;
                }
            }
            for(int i = maxIndex, j = 0; i >= 0 && j < m + 1; i--){
                if(map.containsKey(i))
                    continue;
                j++;
                map.put(i,c);
            }
            for(int i = maxIndex + 1, j = 0; i < arr.length && j < m; i++){
                if(map.containsKey(i))
                    continue;
                j++;
                map.put(i,c);
            }
            flag = !flag;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++)
            sb.append(map.get(i));
        System.out.println(sb.toString());
    }
}