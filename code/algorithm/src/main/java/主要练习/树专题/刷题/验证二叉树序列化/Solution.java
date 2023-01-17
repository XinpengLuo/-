package 主要练习.树专题.刷题.验证二叉树序列化;

class Solution {
    public boolean isValidSerialization(String preorder) {
        //#的数量 比节点的数量多1 且遇到#时 num 必须 大于 #
        int countNum = 0;
        int countC = 0;
        String[] s = preorder.split(",");
        for(int i = 0; i < s.length; i++){
            String c = s[i];
            if(c.equals("#")){
                countC++;
                if(countC - countNum > 1)
                    return false;
            }
            else{
                countNum++;
            }
        }
        return countC - countNum == 1;
    }

    public static void main(String[] args) {
        String s = "9,#,92,#,#";
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization(s));
    }
}