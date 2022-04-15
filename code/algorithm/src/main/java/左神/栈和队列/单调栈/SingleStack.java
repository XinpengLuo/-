package 左神.栈和队列.单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//求一个数组的每个
public class SingleStack {
    //求一个数组中每个数字左右离它最近比他大的元素
    // key 数组的下标 value 左边比他大的下标
    public HashMap<Integer,Integer> mapLeft = new HashMap<>();
    // key 数组的下标 value 右边比他大的下标
    public HashMap<Integer,Integer> mapRight = new HashMap<>();
    //打印数组的左右两边最近的最大的
    public void showMaxLeast(){
        SingleStack singleStack = new SingleStack();
        int[] arr = {2,4,3,1,5};
        singleStack.leastNumber(arr);
        for (Map.Entry<Integer, Integer> entry : singleStack.mapLeft.entrySet()) {
            if(entry.getValue() != null)
                System.out.println(arr[entry.getKey()] + " " + arr[entry.getValue()]);
            else
                System.out.println(arr[entry.getKey()] + " " + "null");
        }
        System.out.println();
        for (Map.Entry<Integer, Integer> entry : singleStack.mapRight.entrySet()) {
            if(entry.getValue() != null)
                System.out.println(arr[entry.getKey()] + " " + arr[entry.getValue()]);
            else
                System.out.println(arr[entry.getKey()] + " " + "null");
        }
    }
    public void leastNumber(int[] arr){
        //栈维持从大大小的顺序
        Stack<Integer> stack = new Stack<>();
        int topIndex, i = 0;
        while (i != arr.length) {
            //如果栈为空 或者 栈顶元素大于 新元素 直接入栈 这里先不考虑相等的情况
            if(stack.isEmpty() || arr[stack.peek()] > arr[i]){
                stack.push(i); //这里操作的都是下标
                i = i + 1;
                continue;
            }
            //否则新来的肯定比栈顶要大 将其弹出
            topIndex = stack.pop();
            mapRight.put(topIndex,i);
            if(!stack.isEmpty())
                mapLeft.put(topIndex,stack.peek());
            else
                mapLeft.put(topIndex,null);
        }
        while (!stack.isEmpty()){
            topIndex = stack.pop();
            if(!stack.isEmpty())
                mapLeft.put(topIndex,stack.peek());
            else
                mapLeft.put(topIndex,null);
            mapRight.put(topIndex,null);
        }
    }
    //单调栈求直方图中最大矩形的个数
    public static int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - k - 1) * height[j];
                maxArea = Math.max(area,maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int area = (height.length - k - 1) * height[j];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    //单调栈求二位矩阵中最大的矩形面积 矩阵中要么为0 要么为1
    public static int maxMatrixArea(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                height[j] = matrix[i][j] == 0 ? 0 : height[j] + matrix[i][j];
            }
            maxArea = Math.max(maxArea,maxRecFromBottom(height));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] map = {2,1,5,6,2,3};
        System.out.println(maxRecFromBottom(map));
    }
}
