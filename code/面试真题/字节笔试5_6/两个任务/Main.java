package 面试真题.字节笔试5_6.两个任务;

public class Main {
    public int getAnswer(int[][] arr, int time){
        int ans = 0;
        int[] max = new int[arr.length];
        int temp = -1;
        for(int i = 0; i < arr.length; i++){
            temp = Math.max(temp,arr[i][1]);
            max[i] = temp;
        }
        for(int i = arr.length - 1; i >= 0; i--){
            int left = binarySearch(arr,0,i - 1,time - arr[i][0]);
            if(left == -1)
                continue;
            ans = Math.max(ans,arr[left][1] + arr[i][1]);
        }
        return ans;
    }
    public int binarySearch(int[][] arr, int left, int right, int target){
        int res = -1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(arr[middle][0] <= target){
                res = middle;
                left = middle + 1;
            }
            else
                right = middle - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1},{1,1},{1,1},{1,1},{1,4001},{1,31},{1,1},{1,1},{1,1}};
        Main main = new Main();
        System.out.println(main.getAnswer(arr, 20));
    }
}
