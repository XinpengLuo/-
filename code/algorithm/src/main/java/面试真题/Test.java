package 面试真题;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] op = new int[m];
        for(int i = 0; i < m; i++)
            op[i] = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(i + 1);
        for(int i = 0; i < op.length; i++){
            int index = list.indexOf(op[i]);
            int temp = list.get(index);
            list.remove(index);
            list.add(0,temp);
        }
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}
