package 面试真题.快手栈;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if(n != 0)
                freqStack.push(n);
            else
                System.out.println(freqStack.pop());
        }
    }
}
class FreqStack{
    PriorityQueue<int[]> queue;
    HashMap<Integer,int[]> map;
    HashMap<Integer,List<Integer>> number;
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
        number = new HashMap<>();
    }
    public void push(int val){
        int[] arr;
        if(map.containsKey(val)) {
            arr = map.get(val);
            arr[2] = count;
            arr[1]++;
            queue.add(queue.poll());
            number.get(val).add(count);
        }
        else {
            arr = new int[]{val, 1, count};
            map.put(val,arr);
            queue.add(arr);
            List<Integer> list = new ArrayList<>();
            list.add(count);
            number.put(val, list);
        }
        count++;
    }
    public int pop(){
        if(queue.isEmpty())
            return -1;
        int[] arr = queue.poll();
        arr[1]--;
        if(arr[1] != 0) {
            List<Integer> list = number.get(arr[0]);
            list.remove(list.size() - 1);
            arr[2] = list.get(list.size() - 1);
            queue.add(arr);
        }
        else {
            map.remove(arr[0]);
            number.remove(arr[0]);
        }
        return arr[0];

    }
}