package 主要练习.二分总结.有序矩阵中的第k个最小数组和;

public class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int res = 0;
        int left = 0, right = 0;
        for(int i = 0; i < mat.length; i++) {
            left += mat[i][0];
            right += mat[i][mat[0].length - 1];
        }
        if(k == 1)
            return left;
        int intiSum = left;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(dfs(mat,mid,0,intiSum,k) >= k){
                right = mid - 1;
                res = mid;
            }
            else
                left = mid + 1;
        }
        return res;
    }
    //返回小于等于 target的数组有多少个
    public int dfs(int[][] mat, int target, int index, int sum, int k){

        if(index == mat.length){
            if(sum <= target)
                return 1;
            return 0;
        }
        if(k < 0)
            return 10000;
        int res = 0;
        for(int i = 0; i < mat[index].length; i++) {
            if (sum + mat[index][i]- mat[index][0] > target)
                return res;
            else {
                int temp = (dfs(mat, target, index + 1, sum + mat[index][i] - mat[index][0], k));
                res += temp;
                k -= temp;
                if(k <= 0)
                    return 10000;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {2,7,8,11,15,35},
                {11,21,38,41,47,47},
                {5,11,26,32,40,40},
                {7,11,21,41,45,48},
                {13,20,25,33,45,49}};
        System.out.println(solution.kthSmallest(arr, 30));
    }
}
