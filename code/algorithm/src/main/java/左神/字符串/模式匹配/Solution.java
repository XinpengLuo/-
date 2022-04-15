package 左神.字符串.模式匹配;

public class Solution {
    public boolean patternMatching(String pattern, String value) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'a')
                a++;
            if(pattern.charAt(i) == 'b')
                b++;
        }
        if(value.equals("")){
            if(pattern.equals(""))
                return true;
            else
                {
                    return (a == 0 && b != 0) || (a != 0 && b == 0);
                }
        }
        if(pattern.equals("") && !value.equals(""))
            return false;
        String tempA = "", tempB = "";
        if(a == 0){
            a = b;
            b = 0;
            pattern = pattern.replace('b','a');
        }
        //求到了有几个a 几个b以后 还是试探其长度 以a来试探 a的长度是0 到 value.length / patter中a的个数
        for(int i = 0; i <= value.length() / a; i++){ //此时 i 代表 a的长度
            int j = b == 0 ? 0 : (value.length() - a * i) / b; //此时 j 代表b 的长度
            boolean flag = true;
            System.out.println("a的长度: " + i + " b的长度: " + j);
            int indexValue = 0;
            for (int index = 0; index < pattern.length(); index++) { //开始依据假设的长度来遍历字符串
                if(pattern.charAt(index) == 'a'){
                    String substring = value.substring(indexValue, indexValue + i);
//                    System.out.println(substring);
                    if(tempA.equals(""))
                        tempA = substring;
                    else
                        if(!tempA.equals(substring)){
                            flag = false;
                            break;
                        }
                    indexValue += i;
                }
                else if (pattern.charAt(index) == 'b'){
                    String substring = value.substring(indexValue, indexValue + j);
                    if(tempB.equals(""))
                        tempB = substring;
                    else
                        if(!tempB.equals(substring)){
                            flag = false;
                            break;
                        }
                    indexValue += j;
                }
            }

            System.out.println("没有成功匹配后的a：" + tempA + " 没有匹配后的b: " + tempB);
            if(flag && !tempA.equals(tempB) && indexValue == value.length())
                {
                    System.out.println("匹配后的a：" + tempA + " 匹配后的b: " + tempB);
                    System.out.println(indexValue );
                    return true;
                }
            tempA = "";
            tempB = "";
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String patter = "bbbaa";
        String value = "xxxxxxy";
        System.out.println("模式：" + patter);
        System.out.println("字符：" + value);
        System.out.println(solution.patternMatching(patter,value));
    }
}
