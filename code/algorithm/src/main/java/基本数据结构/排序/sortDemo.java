package 基本数据结构.排序;

import java.util.Arrays;

public class sortDemo {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,1};
        sortTest sort = new sortTest();
        sort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
class sortTest
{
    //冒泡排序
    public void bubbleSort(int[] arr)
    {
        boolean flag = false;
        for(int i = 0; i < arr.length - 1; i++)
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
                if(!flag)
                    break;
                else
                    flag = false;
            }
    }
    //选择排序
    public void selectSort(int[] arr)
    {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
