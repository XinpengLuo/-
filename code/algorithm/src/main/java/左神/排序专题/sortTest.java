package 左神.排序专题;

import java.util.ArrayList;
import java.util.Arrays;

public class sortTest {
    public static void main(String[] args) {
        System.out.println(-1 / 2 );
    }


}
class HeapSort{
    //加堆操作
    public static void heapInsert(int[] arr, int index){
        //对于一颗完全二叉树 他的父节点的索引值 为 index - 1 / 2
        while(arr[index] > arr[(index - 1) / 2 ]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    //减堆操作 默认是从堆顶元素弹出
    public static void heapPopTop(int[] arr, int heapTopIndex, int heapSize){
        //为什么是堆顶元素和堆的最后一个元素交换而不是和堆里的任何一个元素交换呢？
        //因为弹出后堆的大小就要-1 如果是和其他元素交换再减去 那么最后个元素就会被排出去了
        //如果先序列化再减去 那么又把交换前的堆顶元素给换回去了
        swap(arr,heapTopIndex, heapSize);
        heapFy(arr,heapTopIndex,--heapSize);
    }
    //此情况为大顶堆 然后index下标的值发生了变小
    public static void heapFy(int[] arr, int index, int heapSize){
        int left = 2 * index + 1;
        while(left < heapSize){
            int larget = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            larget = arr[larget] > arr[index] ? larget : index;
            if(larget == index)
                break;
            swap(arr,larget,index);
            index = larget;
            left = 2 * index + 1;
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void heapSort(int[] arr){
        int heapSize = arr.length;
        //1 首先将这个数组构成大顶堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        while (heapSize != 1){
            swap(arr,0,heapSize - 1);
            heapSize--;
            heapFy(arr,0,heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,5,5,4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}