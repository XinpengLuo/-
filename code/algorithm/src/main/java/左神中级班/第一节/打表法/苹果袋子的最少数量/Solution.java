package 左神中级班.第一节.打表法.苹果袋子的最少数量;

public class Solution {
    public int getMinBag(int n){
        if(n % 2 != 0)
            return -1;
        int bagEight = n / 8;
        int num = n - 8 * bagEight;
        int bagSix = -1;
        while (bagEight >= 0){
            if(num % 6 == 0){
                bagSix = num / 6;
                break;
            }
            bagEight--;
            num = n - 8 * bagEight;
        }
        return bagSix == -1 ? -1 : bagEight + bagSix;
    }
    public int getMinBagPrintTable(int n){
        if(n % 2 != 0)
            return -1;
        if(n < 18){
            if(n == 0)
                return 0;
            else if(n == 6 || n == 8)
                return 1;
            else if(n == 12 || n == 14 || n == 16)
                return 2;
            else return -1;
        }
        return (n - 18) / 8 + 3;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i <= 107; i++) {
            if(solution.getMinBag(i) != solution.getMinBagPrintTable(i))
                System.out.println(i +" "+1);
        }
    }
}
