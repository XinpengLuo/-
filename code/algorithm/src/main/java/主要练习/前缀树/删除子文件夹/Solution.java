package 主要练习.前缀树.删除子文件夹;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        for(int i = 0; i < folder.length;){
            res.add(folder[i]);
            String temp = folder[i] + "/";
            int k = i + 1;
            while (k < folder.length && folder[k].startsWith(temp))
                k++;
            i = k;
        }
        return res;
    }
}
