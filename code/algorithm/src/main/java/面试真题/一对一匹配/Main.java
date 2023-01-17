package 面试真题.一对一匹配;

import java.util.*;

public class Main {
    static HashMap<Integer,List<Integer>> map = new HashMap<>();
    static int res = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n - 1];
        for(int i = 0; i < nums.length; i++)
            nums[i] = scanner.nextInt();
        for(int i = 0; i < nums.length; i++){
            int parent = nums[i], child = i + 2;
            if(parent > child){
                int temp = parent;
                parent = child;
                child = temp;
            }
            if(map.containsKey(parent))
                map.get(parent).add(child);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(child);
                map.put(parent,list);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);
        dfs(list,0);
        System.out.println(res);
    }
    public static void dfs(List<Integer> list, int temp){
        res = Math.max(temp,res);
        if(list.size() == 0 || list.size() == 1)
            return;
        for(int i = 0; i < list.size(); i++){
            int parent = list.get(i);
            list.remove(i);
            List<Integer> child = map.get(parent);
            if(child != null){
                for(int j = 0; j < child.size(); j++){
                    if(!list.contains(child.get(j)))
                        continue;
                    int childNode = child.get(j);
                    int childIndex = list.indexOf(childNode);
                    list.remove(childIndex);
                    dfs(list,temp + 1);
                    list.add(childIndex,childNode);
                }
            }
            list.add(i,parent);
        }
    }
}
