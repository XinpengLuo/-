package 主要练习.暴力递归和动态规划.递归和回溯.刷题.字母版上的路径;

public class Solution {
    public String alphabetBoardPath(String target) {
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        for(int k = 0; k < target.length(); k++){
            char temp = target.charAt(k);
            int countI = (temp - 'a') / 5;
            int countJ = (temp - 'a') % 5;
            System.out.println("countI :" + countI + " countJ:" + countJ);
            if(countI < i)
                res.append("U".repeat(i - countI));
            if(countJ > j)
                res.append("R".repeat(countJ - j));
            if(countJ < j)
                res.append("L".repeat(j - countJ));
            if(countI > i)
                res.append("D".repeat(countI - i));

            res.append("!");
            i = countI;
            j = countJ;

        }
        return res.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.alphabetBoardPath("bzb");
    }
}
