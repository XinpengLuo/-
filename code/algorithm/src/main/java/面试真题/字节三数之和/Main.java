package 面试真题.字节三数之和;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0){
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for(int i = 0; i < arr.length; i++)
                arr[i] = scanner.nextInt();
            int count = 0;
            HashSet<String> set = new HashSet<>();
            Arrays.sort(arr);
            for(int k = 0; k < arr.length; k++){
                int target = arr[k];
                for(int i = 0; i < arr.length; i++){
                    int temp = target - arr[i];
                    int left = i + 1, right = arr.length - 1;
                    while(left < right){
                            if(arr[left] == arr[right] && arr[left] + arr[right] == temp){
                                int x = right - left + 1;
                                count += (x - 1) * (x - 2) / 2;

                                break;
                            }
                            else{
                                int sum = arr[left] + arr[right];
                                if(sum == temp){
                                    int leftVal = arr[left], rightVal = arr[right];
                                    int leftCount = 0, rightCount = 0;
                                    while(left + 1 < right && arr[left] == leftVal)
                                    {
                                        leftCount++;
                                        left++;
                                    }
                                    while(right - 1 > left && arr[right] == rightVal)
                                    {
                                        rightCount++;
                                        right--;
                                    }
                                    count += leftCount * rightCount;
                                    left++;
                                    right--;
                                }
                                else if(sum < temp)
                                    left++;
                                else
                                    right--;
                            }

                        }


                }
            }
            System.out.println(count+ " " + len * (len - 2) * (len - 1) / 6);
            if(count == (len * (len - 2) * (len - 1) / 6))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}