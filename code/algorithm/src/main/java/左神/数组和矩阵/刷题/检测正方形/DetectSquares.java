package 左神.数组和矩阵.刷题.检测正方形;

import 左神.树专题.视频.消息体处理.求二叉树的最大值和最小值.MaxAndMinValue;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        HashMap<Integer, Integer> orDefault = map.getOrDefault(x, new HashMap<>());
        orDefault.put(y,orDefault.getOrDefault(y,0) + 1);
        map.put(x,orDefault);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int count = 0;
        HashMap<Integer, Integer> col = map.getOrDefault(x, new HashMap<>());
        for (Integer y1 : col.keySet()) {
            if(y1 == y)
                continue;
            int len = Math.abs(y1 - y);
            //先求右面的
            int a = x + len;
            //求出右边正方形的边
            HashMap<Integer, Integer> temp = map.getOrDefault(a, new HashMap<>());
            int count1 = temp.getOrDefault(y,0) * temp.getOrDefault(y1,0) * col.get(y1);
            //求左边的
            a = x - len;
            temp = map.getOrDefault(a, new HashMap<>());
            int count2 = (temp.getOrDefault(y,0) * temp.getOrDefault(y1,0)* col.get(y1));
            count += (count1 + count2);
        }
        return count;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));
        System.out.println(detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{11, 3});
        System.out.println(detectSquares.count(new int[]{11, 10}));
    }
}
