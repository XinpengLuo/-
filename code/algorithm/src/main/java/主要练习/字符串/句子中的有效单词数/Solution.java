package 主要练习.字符串.句子中的有效单词数;

public class Solution {
    public int countValidWords(String sentence) {
        String[] split = sentence.split(" ");
        int count = 0;
        for(int i = 0; i < split.length; i++){
            String temp = split[i];
            if(temp.equals(""))
                continue;
            boolean flag = true;
            int countLian = 0;
            for(int j = 0; j < temp.length(); j++){
                if(Character.isDigit(temp.charAt(j))){
                    flag = false;
                    break;
                }
                if(temp.charAt(j) == '-'){
                    countLian++;
                    if(countLian > 1 || j == 0 || j == temp.length() - 1 || !Character.isLetter(temp.charAt(j - 1)) || !Character.isLetter(temp.charAt(j + 1))){
                        flag = false;
                        break;
                    }
                }
                if(temp.charAt(j) == '.' || temp.charAt(j) == '!' || temp.charAt(j) == ','){
                    if(j != temp.length() - 1){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "cat and  dog";
        solution.countValidWords(test);
    }
}
