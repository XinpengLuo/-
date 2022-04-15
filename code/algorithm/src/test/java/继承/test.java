package 继承;
import 接口.*;
import java.util.ArrayList;
import java.util.Random;

class User{
    private String name;
    private int money;
    public User()
    {

    }
    public User(String name, int money)
    {
        this.name = name;
        this.money = money;
    }
    public void show()
    {
        System.out.println("我叫" + name + " 我有  " + money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

class Manager extends User{
    public Manager()
    {

    }
    public Manager(String name, int money) {
        super(name, money);
    }
    public ArrayList<Integer> send(int money, int count)
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int leftMoney = super.getMoney();
        if(money > leftMoney)
            return null;
        super.setMoney(leftMoney - money);
        int avg = money / count;
        int mod = money % count; //剩下的零头 包在最后的红包里
        for (int i = 0; i < count - 1; i++) {
            arrayList.add(avg);
        }
        arrayList.add(avg + mod);
        return arrayList;
    }
}
class Member extends User{
    public Member()
    {

    }
    public Member(String name, int money)
    {
        super(name, money);
    }
    public void receive(ArrayList<Integer> list)
    {
        int index = new Random().nextInt(list.size());
        //根据索引删除
        int delta = list.remove(index);
        int newMoney = super.getMoney() + delta;
        super.setMoney(newMoney);
    }
}
class test{
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 1000);
        Member member1 = new Member("成员1", 0);
        Member member2 = new Member("成员2", 0);
        Member member3 = new Member("成员3", 0);
        manager.show();
        member1.show();
        member2.show();
        member3.show();
        ArrayList<Integer> sendMoney = manager.send(500, 3);
        member1.receive(sendMoney);
        member2.receive(sendMoney);
        member3.receive(sendMoney);
        System.out.println("=========");
        manager.show();
        member1.show();
        member2.show();
        member3.show();
    }
}