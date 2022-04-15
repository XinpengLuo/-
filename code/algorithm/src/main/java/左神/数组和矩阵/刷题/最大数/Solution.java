package 左神.数组和矩阵.刷题.最大数;

public class Solution {
    public String largestNumber(int[] nums) {
        return largestNumber(nums,0,"");
    }
    public String largestNumber(int[] nums, int index, String temp) {
        if(index == nums.length)
            return temp;
        String res = "0";
        for(int i = index; i < nums.length; i++){
            swap(nums,i,index);
            String cur = largestNumber(nums,index + 1, temp + String.valueOf(nums[index]));
            if(compareString(cur,res))
                res = cur;
            swap(nums,i,index);
        }
        return res;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public boolean compareString(String a, String b){
        if(a.length() > b.length())
            return true;
        else if(a.length() < b.length())
            return false;
        else{
            for (int i = 0; i < a.toCharArray().length; i++) {
                if(Integer.valueOf(a.charAt(i)) - '0' < Integer.valueOf(b.charAt(i)) - '0')
                    return false;
                else if(Integer.valueOf(a.charAt(i)) - '0' > Integer.valueOf(b.charAt(i)) - '0')
                    return true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {
                0,9,8,7,6,5,4,3,2,1};
        System.out.println(solution.largestNumber(nums));
    }
}
