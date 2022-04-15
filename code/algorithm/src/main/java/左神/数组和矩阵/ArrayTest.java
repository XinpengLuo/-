package 左神.数组和矩阵;

import com.sun.source.doctree.StartElementTree;

import java.util.*;

public class ArrayTest {
    //螺旋打印矩阵
    public static void spiralOrder(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;
        while (tR <= bR && tC <= bC){
            spiralOrderPrint(matrix,tR++,tC++,bR--,bC--);
        }
    }
    public static void spiralOrderPrint(int[][] matrix, int tR, int tC, int bR, int bC){
        int curR = tR;
        int curC = tC;
        if(tR == bR){
            while (tC <= bC)
                System.out.println(matrix[tR][tC++]);
        }
        else if(tC == bC){
            while (tR <= bR)
                System.out.println(matrix[tR++][tC]);
        }
        else{
            while (curC < bC)
                System.out.println(matrix[curR][curC++]);
            while (curR < bR)
                System.out.println(matrix[curR++][curC]);
            while (curC > tC)
                System.out.println(matrix[curR][curC--]);
            while (curR > tR)
                System.out.println(matrix[curR--][curC]);
        }
    }
    //将矩阵顺时针旋转90度
    public static void rotate(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[1].length - 1;
        while (tR <= dR && tC <= dC){
            rotateOperate(matrix,tR++,tC++,dR--,dC--);
        }
    }
    private static void rotateOperate(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int temp = 0;
        for (int i = 0; i < times; i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }
    //之字型打印矩阵
    private static void printByZhiOperate(int[][] m, int aR,int aC, int bR,int bC,boolean flag){
        if(flag){
            while (aR <= bR)
                System.out.println(m[aR++][aC--]);
        }
        else {
            while (aR <= bR)
                System.out.println(m[bR--][bC++]);
        }
    }
    public static void printByZhi(int[][] matrix){
        int aR = 0, aC = 0, bR = 0, bC = 0;
        boolean flag = true;
        while (aR < matrix.length){
            printByZhiOperate(matrix,aR,aC,bR,bC,flag);
            if(aC + 1 < matrix[0].length)
                aC = aC + 1;
            else
                aR = aR + 1;
            if(bR + 1 < matrix.length)
                bR = bR + 1;
            else
                bC = bC + 1;
            flag = !flag;
        }
    }
    //行和列都排序好的矩阵 找一个数字
    public static boolean findNumInSortMat(int[][] matrix, int num){
        boolean flag = false;
        //从右上角开始走
        int row = 0, col = matrix[0].length - 1;
        while (!flag && row < matrix.length && col >= 0){
            if(matrix[row][col] < num)
                row++;
            else if(matrix[row][col] > num)
                col--;
            else
                flag = true;
        }
        return flag;
    }
    //删除排序数组中的重复项 II
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;
        while(i < length){
            int count = 1;
            int j = i + 1;
            int temp = i;
            while(j < length && nums[j] == nums[i]){
                count++;
                j = j + 1;
            }
            if(count > 2){
                i = i + 2;
                length = length - (count - 2);
            }else
                i++;
            while(count-- > 2){
                for(int k = temp; k < nums.length - 1; k++)
                    nums[k] = nums[k + 1];
            }
        }
        return i;
    }
    //不同路径
    int uniqueCount = 0;
    public int uniquePaths(int m, int n) {
        uniquePathsHelp(0,0,m,n);
        return uniqueCount;
    }
    public void uniquePathsHelp(int i, int j, int m, int n){
        if(i >= m || j >= n)
            return;
        if(i == m - 1 && j == n - 1){
            uniqueCount++;
            return;
        }
        uniquePathsHelp(i + 1,j,m,n);
        uniquePathsHelp(i,j + 1, m,n);
    }
    //第 k 个缺失的正整数
    public static int findKthPositive(int[] arr, int k) {
        int countIndex = 0;
        int arrIndex = 0;
        int startNum = 0;
        while (countIndex < k){
            startNum++;
            if(arrIndex <= arr.length - 1 && arr[arrIndex] == startNum)
                arrIndex++;
            else
                countIndex++;
        }
        return startNum;
    }
    //全排列
    List<List<Integer>> permuteResult = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permuteResultHelp(nums,0,new ArrayList<>());
        return permuteResult;
    }
    public void permuteResultHelp(int[] nums,int i, List<Integer> temp){
        if(i == nums.length){
            permuteResult.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if(!temp.contains(num)){
                temp.add(num);
                permuteResultHelp(nums,i + 1,temp);
                temp.remove(temp.size() - 1);
            }

        }
    }

    //全排列2
    HashSet<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        permuteUniqueHelp(nums,0,new ArrayList<Integer>(),flags);
        return new ArrayList<>(ans);
    }
    public void permuteUniqueHelp(int[] nums,int i,List<Integer> temp, boolean[] flags) {
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(!flags[j]){
                flags[j] = true;
                temp.add(nums[j]);
                permuteUniqueHelp(nums,i + 1,temp,flags);
                temp.remove(temp.size() - 1);
                flags[j] = false;
            }
        }
    }
    //求累加和为target的最长子数组
    public int getLongestArray(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>(); //key sum 和 value 最早出现的位置
        int sum = 0;
        int length = 0;
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int temp = sum - target;
            // 如果前面有累加和为 差的
            if(map.containsKey(temp)){
                length = Math.max(length,i - map.get(temp));
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return length;
    }

    public int arrangeCoins(int n) {
        int index = 1;
        long tempSum = 0;
        if(n == 1)
            return 1;
        for(index = 1; index < n; index++){
            tempSum += index;
            if(tempSum > n)break;
        }
        return index - 1;
    }

    //四数之和
    HashSet<List<Integer>> fourSumRes = new HashSet<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        forSumHelp(nums,0,new ArrayList<Integer>(),target,0,0);
        return new ArrayList<>(fourSumRes);
    }
    public void forSumHelp(int[] nums,int index,List<Integer> list,int target,int tempSum,int count){
        if(index + 4 - count > nums.length)
            return;
        if(count == 4){
            if(list.size() == 4 && target == tempSum )
                fourSumRes.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                forSumHelp(nums,i + 1,list,target, tempSum + nums[i],count + 1);
                list.remove(list.size() - 1);
            }
        }


    //二进制求和
    public String addBinary(String a, String b) {
        Integer left = Integer.parseInt(a, 2);
        Integer right = Integer.parseInt(b, 2);
        return Integer.toBinaryString(left + right);
    }
    public static void main(String[] args) {
        int[] test = {1,1,2};
        ArrayTest arrayTest = new ArrayTest();
        System.out.println(arrayTest.bulbSwitch(1));
    }
    //灯泡开关
    public int bulbSwitch(int n) {
        boolean[] flags = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for(int j = -1; j + i < flags.length;){
                j = j + i;
                flags[j] = !flags[j];
            }
        }
        int count = 0;
        for (boolean flag : flags) {
            if(flag)
                count++;
        }
        return count;
    }


}
