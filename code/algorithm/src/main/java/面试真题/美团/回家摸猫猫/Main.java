package 面试真题.美团.回家摸猫猫;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int thing = scanner.nextInt();
        int n = scanner.nextInt();
        int time = scanner.nextInt();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int value = scanner.nextInt();
            map.put(i + 1, value); //第一种道具的花费时间
        }
        long res = 0;
        for(int i = 0; i < thing; i++){
            int temp = scanner.nextInt();
            if(temp != 0){
                int value = map.get(temp);
                treeMap.put(value,treeMap.getOrDefault(value, 0) + 1); //花费时间为value的道具有多少个
            }
            else{
                if(treeMap.size() == 0 || treeMap.firstKey() >= time)
                    res += time;
                else{

                        res += treeMap.firstKey();
                        treeMap.put(treeMap.firstKey(),treeMap.get(treeMap.firstKey()) - 1);
                        if(treeMap.get(treeMap.firstKey()) == 0)
                            treeMap.remove(treeMap.firstKey());


                }
            }
        }
        System.out.println(res);
    }
}
