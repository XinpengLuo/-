package 面试真题.去哪儿德州扑克;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 翻牌
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    //2 3 4 5 6 7 8 9 10 j q k A
    public String showDown (String inHand) {
        // write code here
        int[] s = new int[13];
        int[] h = new int[13];
        int[] c = new int[13];
        int[] d = new int[13];
        String[] arr = inHand.split(" ");
        for(int i = 0; i < arr.length; i++){
            char type = arr[i].charAt(0);
            int index = 0;
            if(arr[i].length() == 3)
                index = 8;
            else{
                char val = arr[i].charAt(1);
                if(val >= '2' && val <= '9')
                    index = val - '2';
                else
                {
                    if(val == 'J')
                        index = 9;
                    else if(val == 'Q')
                        index = 10;
                    else if(val == 'K')
                        index = 11;
                    else
                        index = 12;
                }
            }
            if(type == 'S')
                s[index]++;
            else if(type == 'H')
                h[index]++;
            else if(type == 'C')
                c[index]++;
            else
                d[index]++;
        }
        int[][] nums = new int[][]{s,h,c,d};
        return checkAll(nums);
    }
    public String checkAll(int[][] nums){
        for(int i = 0; i < 4; i++){
            String temp = checkHuangOrTong(nums[i]);
            if(!temp.equals(""))
                return temp;
        }
        String siTiao = checkFour(nums[0],nums[1],nums[2],nums[3]);
        if(!siTiao.equals(""))
            return siTiao;

        String huLu = checkHulu(nums[0],nums[1],nums[2],nums[3]);
        if(!huLu.equals(""))
            return huLu;

        String tongHua = checkTongHua(nums[0],nums[1],nums[2],nums[3]);
        if(!tongHua.equals(""))
            return tongHua;

        String shunZi = checkShunZi(nums[0],nums[1],nums[2],nums[3]);
        if(!shunZi.equals(""))
            return shunZi;

        String sanTiao = checkSanTiao(nums[0],nums[1],nums[2],nums[3]);
        if(!sanTiao.equals(""))
            return sanTiao;

        String liangDuiOrYiDui = checkLiangDuiOrYiDui(nums[0],nums[1],nums[2],nums[3]);
        if(!liangDuiOrYiDui.equals(""))
            return liangDuiOrYiDui;

        return "GaoPai";
    }
    public String checkHuangOrTong(int[] arr){
        boolean isTong = false;
        int n = arr.length - 1;
        if(arr[n] > 0 && arr[n - 1] > 0 && arr[n - 2] > 0 && arr[n - 3] > 0 && arr[n - 4] > 0)
            return "HuangJiaTongHuaShun";
        for(int i = n - 1; i >= 4; i--)
            if(arr[i] > 0 && arr[i - 1] > 0 && arr[i - 2] > 0 && arr[i - 3] > 0 && arr[i - 4] > 0)
                return "TongHuaShun";
        return "";
    }

    public String checkFour(int[] s, int[] h, int[] c, int[] d){
        for(int i = 0; i < s.length; i++)
            if(s[i] > 0 && h[i] > 0 && c[i] > 0 && d[i] > 0)
                return "SiTiao";
        return "";
    }

    public String checkHulu(int[] s, int[] h, int[] c, int[] d){
        HashSet<Integer> three = new HashSet<>();
        HashSet<Integer> two = new HashSet<>();
        for(int i = 0; i < s.length; i++){
            int temp = s[i] + h[i] + c[i] + d[i];
            if(temp >= 3)
                three.add(i);
            if(temp >= 2)
                two.add(i);
        }
        if(three.size() == 0 || two.size() == 0)
            return "";
        if(three.size() >= 2 || two.size() >= 2)
            return "HuLu";
        return "";
    }

    public String checkTongHua(int[] s, int[] h, int[] c, int[] d){
        for(int i = 0; i < s.length; i++){
            if(s[i] >= 5 || h[i] >= 5 || c[i] >= 5 || d[i] >= 5)
                return "TongHua";
        }
        return "";
    }

    public String checkShunZi(int[] s, int[] h, int[] c, int[] d){
        for(int i = 0; i <= 8; i++){
            boolean flag = true;
            for(int j = i; j <= i + 4; j++)
                if(s[j] == 0 && h[j] == 0 && c[j] == 0 && d[j] == 0)
                {
                    flag = false;
                    break;
                }
            if(flag)
                return "ShunZi";
        }
        return "";
    }

    public String checkSanTiao(int[] s, int[] h, int[] c, int[] d){
        int diff = 0, three = 0;
        for(int i = 0; i < 13; i++){
            int temp = s[i] + h[i] + c[i] + d[i];
            if(temp == 3)
                three++;
            if(temp != 0)
                diff++;
        }
        if(three != 0 && diff - three >= 2)
            return "SanTiao";
        return "";
    }

    public String checkLiangDuiOrYiDui(int[] s, int[] h, int[] c, int[] d){
        int two = 0;
        for(int i = 0; i < 13; i++){
            int temp = s[i] + h[i] + c[i] + d[i];
            two += temp / 2;
        }
        if(two >= 2)
            return "LiangDui";
        if(two == 1)
            return "YiDui";
        return "";
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "SA SK SQ SJ S10 H10 C9";
        System.out.println(solution.showDown(s));
    }
}