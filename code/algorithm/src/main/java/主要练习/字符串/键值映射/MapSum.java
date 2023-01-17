package 主要练习.字符串.键值映射;

import java.util.HashMap;
import java.util.Map;

class MapSum {
    HashMap<String,Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix))
                sum += entry.getValue();
        }
        return sum;
    }
}