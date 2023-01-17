package 主要练习.字符串.累加数;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length(); i++){
            for(int j = i + 1; j < num.length(); j++){
                String s1 = num.substring(0,i + 1);
                if(s1.length() > 1 && s1.charAt(0) == '0')
                    break;
                String s2 = num.substring(i + 1,j + 1);
                if(s2.length() > 1 && s2.charAt(0) == '0')
                    break;
                if(check(num.substring(j + 1, num.length()),s1,s2))
                    return true;
//                String res = addTwoString(s1,s2);

//                int start = j + 1;
//                while (start + res.length() <= num.length()){
//                    String temp = num.substring(start, start + res.length());
//                    if(temp.equals(res) && start + temp.length() == num.length())
//                        return true;
//                    if(!temp.equals(res))
//                        break;
//                    start = start + temp.length();
//                    s1 = s2;
//                    s2 = temp;
//                    res = addTwoString(s1,s2);
//
//                }
            }
        }
        return false;
    }
    public boolean check(String temp, String s1, String s2){
        String res = addTwoString(s1,s2);
        if(temp.equals(res))
            return true;
        if(temp.length() < res.length() || !temp.substring(0,res.length()).equals(res))
            return false;
        return check(temp.substring(res.length(),temp.length()),s2,res);
    }
    public String addTwoString(String s1, String s2){
        StringBuilder res = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? s1.charAt(i) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j) - '0' : 0;
            res.append((x + y + add) % 10);
            add = (x + y + add) / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "112358";
        System.out.println(solution.isAdditiveNumber(test));
    }
}
