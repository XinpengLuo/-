package 左神.字符串.两个列表的最小索引总和;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i],i);
        }
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            if(map2.containsKey(list1[i])){
                int j = map2.get(list1[i]);
                if( i + j < temp){
                    res.clear();
                    res.add(list1[i]);
                }
                else if(i + j == temp)
                    res.add(list1[i]);
            }
        }
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
