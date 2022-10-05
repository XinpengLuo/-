package 左神.双指针.在LR字符串中交换相邻字符;

public class Solution {
    public boolean canTransform(String start, String end) {
        if(start.length() != end.length())
            return false;
        int i = 0, j = 0;
        while (i < start.length() || j < end.length()){
            while (i < start.length() && start.charAt(i) == 'X')
                i++;
            while (j < end.length() && end.charAt(j) == 'X')
                j++;
            if(i == start.length() && j == end.length())
                break;
            if(i >= start.length() || j >= end.length() || start.charAt(i) != end.charAt(j))
                return false;
            char c = start.charAt(i);
            if(c == 'L' && i < j)
                return false;
            if(c == 'R' && i > j)
                return false;
            i++;
            j++;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canTransform("RXR", "XXR"));
    }
}
