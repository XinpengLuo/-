package 面试真题.美团;
import java.util.*;
public class Main{
    static int count = 0;
    static int last = -1;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        count = n * m ;
        int len = scanner.nextInt();
        String commons = scanner.next();
        boolean[][] visted = new boolean[m][n];
        dfs(commons,0,visted,0,0);
        if(count == 0){
            System.out.println("Yes");
            System.out.println(last);
        }
        else
        {
            System.out.println("No");
            System.out.println(count);
        }
    }
    public static void dfs(String commons, int index, boolean[][] visted, int i, int j){
        if(count == 0)
        {
            last = index - 1;
            return;
        }
        if(index == commons.length())
            return;
        if(!visted[i][j]){
            count--;
            visted[i][j] = true;
        }
        char c = commons.charAt(index);
        if(c == 'W'){
            dfs(commons,index + 1,visted,i - 1, j);
        }else if(c == 'A'){
            dfs(commons,index + 1,visted,i, j - 1);
        }
        else if(c == 'S'){
            dfs(commons,index + 1,visted,i + 1, j);
        }
        else if(c == 'D'){
            dfs(commons,index + 1,visted,i, j + 1);
        }
    }
}