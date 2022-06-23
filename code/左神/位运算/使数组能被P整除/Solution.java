package 左神.位运算.使数组能被P整除;

import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public int minSubarray(int[] nums, int p) {
        /*
            1. 假设有一个前缀数组 则数组所有的总和为total
            2. 假设移除的区间的左端点为i 右端点为j 则移除的和为 sum[j] - sum[i - 1]
            3. 我们要求的 (total - range) % p = 0 --> total % p = range % p --> sum[j] % p - sum[i - 1] % p = total % p
            4. (sum[i - 1] + total) % p = sum[j] % p
         */
        int res = nums.length;
        long[] sum = new long[nums.length];
        long temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp += nums[i];
            sum[i] = temp;
        }
        long total = temp;
        if(total % p == 0)
            return 0;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0l,-1);
        for(int i = 0; i < sum.length; i++){
            long target = sum[i] % p;
            if(map.containsKey(target))
                res = Math.min(res, i - map.get(target));
            map.put((sum[i] + total) % p, i);
        }
        return res == nums.length ? -1 : res;
    }
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8)
            return false;
        String temp = "!@#$%^&*()-+";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < temp.length(); i++) {
            set.add(temp.charAt(i));
        }
        boolean low = false;
        boolean up = false;
        boolean num = false;
        boolean spe = false;
        char pre = ' ';
        int index = 0;
        while (index < password.length()){
            char c = password.charAt(index);
            if(c == pre)
                return false;
            if(Character.isLowerCase(c))
                low = true;
            else if (Character.isUpperCase(c))
                up = true;
            else if (Character.isDigit(c))
                num = true;
            else if(set.contains(c))
                spe = true;
            index++;
            pre = c;
        }
        return low && up && num && spe;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        long[] newPotions = new long[potions.length];
        for(int i = 0; i < potions.length; i++)
            newPotions[i] = potions[i];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int left = 0;
            int right = newPotions.length - 1;
            int index = -1;
            while (left <= right){
                int middle = left + (right - left) / 2;
                long temp = newPotions[middle] * spell;
                if(temp >= success){
                    index = middle;
                    right = middle - 1;
                }
                else
                    left = middle + 1;
            }
            if(index != -1){
                res[i] = newPotions.length - index;
            }
        }
        return res;
    }
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        if(sub.length() > s.length())
            return false;
        HashMap<Character,HashSet<Character>> map = new HashMap<>();
        for (char[] mapping : mappings) {
            char oldChar = mapping[0];
            char newChar = mapping[1];
            HashSet<Character> temp;
            if(map.containsKey(oldChar))
                temp = map.get(oldChar);
            else
                temp = new HashSet<>();
            temp.add(newChar);
            map.put(oldChar,temp);
        }
        for(int i = 0; i < s.length() - sub.length(); i++){
            boolean flag = true;
            for(int j = 0; j < sub.length(); j++){
                if(s.charAt(i + j) == sub.charAt(j))
                    continue;
                char oldChar = sub.charAt(j);
                char targetChar = s.charAt(i + j);
                if(!map.containsKey(oldChar) || !map.get(oldChar).contains(targetChar)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        int j = 0;
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            long temp = sum * (i - j + 1);
            while(temp >= k){
                sum -= nums[j];
                j++;
                temp = sum * (i - j + 1);
            }
            res += (i - j);
        }
        return res;
    }
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += map.getOrDefault(nums[i] + k,0);
            map.put(nums[i], 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        Solution solution = new Solution();

    }
}
