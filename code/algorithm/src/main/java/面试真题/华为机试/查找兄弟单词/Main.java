package 面试真题.华为机试.查找兄弟单词;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String[] arr = new String[n];
            for(int i = 0; i < arr.length; i++)
                arr[i] = scanner.next();
            String target = scanner.next();
            char[] targetChar = target.toCharArray();
            Arrays.sort(targetChar);
            String newTarget = new String(targetChar);
            int k = scanner.nextInt();
            List<String> list = new ArrayList<>();
            for (String s : arr) {
                if(s.length() != target.length() || s.equals(target))
                    continue;
                char[] temp = s.toCharArray();
                Arrays.sort(temp);
                if(new String(temp).equals(newTarget)){
                    list.add(s);
                }
            }
            if(list.size() >= k){
                Collections.sort(list);
                System.out.println(list.size());
                System.out.println(list.get(k - 1));
            }
        }
    }
}
