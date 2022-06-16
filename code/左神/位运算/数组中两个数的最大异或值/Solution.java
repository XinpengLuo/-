package 左神.位运算.数组中两个数的最大异或值;

public class Solution
{
    public int findMaximumXOR(int[] nums) {
        int res = Integer.MIN_VALUE;
        Node root = new Node();
        for (int num : nums) {
            Node temp = root;
            for(int i = 31; i >= 0; i--){
                int flag = (1 << i) & num;
                if(flag != 0)
                   {
                       if(temp.one == null)
                           temp.one = new Node();
                       temp = temp.one;
                   }
                if(flag == 0)
                    {
                        if(temp.zero == null)
                            temp.zero = new Node();
                        temp = temp.zero;}
            }
        }
        for (int num : nums) {
            Node temp = root;
            int val = 0;
            for(int i = 31; i >= 0; i--){
                int target = ((1 << i) & num) != 0 ? 0 : 1;
                if((target != 0 && temp.one != null) || (target == 0 && temp.zero == null))
                    {
                        val += (1 << i);
                        temp = temp.one;
                    }
                else
                    temp = temp.zero;
            }
            res = Math.max(res, val ^ num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,10,5,25,2,8};
        Solution solution = new Solution();
        System.out.println(solution.findMaximumXOR(arr));
    }
}
class Node{
    Node zero;
    Node one;
}
