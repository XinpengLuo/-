package 泛型;

import java.util.*;
import java.util.zip.DeflaterOutputStream;

public class Test {
    public static void main(String[] args) {
        DouDiZhu douDiZhu = new DouDiZhu();
        douDiZhu.showAllPlayer();
        DouDiZhu[] douDiZhus  = new DouDiZhu[3];

    }

}
class DouDiZhu{


    @Override
    public int hashCode() {
        return Objects.hash(poker, pokerIndex, playerOne, playerTwo, playerThree, playerLeft);
    }

    //表示所有牌
    private HashMap<Integer,String> poker = new HashMap<>();
    //表示牌的索引
    ArrayList<Integer> pokerIndex = new ArrayList<>();
    //定义四个集合 前三个表示玩家的牌 后面三个表示三张底牌
    ArrayList<Integer> playerOne = new ArrayList<>();
    ArrayList<Integer> playerTwo = new ArrayList<>();
    ArrayList<Integer> playerThree = new ArrayList<>();
    ArrayList<Integer> playerLeft = new ArrayList<>();
    private void preparedPlate()
    {
        //表示牌的花色
        String[] colors = {"♠️","♥️","♣️","♦️"};
        //牌的序号
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        //利用map集合存储 这样存储以后 Key默认是按照从大到小的顺序了 因为组合的时候就是这样了
        int index = 2;
        poker.put(0,"小王");
        pokerIndex.add(0);
        poker.put(1,"大王");
        pokerIndex.add(1);
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color + number);
                pokerIndex.add(index);
                index++;
            }
        }

        //洗牌
        Collections.shuffle(pokerIndex);
    }
    private void sendPlate()
    {
        for (int i = 0; i < pokerIndex.size(); i++) {
            int index = pokerIndex.get(i);
            if(i >= 51)
                playerLeft.add(index);
            else if(i % 3 == 0)
                playerOne.add(index);
            else if(i % 3 == 1)
                playerTwo.add(index);
            else if(i % 3 == 2)
                playerThree.add(index);
        }
        Collections.sort(playerOne,Collections.reverseOrder());
        Collections.sort(playerTwo,Collections.reverseOrder());
        Collections.sort(playerThree,Collections.reverseOrder());
        Collections.sort(playerLeft,Collections.reverseOrder());
    }
    public void showPlayer(ArrayList<Integer> player)
    {
        for (Integer integer : player) {
            System.out.print(poker.get(integer) + " ");
        }
        System.out.println();
    }
    public void showAllPlayer()
    {
        preparedPlate();
        sendPlate();
        showPlayer(playerOne);
        showPlayer(playerTwo);
        showPlayer(playerThree);
        showPlayer(playerLeft);
    }
}
