package 左神.数组和矩阵.刷题.杨辉三角;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        if(rowIndex == 1)
            return preList;
        int count = 2;
        while (count <= rowIndex + 1){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < count; i++){
                System.out.println(i);
                int leftValue = (i - 1 < 0 ? 0 : preList.get(i - 1));
                int rightValue = (i >= preList.size() ? 0 : preList.get(i));
                temp.add(leftValue + rightValue);
            }
            preList = temp;
            count++;
        }
        return preList;
    }
    public List<List<Integer>> generate(int numRows) {
        List<Integer> preList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        preList.add(1);
        res.add(preList);
        if(numRows == 1)
            return res;
        int count = 2;
        while (count <= numRows){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < count; i++){
                System.out.println(i);
                int leftValue = (i - 1 < 0 ? 0 : preList.get(i - 1));
                int rightValue = (i >= preList.size() ? 0 : preList.get(i));
                temp.add(leftValue + rightValue);
            }
            res.add(temp);
            preList = temp;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(3);
    }
}
