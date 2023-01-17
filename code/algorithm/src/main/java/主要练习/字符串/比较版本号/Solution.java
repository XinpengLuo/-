package 主要练习.字符串.比较版本号;

public class Solution {
    //系统api法
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        for(int i = 0; i < Math.max(s1.length,s2.length); i++){
            int a = i >= s1.length ? 0 : Integer.valueOf(s1[i]);
            int b = i >= s2.length ? 0 : Integer.valueOf(s2[i]);
            if(a > b)
                return 1;
            else if(a < b)
                return -1;
        }
        return 0;
    }
    //双指针法 省出空间
    public int compareVersionPint(String version1, String version2){
        int l1 = version1.length();
        int l2 = version2.length();
        int i = 0, j = 0;
        while (i < l1 || j < l2){
            int v1 = 0;
            while (i < l1 && version1.charAt(i) != '.'){
                v1 = v1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            i++;
            int v2 = 0;
            while (j < l2 && version2.charAt(j) != '.'){
                v2 = v2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            j++;
            System.out.println(v1 + " " + v2);
            if(v1 > v2)
                return 1;
            else if(v1 < v2)
                return -1;
        }
        return 0;
    }
    public static void main(String[] args) {
        String s1 = "1.01";
        String s2 = "1.001";
        Solution solution = new Solution();
        System.out.println(solution.compareVersionPint(s1, s2));
    }
}
