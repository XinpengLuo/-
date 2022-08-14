package 面试真题.微软.病人治疗;

public class Solution {
    int inf = (int) Math.pow(10,9);
    public int solution(int[] A, int X, int Y) {
        // write your code in Java 11 (Java SE 11)
        //A次治疗 y天之后
       int[] count = new int[A.length];
       for(int i = count.length - 1; i >= 0; i--){
           if(i + Y < count.length)
               count[i] = A[i] + count[i + Y];
           else
               count[i] = A[i];
       }
       int res = Integer.MAX_VALUE;
       for(int i = 0; i < count.length; i++){
           if(i + (X - 1) * Y < count.length){
               res = Math.min(res,count[i] - count[i + (X - 1) * Y] + A[i + (X - 1) * Y]);
           }
           else
               break;
       }
       return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,1,4,1,5,1,4,2,7};
        Solution solution = new Solution();
        System.out.println(solution.solution(arr, 3, 2));
    }
}
