package 左神.栈和队列.单调栈.山峰队;

import javafx.scene.chart.ValueAxis;

import java.util.Stack;

class Pair{
    int time; //出现的次数
    int value; //值
    public Pair(int value){
        this.value = value;
        this.time = 1;
    }
}
public class Communication {
    //求C(2,k)的排列组合
    public int getInternalSum(int k){
        return k == 1 ? 0 : k * (k - 1) / 2;
    }
    //环形数组求下标
    public int getNextIndex(int size, int index){
        return index + 1 == size ? 0 : index + 1;
    }
    public int getPairs(int[] arr){
        //维持一个从大到小的栈
        Stack<Pair> stack = new Stack<>();
        //找到整个数组的最大值 为什么呢？
        int maxValue = 0;
        int maxIndex = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxValue){
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        stack.push(new Pair(maxValue));
        int index = getNextIndex(arr.length,maxIndex);
        while (index != maxIndex){
            int value = arr[index];
            //这里为什么要判断栈不为空呢 因为
            while (stack.peek().value < value){
                int time = stack.pop().time;
                result = result + getInternalSum(time) + 2 * time;
            }
            if(stack.peek().value == value)
                stack.peek().time++;
            else
                stack.push(new Pair(value));
            index = getNextIndex(arr.length,index);
        }
        while (!stack.isEmpty()){
            int time = stack.pop().time;
            //先计算相等的之间山峰 等会再讨论相等的山峰如何看到比他们大的
            result += getInternalSum(time);
            if(!stack.isEmpty()){ //可能来到了最后一个 那么就不进来
                result += time; //最大的可能为1
                if(stack.size() > 1)
                    result += time;
                else
                    result += stack.peek().time > 1 ? time : 0;
            }
        }
        return result;
    }
}
