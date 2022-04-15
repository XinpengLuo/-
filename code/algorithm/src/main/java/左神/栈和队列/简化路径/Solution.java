package 左神.栈和队列.简化路径;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    public String simplifyPath(String path) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < path.length()){
            if(path.charAt(index) == '/')
                index++;
            else{
                int i = index;
                while (index < path.length() && path.charAt(index) != '/')
                    index++;
                String temp = path.substring(i,index);
                if(temp.equals("..") && res.size() != 0)
                    res.remove(res.size() - 1);
                if(!temp.equals("..") && !temp.equals("."))
                    res.add(temp);
            }
        }
        if(res.size() == 0)
            return "/";
        StringBuffer ans = new StringBuffer();
        for (String re : res) {
            ans.append("/" + re);
        }
        return ans.toString();
    }
    public String better(String path){
        String[] split = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String s : split) {
            if(s.equals(".") || s.equals(""))
                continue;
            else if(s.equals(".."))
                {
                    if(!deque.isEmpty())
                        deque.pollLast();
                }
            else
                deque.addLast(s);
        }
        StringBuilder sb = new StringBuilder();
        if(deque.isEmpty())
            return "/";
        while (!deque.isEmpty())
            sb.append("/" + deque.pollFirst());
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "/home//foo/";
        Solution solution = new Solution();
        System.out.println(solution.better(test));
    }
}
