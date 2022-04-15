package 周赛.第三次周赛.第三题;

public class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1)
            return encodedText;
        int cols = encodedText.length() / rows;
        int count = cols * rows;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < cols; i++){
            int start = i;
            while (start < count){
                char temp = encodedText.charAt(start);
                ans.append(temp);
                start += (cols + 1);
            }
        }
        return trimEnd(ans.toString().toCharArray());
    }
    public String trimEnd(char[] value) {
        int len = value.length;
        int st = 0;
        char[] val = value;
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < value.length)) ? new String(val).substring(st, len) : new String(val);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word ="iveo    eed   l te   olc";
        System.out.println(solution.decodeCiphertext(word, 4));
    }
}
