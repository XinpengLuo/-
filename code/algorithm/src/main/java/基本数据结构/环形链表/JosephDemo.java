package 基本数据结构.环形链表;

public class JosephDemo {
    public static void main(String[] args) {
        circleList circleList = new circleList();
        circleList.add(15);
        circleList.show();
        circleList.countBoy(12,2,15);
    }
}
class circleList{
    private Node first;
    public void add(int number)
    {
        if(number < 1)
            return;
        Node curNode = null;
        for (int i = 1; i <= number; i++) {
            Node node = new Node(i);
            if(i == 1)
            {
                this.first = node;
                curNode = first;
                curNode.next = first;
            }
            else{
                curNode.next = node;
                curNode = node;
                node.next = this.first;

            }
        }
    }
    public void show()
    {
        if(this.first == null)
            return;
        Node node = first;
        while (true)
        {
            System.out.println(node.toString());
            if(node.next == first)
                break;
            node = node.next;
        }
    }
    //从第几个开始数 数几下 有多少个小孩儿
    public void countBoy(int startNo, int countNum, int nums){
        if(this.first == null || startNo < 1 || startNo > nums)
            return;
        //先将first移动到从第几个孩子开始的位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
        }
        //创建一个辅助指针 永远指向first的前一个
        Node helper = this.first;
        while (true){
            if(helper.next == first)
                break;
            helper = helper.next;
        }
        //当两个指针重叠时候 就只剩一个人了
        while (helper != first)
        {
            //报几个数字后 开始吃人
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            //这个时候first指向的节点就是出去的那个节点
            System.out.println(first.no + " ");
            first = first.next;
            helper.next = first;
        }
        System.out.println(first.no);
    }
}
class Node{
    public int no;
    public Node next;
    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}