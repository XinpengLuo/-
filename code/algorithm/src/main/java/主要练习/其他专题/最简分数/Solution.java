package 主要练习.其他专题.最简分数;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        if(n == 1)
            return res;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++)
                if (gcd(j, i) == 1)
                    res.add(j + "/" + i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(4));
    }
}
class Again{
    public int gcd(int m, int n){
        if(n == 0)
            return m;
        return gcd(n,m % n);
    }
    public List<String> simplifiedFractions(int n){
        List<String> res = new ArrayList<>();
        if(n == 1)
            return res;
        for(int i = 2; i <= n; i++)
            for(int j = 1; j < i; j++)
                if(gcd(i,j) == 1)
                    res.add(i + "/" + j);
        return res;
    }
}
