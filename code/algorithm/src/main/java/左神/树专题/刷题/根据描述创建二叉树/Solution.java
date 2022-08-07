package 左神.树专题.刷题.根据描述创建二叉树;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            TreeNode parentNode = map.getOrDefault(parent,new TreeNode(parent));
            TreeNode childNode = map.getOrDefault(child,new TreeNode(child));
            if(description[2] == 1)
                parentNode.left = childNode;
            else
                parentNode.right = childNode;
            map.put(parent,parentNode);
            map.put(child,childNode);
            set.add(child);
        }
        TreeNode root = null;
        for (int[] description : descriptions) {
            if(!set.contains(description[0])){
                root = map.get(description[0]);
                break;
            }
        }
        return root;
    }
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] strs = text.split(" ");
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String t2) {
                return s1.length() - t2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str + " ");
        }
        String trim = sb.toString().trim();
        char[] array = trim.toCharArray();
        array[0] = Character.toUpperCase(array[0]);
        return new String(array);
    }

    public int solution(String S) {
        // write your code in Java 11 (Java SE 11)
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            if(c == 'R')
                list.add(i);
        }
        if(list.size() == 0)
            return 0;
        long count = 0;
        int target = list.get(list.size() / 2);
        for(int i = 0; i < list.size(); i++)
        {
            if(i != list.size() / 2){
                int temp = list.get(i);
                count += Math.abs(target - temp) - (Math.abs(list.size() / 2 - i));
            }
        }
        if(count >= Math.pow(10,9))
            return -1;
        return (int) count;
    }

    public int solution(String S, int B) {
        // write your code in Java 11 (Java SE 11)
        int res = 0;
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(c == 'x')
                count++;
            else{
                if(count != 0) {
                    queue.add(count);
                    count = 0;
                }
            }
        }
        if(count != 0)
            queue.add(count);
        while(!queue.isEmpty() && B > 0){
            int num = queue.poll();
            if(B >= num + 1){
                res += num;
                B -= (num + 1);
            }
            else{
                res += B - 1;
                B = 0;
            }
        }
        return res;
    }

    public boolean solution(int[] A, int[] B, int S){
        if(A.length > S)
            return false;
        return dfs(A,B,new HashSet<>(),0);
    }

    public boolean dfs(int[] A, int[] B, HashSet<Integer> set, int index){
        if(index == A.length) {
            return true;
        }
        boolean res = false;
        if(!set.contains(A[index])){
            set.add(A[index]);
            res = res || dfs(A,B,set,index + 1);
            set.remove(A[index]);
        }
        if(!set.contains(B[index])){
            set.add(B[index]);
            res = res || dfs(A,B,set,index + 1);
            set.remove(B[index]);
        }
        return res;
    }








    public static void main(String[] args) {
        int[] arr = {2,5,6,5};
        int[] num = {5,4,2,2};
        Solution solution = new Solution();
        System.out.println(solution.solution(arr,num,8));
    }
}
