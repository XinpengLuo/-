package 主要练习.其他专题;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    //分割回文串
    List<List<String>> partitionResult = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        helper(s,-1,path);
        return partitionResult;
    }
    public void helper(String s, int index, List<String> path){
        if(index == s.length() - 1)
        {
            partitionResult.add(new ArrayList<>(path));
            return;
        }
        String temp = "";
        for(int i = 1;index + i < s.length(); i++){
            temp = temp + s.charAt(index + i);
            if(!isPa(temp))
                continue;
            else
            {
                path.add(temp);
                helper(s,index + i, path);
                if(!path.isEmpty())
                    path.remove(path.size() - 1);
            }

        }
    }
    public boolean isPa(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            stack.push(s.charAt(i));
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            if(stack.pop() != s.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();




    }
}
