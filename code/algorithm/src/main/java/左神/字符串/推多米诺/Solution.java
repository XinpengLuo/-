package 左神.字符串.推多米诺;

public class Solution {
    public String pushDominoes(String dominoes) {
        char[] res = dominoes.toCharArray();
        int i = 0;
        while (i < dominoes.length()){
            if (dominoes.charAt(i) != '.')
                i++;
            int j = i;
            while (j < dominoes.length() && dominoes.charAt(j) == '.')
                j++;
            replaceDo(res,i,j - 1);
            i = j;
        }
        return String.valueOf(res);
    }
    public void replaceDo(char[] res, int start, int end){
        if(start - 1 < 0 && end + 1 >= res.length)
            return;
        else if(start - 1 < 0 || end + 1 >= res.length){
            char temp = end + 1 >= res.length ? res[start - 1] : res[end + 1];
            if(temp == 'L' && end + 1 >= res.length)
                return;
            if(temp == 'R' && start - 1 < 0)
                return;
            for(int i = start; i <= end; i++)
                res[i] = temp;
        }
        else if(res[start - 1] == res[end + 1]){
            char temp = res[start - 1];
            for(int i = start; i <= end; i++)
                res[i] = temp;
        }
        else{
            char left = res[start - 1];
            char right = res[end + 1];
            if(left == 'L' && right == 'R')
                return;
            while (start < end){
                res[start] = left;
                res[end] = right;
                start++;
                end--;
            }
        }
    }

    public String pushDominoesBetter(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        char[] res = dominoes.toCharArray();
        int i = 1;
        while (i < dominoes.length() - 1){
            if (dominoes.charAt(i) != '.')
                i++;
            int j = i;
            while (j < dominoes.length() && dominoes.charAt(j) == '.')
                j++;
            betterReplace(res,i,j - 1);
            i = j;
        }
        return String.valueOf(res).substring(1,res.length - 1);
    }

    public void betterReplace(char[] res, int start, int end){
        if(res[start - 1] == 'L' && res[end + 1] == 'R')
            return;
        else if(res[start - 1] == res[end + 1])
            for(int i = start; i <= end; i++)
                res[i] = res[start - 1];
        else{
            int i = start;
            int j = end;
            while (i < j){
                res[i] = res[start - 1];
                res[j] = res[end + 1];
                i++;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = ".L.R...LR..L..";
        System.out.println(solution.pushDominoes(test));
        System.out.println(solution.pushDominoesBetter(test));
    }
}
