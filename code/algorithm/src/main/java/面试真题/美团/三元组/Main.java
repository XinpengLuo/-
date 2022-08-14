package 面试真题.美团.三元组;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        HashMap<Long,List<Long>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if(!map.containsKey(arr[i])){
                List<Long> temp = new ArrayList<>();
                map.put(arr[i],temp);
            }
            map.get(arr[i]).add((long) i);
        }
        for (Long integer : map.keySet()) {
            List<Long> list = map.get(integer);
            Collections.sort(list);
        }
        int count = 0;
        for(int i = 1; i < n - 1; i++){
            long target = 3 * arr[i];
            for(int j = 0; j < i; j++){
                long left = arr[j];
                long right = target - left;
                if(!map.containsKey(right))
                    continue;
                List<Long> list = map.get(right);
                count += bs(list,i);
            }
        }
        System.out.println(count);
    }
    public static long bs(List<Long> list, int i){
        int left = 0, right = list.size() - 1;
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) > i) {
                index = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        if(index == -1)
            return 0;
        return list.size() - index;
    }
}
