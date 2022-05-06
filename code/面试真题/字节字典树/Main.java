package 面试真题.字节字典树;

import java.util.Scanner;

public class Main {
    //输入n 代表要判断n次
    //输入x 代表此次要判断x个数字
    //输入x个数字
    public static boolean getAnswer(String[] arr){
        Trie root = new Trie();
        for (String s : arr) {
            root.insert(s);
        }
        for(String s : arr){
            if(root.isStartWith(s))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int x = scanner.nextInt();
            String[] temp = new String[x];
            for(int j = 0; j < temp.length; j++)
                temp[j] = scanner.next();
            if(getAnswer(temp))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
class Trie{
    Trie[] children;
    public Trie(){
        children = new Trie[10];
    }
    public void insert(String word){
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - '0';
            if(node.children[index] == null)
                node.children[index] = new Trie();
            node = node.children[index];
        }
    }
    public boolean isStartWith(String prefix){
        Trie node = this;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - '0';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }
}
