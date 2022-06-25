package 面试真题.华为机试.从单向链表中删除指定值的节点;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
//6 2 1 2 3 2 5 1 4 5 7 2 2
//则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        Node head = new Node(Integer.valueOf(str[1]));
        for(int i = 0; i < Integer.valueOf(str[0]) - 1; i++){
            int newVal = Integer.valueOf(str[2 * i + 2]);
            int targetVal = Integer.valueOf(str[2 * i + 3]);
            Node temp = head;
            while (temp != null){
                if(temp.val == targetVal){
                    Node node = new Node(newVal);
                    node.next = temp.next;
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
        }
        int deleteVal = Integer.valueOf(str[str.length - 1]);
        while(head != null && head.val == deleteVal){
            head = head.next;
        }
        Node temp = head;
        while (temp != null && temp.next != null){
            if(temp.next.val == deleteVal){
                temp.next = temp.next.next;
            }
            else
                temp = temp.next;
        }
        temp = head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    public void better(){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int[] arr = new int[str.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.valueOf(str[i]);
        List<Integer> list = new ArrayList<>();
        list.add(arr[1]);
        int time = arr[0];
        int index = 2;
        while (time-- > 1){
            int newVal = arr[index];
            int targetVal = arr[index + 1];
            list.add(list.indexOf(targetVal) + 1,newVal);
            index += 2;
        }
        int deleteVal = arr[arr.length - 1];
        for (Integer integer : list) {
            if(integer != deleteVal)
                System.out.print(integer + " ");
        }
    }
}
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}