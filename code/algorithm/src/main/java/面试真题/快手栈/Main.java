package 面试真题.快手栈;

import java.util.*;
public class Main{

}
class FreqStack{
    PriorityQueue<int[]> queue;
    HashMap<Integer,int[]> map;
    int count = 0;
    public FreqStack(){
        queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t2[1] != t1[1])
                    return t2[1] - t1[1];
                return t2[2] - t1[2];
            }
        });
        map = new HashMap<>();
    }
    public void push(int val){
        int[] arr;
        if(map.containsKey(val))
            arr = map.get(val);
        else {
            arr = new int[]{val, 0, count};
            map.put(val,arr);
        }
        arr[1]++;
        arr[2] = count;
        count++;
        queue.add(arr);
    }
    public int pop(){
        if(queue.isEmpty())
            return -1;
        int[] arr = queue.poll();
        arr[1]--;
        queue.add(arr);
        return arr[0];

    }
}