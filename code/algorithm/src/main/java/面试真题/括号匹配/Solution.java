package 面试真题.括号匹配;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "{([])}";
        for(int i = 7; i < 20; i++) {
            System.out.println(i + " : " + solution.countPatient(i));
            System.out.println(i + " : " + solution.countPatientTwo(i));
        }
//        System.out.println(solution.countPatient(13));
    }
    public boolean testValid (String str) {
        // write code here
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < str.length()){
            char c = str.charAt(index);
            if(c == ']')
            {
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;}
            else if(c == '}')
            {
                if(!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;}
            else if(c == ')')
            {
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;}
            else
                stack.push(c);
            index++;
        }
        return stack.isEmpty();
    }


    public int cal (int N, int m) {
        // write code here
        //1 2 3 4 5 6 7 8 9 10
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++)
            list.add(i + 1);
        int start = 0;
        while (list.size() != 1){
            int end = (start + m - 1) % list.size();
            list.remove(end);
            if(end >= list.size())
                start = 0;
            else
                start = end;
        }
        return list.get(0);
    }

    public long countPatient (int days) {
        // write code here
        if(days < 7)
            return 1;
        PriorityQueue<Integer> isChecked = new PriorityQueue<>();
        HashMap<Integer,Long> map = new HashMap<>();
        int start = 7;
        isChecked.add(1);
        map.put(1, 1L);
        while (start <= days){
            while (isChecked.peek() + 13 == start) {
                Integer poll = isChecked.poll();
                map.remove(poll);
            }
            int size = isChecked.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                if((isChecked.peek() + 6) <= start && start < (isChecked.peek() + 13)) {
                    long val = map.get(isChecked.peek()) * 3;
                    map.put(start,map.getOrDefault(start, 0L) + val);
                    isChecked.add(start);
                    list.add(isChecked.poll());
                }
               else
                   break;
            }
            for (Integer integer : list) {
                isChecked.add(integer);
            }
            start++;
        }
        long ans = 0;
        for (Integer integer : map.keySet()) {
            ans += map.get(integer);
        }
        return ans;
    }

    public long countPatientTwo (int days) {
        // write code here
        if(days < 7)
            return 1;
        PriorityQueue<Integer> isChecked = new PriorityQueue<>();
        int start = 7;
        isChecked.add(1);
        while (start <= days){
            while (isChecked.peek() + 13 == start)
                isChecked.poll();
            int size = isChecked.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                if((isChecked.peek() + 6) <= start && start < (isChecked.peek() + 13)) {
                    for (int i = 0; i < 3; i++)
                        isChecked.add(start);
                    list.add(isChecked.poll());
                }
                else
                    break;
            }
            for (Integer integer : list) {
                isChecked.add(integer);
            }
            start++;
        }
        return isChecked.size();
    }
    //13 --> 31
    //1 + 3 * (7) + 9
    //fn = f(n - 1) * f(n - 7) * 3 - f(n - 14)
    //7 --> 1 + 3
    //8 --> 1 + 3 + 3
    //9 --> 1 + 3
}
