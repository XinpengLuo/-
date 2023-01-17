package 面试真题.百度检测代码;

import java.util.*;

public class Main {
    public static int check(String s){
        int index = 0;
        int temp = 0;
        int res = 0;
        List<Integer> preFor = new ArrayList<>();
        List<Integer> preIf = new ArrayList<>();
        while(index < s.length()){
            char c = s.charAt(index);
            if(c == ' '){
                index++;
                continue;
            }
            if(index + 3 < s.length() && s.substring(index,index + 3).equals("for")){
                preFor.add(index);
                temp++;
                index = index + 3;
            }
            else if(index + 2 < s.length() && s.substring(index,index + 2).equals("if")){
                preIf.add(index);
                index = index + 2;
            }
            else if(c == '}' && (!preIf.isEmpty() || !preFor.isEmpty())){
                if(((!preFor.isEmpty() && !preIf.isEmpty()) && preFor.get(preFor.size() - 1) > preIf.get(preIf.size() - 1)) || (!preFor.isEmpty() && preIf.isEmpty())){
                    temp--;
                    preFor.remove(preFor.size() - 1);
                }
                else if(((!preFor.isEmpty() && !preIf.isEmpty()) && preFor.get(preFor.size() - 1) < preIf.get(preIf.size() - 1)) || (preFor.isEmpty() && !preIf.isEmpty())){
                    preIf.remove(preIf.size() - 1);
                }
                index++;
            }
            else
                index++;
            res = Math.max(res,temp);
        }
        return res;
    }
    //for{if{}for{}}
    public static void main(String[] args) {
        System.out.println(check("for{if{for{}}for{for{}}}"));
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//
//        while (scanner.hasNextLine()){
//            sb.append(scanner.nextLine());
//        }
//        System.out.println(check(sb.toString()));
    }
}
