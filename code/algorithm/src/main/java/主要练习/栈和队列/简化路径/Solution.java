package 主要练习.栈和队列.简化路径;
import java.util.*;

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
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long res = Long.MAX_VALUE;
        while(i < a.length && j < b.length){
            if(a[i] == b[j])
                return 0;
            else{
                long dif = Math.abs((long)(a[i] - b[j]));
                res = Math.min(res, dif);
                if(a[i] > b[j])
                    j++;
                else
                    i++;
            }
        }
        return (int)res;
    }
    public static void main(String[] args) {
        int[] a = {-2147483648,1};
        int[] b = {2147483647,0};
        System.out.println(smallestDifference(a, b));
//        String test = "/home//foo/";
//        Solution solution = new Solution();
//        System.out.println(solution.better(test));
    }
}
