package 笔试.第三题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    ArrayList<Node> list = new ArrayList<Node>();
    int[] day = {31, 28, 31, 30, 31,30,31,31,30,31,30,31};
    HashSet<String> set = new HashSet<String>();
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while(scanner.hasNext())
       {
            String temp = scanner.nextLine();
            System.out.println(temp);
            String[] split = temp.split(" ");
            if(split[0].equals("1")){
                main.insertData(split);
            }
            else if(split[0].equals("2")){
                main.getCount(split);
            }
            else if(split[0].equals("3")){
                main.getDate(split[1]);
            }
            else{
                System.out.println("error");
            }
        }
    }
    public boolean check(int y, int m, int d){
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            day[1] = 29;
        if(day[m - 1] != d || y < 2022 || y > 9999){
            return false;
        }
        return true;
    }
    public void getCount(String[] split) {
        int y = Integer.parseInt(split[1]);
        int m = Integer.parseInt(split[2]);
        int d = Integer.parseInt(split[3]);
        if(!check(y,m,d))
            System.out.println("error");
        int res = 0;
        for (Node node : list) {
            if(node.y == y && node.m == m && node.d == d)
                res++;
        }
        System.out.println(res);
    }
    public String getDate(String s){
        if(!set.contains(s))
            System.out.println("not existed");
        int y = 0, m = 0, d = 0;
        for (Node node : list) {
            if(node.msg.equals(s)){
                y = node.y;
                m = node.m;
                d = node.d;
            }
        }
        return y + "/" + m + "/" + d;
    }
    public void insertData(String[] split){
        int y = Integer.parseInt(split[1]);
        int m = Integer.parseInt(split[2]);
        int d = Integer.parseInt(split[3]);
        String msg = split[4];
        if(set.contains(msg))
            System.out.println("existed");
        if(!check(y,m,d))
            System.out.println("error");
        Node node = new Node(y, m, d, msg);
        set.add(msg);
        list.add(node);
        System.out.println("done");
    }
}
class Node{
    int y;
    int m;
    int d;
    String msg;
    public Node(int y, int m, int d, String msg){
        this.y = y;
        this.m = m;
        this.d = d;
        this.msg = msg;
    }
}
