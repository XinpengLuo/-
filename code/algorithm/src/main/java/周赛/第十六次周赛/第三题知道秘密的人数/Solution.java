package 周赛.第十六次周赛.第三题知道秘密的人数;

import java.net.Socket;

public class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        if(n <= 0)
            return 0;
        if(n <= delay)
            return 1;
        int left = peopleAwareOfSecret(n - delay,delay,forget) * delay;
        int right = peopleAwareOfSecret(n - forget,delay,forget);
        System.out.println( 2 * left - 1 + "  " + right);
        return 2 * left - 1 - right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.peopleAwareOfSecret(4, 2, 4));
    }

}
