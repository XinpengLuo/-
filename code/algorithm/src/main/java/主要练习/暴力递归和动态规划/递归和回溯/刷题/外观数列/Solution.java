package 主要练习.暴力递归和动态规划.递归和回溯.刷题.外观数列;

public class Solution {
    public String countAndSay(int n) {
        return help(n);
    }
    public String help(int n){
        if(n == 1)
            return "1";
        String pre = help(n - 1);
        String result = "";
        int index = 0;
        while (index < pre.length()){
            char temp = pre.charAt(index);
            int j = 1;
            while (index + j < pre.length() && pre.charAt(index + j) == temp)
                j++;
            result += (String.valueOf(j) + String.valueOf(temp));
            index = index + j;
        }
        return result;
    }
    //新方法 用迭代
    public String newCountAndSay(int n){
        String pre = "1";
        String res = "";
        if(n == 1)
            return pre;
        while (n != 1){
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            while (index < pre.length())
            {
                char temp = pre.charAt(0);
                int count = 1;
                while (index + count < pre.length() && pre.charAt(index + count) == temp)
                    count++;
                stringBuilder.append(count + String.valueOf(temp));
                index = index + count;
            }
            res = stringBuilder.toString();
            pre = res;
            n--;
        }
        return res;
    }
    public static void main(String[] args) {


    }
}
