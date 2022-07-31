package 左神.位运算.下一个数;

/**
 * @author luoxinpeng
 */
class Solution {
    //1000011
    //111000
    public int[] findClosedNumbers(int num) {
        int[] res = new int[2];
        int lastOne = -1, firstOne = -1;
        int pre = -1;
        for(int i = 0; i < 32; i++){
            if(((num >> i) & 1) == 1)
            {
                if(lastOne == -1 && pre == 0) {
                    lastOne = i;
                }
                if(firstOne == -1) {
                    firstOne = i;
                }
                pre = 1;
            }
            else{
                pre = 0;
            }
        }

        System.out.println(lastOne);
        if(lastOne == 0 || lastOne == -1) {
            res[1] = -1;
        } else
        {
            int val = num ^ (1 << (lastOne));
            val |= (1 << (lastOne - 1));
            res[1] = val;
        }
        if(firstOne == 31 || firstOne == -1) {
            res[0] = -1;
        } else{
            int val = num ^ (1 << (firstOne));
            val |= (1 << (firstOne + 1));
            res[0] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 67;
        Solution solution = new Solution();
        for (int closedNumber : solution.findClosedNumbers(67)) {
            System.out.println(closedNumber);
        }
    }
}