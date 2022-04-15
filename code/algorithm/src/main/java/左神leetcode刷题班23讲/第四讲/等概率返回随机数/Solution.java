package 左神leetcode刷题班23讲.第四讲.等概率返回随机数;

public class Solution {
    int zero = 0;
    int one = 1;
    //假设此函数等概率返回1到5
    public int randomGetNum(){
        return (int) (Math.random() * 5 + 1);
    }
    //根据上面的函数等概率返回 0 和 1
    public int randomBinary(){
        int res = randomGetNum();
        while (res == 3)
            res = randomGetNum();
        if(res < 3)
            zero++;
        else
            one++;
        return res < 3 ? 0 : 1;
    }
    //根据二进制位 模拟
    public int randomGetAns(int a, int b){
        //先求出为了覆盖需要多少个二进制位
        int temp = 1, count = 1;
        while (temp < b - a)
            {
                count++;
                temp += temp << 1;
            }
        int sum = 0;
        do{
            sum = 0;
            for(int i = 0; i < count; i++)
                sum += (randomBinary() << i);
        }while (sum > b - a);
        return sum + a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 10, b = 15;
        int[] count = new int[b - a + 1];
        int testTime = 100000;
        for(int i = 0; i < testTime; i++)
            count[solution.randomGetAns(a,b) - a]++;
        for(int i = 0; i < count.length; i++)
            System.out.println(count[i]);
    }
}
