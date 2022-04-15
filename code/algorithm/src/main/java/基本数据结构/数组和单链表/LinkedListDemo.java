package 基本数据结构.数组和单链表;
//head节点不存放具体的数据 作用就是单链表的头

import java.util.Stack;

public class LinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(3, "宋江", "玉麒麟");
        HeroNode node2 = new HeroNode(1,"吴用", "智多星");
        HeroNode node3 = new HeroNode(2,"lxp", "智多星");
        LinkedList singleLinkedList = new LinkedList();
        singleLinkedList.addByNo(node1);
        singleLinkedList.addByNo(node2);
        singleLinkedList.addByNo(node3);
        singleLinkedList.show();
        singleLinkedList.reverseShow();
    }
}
class LinkedList {
    //初始化头节点 头节点不要动
    private HeroNode head = new HeroNode(0, "", "");
    //添加节点到单向链表 无序
    public void add(HeroNode heroNode)
    {
        //先找到链表的最后
        HeroNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        //再指向
        temp.next = heroNode;
    }
    //添加节点到单向链表 有序
    public void addByNo(HeroNode heroNode){
        HeroNode temp = head;
        while (temp.next != null && temp.next.no < heroNode.no)
            temp = temp.next;
        heroNode.next = temp.next;
        temp.next = heroNode;
    }
    //展示链表
    public void show()
    {
        //先判断是否为空
        if(head.next == null)
            {
                System.out.println("链表为空");
                return;
            }
        HeroNode temp = head;
        while (temp.next != null)
            {
                System.out.println(temp.next.toString());
                temp = temp.next;
            }
    }
    //修改节点的信息 根据编号来修改即no不能改
    public void update(HeroNode heroNode)
    {
        if(head.next == null)
        {
            System.out.println("为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null)
            {
                if(temp.next.no == heroNode.no)
                    {
                        flag = true;
                        break;
                    }
                temp = temp.next;
            }
        if(flag)
            {
                temp.next.name = heroNode.name;
                temp.next.nickName = heroNode.nickName;
            }
    }
    //删除节点
    public void delete(int no)
    {
        HeroNode temp = head;
        if(head.next == null)
            return;
        boolean flag = false;
        while (temp.next != null)
        {
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag)
            temp.next = temp.next.next;
        else
            System.out.println("节点不存在");
    }
    //求单链表节点的个数
    public int getNumber()
    {
        int num = 0;
        if(head.next == null)
            return num;
        HeroNode temp = head.next;
        while (temp != null)
        {
            num++;
            temp = temp.next;
        }
        return num;
    }
    //求单链表的倒数第k个节点
    public HeroNode getByDaoIndex(int index)
    {
        int total = this.getNumber();
        //遍历total - index 个
        if(index > total || head.next == null)
            return null;
        int cur = 0;
        HeroNode temp = head.next;
        while (cur < total - index)
        {
            cur++;
            temp = temp.next;
        }
        return temp;
    }
    //单链表反转
    public void reverseLinkedList()
    {

        if(head.next == null || head.next.next == null)
            return;
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode temp = head.next;
        HeroNode next = null;
        while (temp != null)
        {
            next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = next;
        }
        head.next = newHead.next;
    }
    //从尾到头打印单链表
    public void reverseShow()
    {
        if(head.next == null)
            return;
        Stack stack = new Stack();
        HeroNode temp = head.next;
        while (temp != null)
        {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.empty())
            System.out.println(stack.pop().toString());
    }
    //合并两个有序链表
    public static HeroNode mergerList(HeroNode h1, HeroNode h2)
    {
        //创建新的链表头节点
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode temp = newHead;
        h1 = h1.next;
        h2 = h2.next;
        while (h1 != null && h2 != null)
        {
            if(h1.no < h2.no)
            {
                temp.next = h1;
                h1 = h1.next;
            }
            else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        temp.next = h1 != null ? h1 : h2;
        return newHead.next;
    }
}
//定义HeroNode 每一个HeroNode 就一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                "," +
                '}';
    }
}
