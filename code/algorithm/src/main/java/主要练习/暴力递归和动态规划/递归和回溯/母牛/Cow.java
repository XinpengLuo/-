package 主要练习.暴力递归和动态规划.递归和回溯.母牛;

public class Cow {
    private static int initialNumber = 3;
    public static int countCow(int n){
        if(n <= 3)
            return initialNumber;
        return countCow(n - 1) + countCow(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(countCow(15));
    }
}
