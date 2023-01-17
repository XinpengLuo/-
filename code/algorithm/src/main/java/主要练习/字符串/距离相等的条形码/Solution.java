package 主要练习.字符串.距离相等的条形码;

import java.util.*;

public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode,map.getOrDefault(barcode,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        int index = 0;
        while(queue.size() > 1){
            Map.Entry<Integer, Integer> a = queue.poll();
            Map.Entry<Integer, Integer> b = queue.poll();
            barcodes[index++] = a.getKey();
            barcodes[index++] = b.getKey();
            if(a.getValue() > 1){
                a.setValue(a.getValue() - 1);
                queue.add(a);
            }
            if(b.getValue() > 1){
                b.setValue(b.getValue() - 1);
                queue.add(b);
            }
        }
        if(!queue.isEmpty())
            barcodes[index] = queue.poll().getKey();
        return barcodes;
    }

}
