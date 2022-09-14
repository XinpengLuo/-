package 左神.字符串.串联字符串的最大长度;

import java.util.*;

public class Solution {
    int res = 0;
    public int maxLength(List<String> arr) {
        dfs(0,arr,0,0);
        return res;
    }
    public void dfs(int state, List<String> str, int index, int temp){
        if(index == str.size()) {
            res = Math.max(temp, res);
            return;
        }

        String cur = str.get(index);
        boolean flag = true;
        int tempState = 0;
        for(int i = 0; i < cur.length(); i++) {
            int j =  (cur.charAt(i) - 'a');
            if(((tempState >> j) & 1) == 1){
                flag = false;
                break;
            }
            tempState = tempState | (1 << j);
        }
        for(int i = 25; i >= 0; i--){
            if(((tempState >> i) & 1) == 1 && ((state >> i) & 1) == 1){
                flag = false;
                break;
            }
        }
        if(flag)
            dfs(state | tempState,str, index + 1, temp + cur.length());
        dfs(state,str,index + 1,temp);
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("z");
        Solution solution = new Solution();
        System.out.println(solution.maxLength(arr));
    }
}
