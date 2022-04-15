package 基本数据结构.双向链表;
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}
//创建一个双向链表的类
class DoubleLinkedList{
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");
    public void add(DoubleHeroNode heroNode)
    {
        //先找到链表的最后
        DoubleHeroNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        //再指向
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    public void show()
    {
        //先判断是否为空
        if(head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode temp = head;
        while (temp.next != null)
        {
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }
    //修改节点的信息 根据编号来修改即no不能改 和单向链表几乎一样
    public void update(DoubleHeroNode heroNode)
    {
        if(head.next == null)
        {
            System.out.println("为空");
            return;
        }
        DoubleHeroNode temp = head;
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
    //删除双向链表的一个节点 区分去单链表的区别是不需要找到前一个节点 只需要找到本身 自我删除即可
    public void delete(int no)
    {
        DoubleHeroNode temp = head.next;
        if(head.next == null)
            return;
        boolean flag = false;
        while (temp != null)
        {
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            //这里要判断最后一个节点
            if(temp.next != null)
                temp.next.pre = temp.pre;
        }
        else
            System.out.println("节点不存在");
    }
}
class DoubleHeroNode{
    public int no;
    public String name;
    public String nickName;
    public DoubleHeroNode next;
    public DoubleHeroNode pre;
    public DoubleHeroNode(int no, String name, String nickName){
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