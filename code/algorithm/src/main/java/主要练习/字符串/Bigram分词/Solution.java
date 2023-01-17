package 主要练习.字符串.Bigram分词;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> temp = new ArrayList<>();
        int index = 0;
        while (index < split.length){
            if(index + 2 < split.length){
                if(split[index].equals(first) && split[index + 1].equals(second))
                    {
                        temp.add(split[index + 2]);

                    }
                index++;
            }
            else
                break;
        }
        String[] ans = new String[temp.size()];
        for(int i = 0; i < ans.length; i++)
            ans[i] = temp.get(i);
        return ans;
    }
}
