package 主要练习.暴力递归和动态规划.动态规划.刷题.香槟塔;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> list = new ArrayList<>();
        list.add((double) poured);
        int cup = 2;
        for(int i = 1; i <= query_row; i++){
            List<Double> temp = new ArrayList<>();
            for(int j = 0; j < cup; j++)
                temp.add(getValue(list,j - 1) / 2 + getValue(list,j) / 2);
            cup++;
            list = temp;
        }
        return list.get(query_glass) >= 1 ? 1 : list.get(query_glass);
    }
    public double getValue(List<Double> list, int index){
        if(index < 0 || index >= list.size())
            return 0;
        if(list.get(index) > 1)
            return list.get(index);
        return 0;
    }
}
