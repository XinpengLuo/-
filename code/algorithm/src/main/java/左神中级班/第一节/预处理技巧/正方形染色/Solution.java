package 左神中级班.第一节.预处理技巧.正方形染色;

public class Solution {
    //反正就是要左侧全部是G  右边全是R
    public static int minPaintTest(String s){
        char[] str = s.toCharArray();
        int n = str.length;
        int count = 0;
        int res = Integer.MAX_VALUE;
        for(int l = 0; l <= n; l++){
            if(l == 0)
                count = getNumber(str,0,n - 1, false);
            else if(l == n)
                count = getNumber(str,0,n - 1,true);
            else
                count = getNumber(str,0,l - 1,true) + getNumber(str,l,n - 1,false);
            res = Math.min(res,count);
        }
        return res;
    }
    public static int minPaintTestPro(String s){
        char[] str = s.toCharArray();
        int n = str.length;
        int count = 0;
        int res = Integer.MAX_VALUE;
        int[] red = new int[n];//生成一个0 到 i 计算 有多少个红色 的数组 即每个下标表示 从0到当前位置有多少个R
        int[] green = new int[n]; //生成一个从i 到 数组末尾 计算 有多少个绿色的
        int countArr = 0;
        for (int i = 0; i < str.length; i++) {
            if(str[i] == 'R')
                countArr++;
            red[i] = countArr;
        }
        countArr = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            if(str[i] == 'G')
                countArr++;
            green[i] = countArr;
        }
        for(int l = 0; l <= n; l++){
            if(l == 0)
                count = green[0];
            else if(l == n)
                count = red[n - 1];
            else
                count = red[l - 1] + green[l];
            res = Math.min(res,count);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "RGRRRGGRGRGR";
        System.out.println(minPaintTest(s));
        System.out.println(minPaintTestPro(s));
    }
    public static int getNumber(char[] str, int l, int r, boolean flag){
        //true 统计 红色 false 统计 绿色
        int count = 0;
        for(int i = l; i <= r; i++){
            if(flag && str[i] == 'R')
                count++;
            if(!flag && str[i] == 'G')
                count++;
        }
        return count;
    }

}
