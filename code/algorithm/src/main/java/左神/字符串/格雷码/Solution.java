package 左神.字符串.格雷码;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0)
            return res;
        int first = 1;
        for(int i = 0; i < n; i++)
            {
                for(int j = res.size() - 1; j >= 0; j--)
                    res.add(first + res.get(i));
                first = first << 1;
            }
        return res;
    }
    public List<Integer> better(int n){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++)
            res.add(i ^ (i >> 1));
        return res;
    }
public static void main(String[] args) {
    Solution solution = new Solution();
    for (Integer integer : solution.better(2)) {
        System.out.println(integer);
    }
}
}
