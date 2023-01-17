package 主要练习.数组和矩阵.刷题.完美矩形;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        //记录大矩形的左下角和右上角
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE; //左下角
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE; //右上角
        int tempArea = 0; //累加小矩形的面积
        HashMap<Point,Integer> map = new HashMap<>();
        for(int i = 0; i < rectangles.length; i++){
            int a1 = rectangles[i][0], b1 = rectangles[i][1], a2 = rectangles[i][2], b2 = rectangles[i][3];
            //更新大矩形的左下角和右上角
            if(a1 < x1 || b1 < y1){
                x1 = a1;
                y1 = b1;
            }
            if(a2 > x2 || b2 > y2){
                x2 = a2;
                y2 = b2;
            }
            tempArea += ((a2 - a1) * (b2 - b1));
            Point pointLeftDown = new Point(a1,b1);
            Point pointRightTop = new Point(a2,b2);
            Point pointLeftTop = new Point(a1,b2);
            Point pointRightDown = new Point(a2,b1);
            map.put(pointLeftDown,map.getOrDefault(pointLeftDown,0) + 1);
            map.put(pointRightTop,map.getOrDefault(pointRightTop,0) + 1);
            map.put(pointLeftTop,map.getOrDefault(pointLeftTop,0) + 1);
            map.put(pointRightDown,map.getOrDefault(pointRightDown,0) + 1);
        }
        Point ld = new Point(x1,y1);
        Point lt = new Point(x1,y2);
        Point rd = new Point(x2,y2);
        Point rt = new Point(x2,y1);
        if(tempArea != ((x2 - x1) * (y2 - y1)) || map.getOrDefault(ld,0) != 1 || map.getOrDefault(lt,0) != 1 || map.getOrDefault(rd,0) != 1 || map.getOrDefault(rt,0) != 1)
            return false;
        map.remove(ld);
        map.remove(lt);
        map.remove(rd);
        map.remove(rt);
        for (Map.Entry<Point, Integer> entry : map.entrySet()) {
            Point point = entry.getKey();
            int value = entry.getValue();
            if(value != 2 && value != 4)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        System.out.println(solution.isRectangleCover(arr));
    }
}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point2 = (Point) obj;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }
}
