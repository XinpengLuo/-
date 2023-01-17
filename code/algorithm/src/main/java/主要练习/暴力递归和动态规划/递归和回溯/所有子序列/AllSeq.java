package 主要练习.暴力递归和动态规划.递归和回溯.所有子序列;

public class AllSeq {
    //打印字符串的所有序列
    public static void printAllSeq(char[] str, int i, String temp){
        if(i + 1 == str.length)
            {
                System.out.println(temp);
                System.out.println(temp + str[i]);
                return;
            }
        printAllSeq(str,i + 1,temp + "");
        printAllSeq(str,i + 1,temp + str[i]);
    }
    //打印字符串的全排列
    public static void printAllOrder(char[] str, int i, String result){
        if(i == str.length)
        {
            System.out.println(result);
            return;
        }
        for (char c : str) {
            if(!result.contains(String.valueOf(c)))
                printAllOrder(str,i + 1,result + c);
        }
    }
    public static void main(String[] args) {
        String test  = "123";
        printAllSeq(test.toCharArray(),0,"");
    }
}
