package 面试真题.蚂蚁孤独数;

//1 2 2 3 3 4 4
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        int left = 0, right = 10000;
        Arrays.sort(arr);
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(check(arr,k,mid)){
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        System.out.println(ans);
    }
    public static boolean check(int[] arr, int k, int t){
        HashSet<Integer> set = new HashSet<>();
        int index = arr.length - 1;
        while (index >= 0){
            set.add(arr[index]);
            while (index - 1 >= 0 && arr[index - 1] == arr[index]){
                if(t == 0)
                    return false;
                int count = 1;
                while (set.contains(arr[index - 1] + count * k))
                    count++;
                if(count > t)
                    return false;
                t -= count;
                set.add(arr[index - 1] + count * k);
                index--;
            }
            index--;
        }
        return true;
    }
}