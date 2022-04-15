package 左神.字符串.神奇字符串;

public class Solution {
    public int magicalString(int n) {
        if(n <= 3)
            return 1;
        StringBuffer str = new StringBuffer("122");
        char pre = '2';
        int i = 2;
        while (str.length() < n){
            int count = str.charAt(i) - '0';
            if(pre == '2')
                pre = '1';
            else
                pre = '2';
            for(int j = 0; j < count; j++)
                str.append(pre);
            i++;
        }
        System.out.println(str.toString());
        int ans = 0;
        for(i = 0; i < n; i++)
            if(str.charAt(i) == '1')
                ans++;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.magicalString(7));
    }
}
