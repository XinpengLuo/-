package 面试真题.深信服子数组查找;

import java.util.*;
public class Main{
    public static int getAnswer(int[] arr, HashSet<Integer> set){
        HashMap<Integer,Integer> temp = new HashMap<>();
        int j = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i]))
                temp.put(arr[i],temp.getOrDefault(arr[i],0) + 1);
            while(set.size() == temp.size()){
                ans = Math.min(i - j + 1, ans);
                if(temp.containsKey(arr[j]))
                {
                  if(temp.get(arr[j]) == 1)
                      temp.remove(arr[j]);
                  else
                      temp.put(arr[j],temp.get(arr[j]) - 1);
                }
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int length = scanner.nextInt();
            int[] arr = new int[length];
            for(int j = 0; j < length; j++)
                arr[j] = scanner.nextInt();
            int count = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int k = 0; k < count; k++)
                set.add(scanner.nextInt());
            System.out.println(getAnswer(arr,set));
        }
}
}
