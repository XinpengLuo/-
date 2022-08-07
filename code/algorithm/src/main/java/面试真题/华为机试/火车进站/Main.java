package 面试真题.华为机试.火车进站;

import java.util.*;

public class Main {
    List<List<Integer>> res = new ArrayList<>();
    public void dfs(List<Integer> stack,List<Integer> list, int[] arr,int index, int n){
        if(index >= n){
            List<Integer> temp = new ArrayList<>(list);
            for(int i = stack.size() - 1; i >= 0; i--)
                temp.add(stack.get(i));
            res.add(new ArrayList<>(temp));
            return;
        }
        //当一辆火车来的的时候可以 选择直接入尾部 或者弹出
        stack.add(arr[index]);
        dfs(stack,list,arr,index + 1,n); // --> 直接入尾
        stack.remove(stack.size() - 1);
        //出一个
        if(!stack.isEmpty())
        {
            Integer temp = stack.remove(stack.size() - 1);
            list.add(temp);
            dfs(stack,list,arr,index,n);
            stack.add(temp);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        main.dfs(new ArrayList<Integer>(),new ArrayList<Integer>(),arr,0,n);
        Collections.sort(main.res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> t1, List<Integer> t2) {
                for(int i = 0; i < t1.size(); i++)
                    if(t1.get(i) != t2.get(i))
                        return t1.get(i) - t2.get(i);
                return 0;
            }
        });
        for (List<Integer> re : main.res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
