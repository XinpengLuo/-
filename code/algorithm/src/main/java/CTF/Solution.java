package CTF;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            String encoding="GBK";
            File file=new File("/Users/luoxinpeng/Downloads/学习/基础知识笔记/重学算法/algorithm/src/main/java/CTF/password.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    if(isValid(lineTxt))
                        System.out.println(lineTxt);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
    public static boolean isValid(String password){
        if(password.length() <= 8)
            return false;
        int countU = 0; //统计大写
        int countL = 0; //统计小些
        int countS = 0; //统计特殊字符
        int countN = 0; //统计数字
        for(int i = 0; i < password.length(); i++){
            char temp = password.charAt(i);
            if(Character.isDigit(temp))
                countN++;
            else if(Character.isUpperCase(temp))
                countU++;
            else if(Character.isLowerCase(temp))
                countL++;
            else
                countS++;
        }
        if(countS != 2 || countU == 0 || countL == 0 || countN == 0)
            return false;
        return true;
    }

}
