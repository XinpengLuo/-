package 主要练习.数组和矩阵.刷题.插入后的最大值;

public class Solution {
    public String maxValue(String n, int x) {
        char first = n.charAt(0);
        StringBuilder sb = new StringBuilder(n);
        int  index = sb.length();
        if(first == '-'){

            for(int i = 1; i < sb.length(); i++)
                if(sb.charAt(i) - '0' > x)
                {
                    index = i;
                    break;
                }
        }
        else{
            for(int i = 0; i < sb.length(); i++)
                if(sb.charAt(i) - '0' < x){
                    index = i;
                    break;
                }
        }
        sb.insert(index,x);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue("-13", 2));
    }
}
