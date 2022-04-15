package 左神.贪心算法.单调递增的数字;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int i = 0;
        while (i < arr.length){
            if(flag)
                sb.append('9');
            else{
                if(i + 1 < arr.length && arr[i + 1] < arr[i]) {
                    flag = true;
                    int j = i;
                    while (j - 1 >= 0 && arr[j - 1] == arr[i])
                        {
                            sb.deleteCharAt(sb.length() - 1);
                            j--;
                        }

                    i = j;
                    sb.append((arr[i] - '1'));
                }
                else
                    sb.append(arr[i]);
            }
            i++;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(385 % 48);
        System.out.println(Math.pow(6,5) % 65);
        System.out.println(Math.pow(41,29));
        System.out.println(Math.pow(41, 29) % 65);
        Solution solution = new Solution();
        System.out.println('5');
        int num = 332;
        System.out.println(solution.monotoneIncreasingDigits(num));
    }
}
