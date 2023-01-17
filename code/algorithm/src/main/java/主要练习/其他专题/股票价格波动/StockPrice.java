package 主要练习.其他专题.股票价格波动;

import java.util.HashMap;
import java.util.TreeMap;

public class StockPrice {
    HashMap<Integer,Integer> map;
    TreeMap<Integer, Integer> treeMap;
    int curTime;
    public StockPrice() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
        curTime = -1;
    }

    public void update(int timestamp, int price) {
        curTime =  Math.max(curTime,timestamp);
        int oldPrice = map.getOrDefault(timestamp,0);
        map.put(timestamp,price);
        if(oldPrice != 0){
            if(treeMap.get(oldPrice) == 1)
                treeMap.remove(oldPrice);
            else
                treeMap.put(oldPrice,treeMap.get(oldPrice) - 1);
        }
        treeMap.put(price,treeMap.getOrDefault(price,0) + 1);
    }

    public int current() {
        return map.get(curTime);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(88,9184);
        stockPrice.update(83,343);
        stockPrice.update(88,7180);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        System.out.println(stockPrice.minimum());

    }
}
