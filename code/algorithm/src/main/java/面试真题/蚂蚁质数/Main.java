package 面试真题.蚂蚁质数;

import java.util.*;
//质数 + 质数 --》 非质数    //质数 + 非质数 --〉 质数
public class Main {
    public static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        res.add(-1);
        int n = scanner.nextInt();
        List<Integer> isY = new ArrayList<>(); //质数集合
        List<Integer> isN = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isSNum(i)) {
                isY.add(i);
            } else {
                isN.add(i);
            }
        }
        dfs(new ArrayList<Integer>(),isY,isN,n, new HashSet<Integer>(),new HashSet<Integer>(),1);
        for (Integer re : res) {
            System.out.println(re + " ");
        }
    }

    public static boolean dfs(List<Integer> list, List<Integer> isY, List<Integer> isN, int n, HashSet<Integer> isYSet, HashSet<Integer> isNSet, int index) {
        if (list.size() == n) {
            res = new ArrayList<>(list);
            return true;
        }
        boolean flag = isSNum(index);
        if (flag) { //当前下标是质数 需要的另一半也要是质数
            if (isYSet.size() == isY.size())
                return false;
            for (int i = 0; i < isY.size(); i++) {
                if (isYSet.contains(isY.get(i)) || (index == 1 && isY.get(i) == 1))
                    continue;
                if(index + isY.get(i) == 3)
                    continue;
                isYSet.add(isY.get(i));
                list.add(isY.get(i));
                if (dfs(list, isY, isN, n, isYSet, isNSet, index + 1))
                    return true;
                isYSet.remove(isY.get(i));
                list.remove(list.size() - 1);
            }
        } else {
            if (isNSet.size() == isN.size())
                return false;
            for (int i = 0; i < isN.size(); i++) {
                if (isNSet.contains(isN.get(i)))
                    continue;
                isNSet.add(isN.get(i));
                list.add(isN.get(i));
                if (dfs(list, isY, isN, n, isYSet, isNSet, index + 1))
                    return true;
                isNSet.remove(isN.get(i));
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
    public static boolean isSNum ( int n){
        for (int i = 2; i <= n / 2; i++)
            if (n % 2 == 0)
                return false;
        return true;
    }
}