package 左神.字符串.密钥格式化;

import java.util.concurrent.TimeoutException;

public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String[] split = s.split("-");
        s = s.replace("-","");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = s.length() - 1; i >= 0; ){
            if(i - k >= 0)
                stringBuffer.insert(0,s.substring(i - k + 1,i + 1));
            else
                stringBuffer.insert(0,s.substring(0,i + 1));
            if(i - k >= 0)
                {
                    stringBuffer.insert(0,"-");
                    i = i - k;
                }
            else
                break;
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        //"5F3Z-2E9W" "24A0-R74K"
        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormatting("2-4A0r7-4k", 4));
    }
}
