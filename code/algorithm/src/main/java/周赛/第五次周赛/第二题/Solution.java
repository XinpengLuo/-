package 周赛.第五次周赛.第二题;

public class Solution {
    public int minimumBuckets(String street) {
        int ans = 0;
        int[] temp = new int[street.length()];
        for(int i = 0; i < street.length(); i++){
            if(street.charAt(i) == 'H'){
                if(i - 1 >= 0 && temp[i - 1] == 1)
                    continue;
                else{
                    if(i + 1 < street.length() && street.charAt(i + 1) == '.'){
                        temp[i + 1] = 1;
                        ans++;
                    }
                    else if(i - 1 >= 0 && street.charAt(i - 1) == '.')
                    {
                        temp[i - 1] = 1;
                        ans++;
                    }
                    else
                        return -1;
                }
            }
        }
        return ans;
    }

}
