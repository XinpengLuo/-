package 周赛.第十五次周赛.第一题;

public class Solution {
    public String deleteText(String article, int index) {
        if(article.charAt(index) == ' ')
            return article;
        String[] s = article.split(" ");
        int count = 0;
        for(int i = 0; i < article.length(); i++){
            if(i == index)
                break;
            if(article.charAt(i) == ' ')
                count++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if(i != count)
                sb.append(s[i] + " ");
        }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteText("Hello", 0));
    }
}
