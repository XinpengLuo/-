package 主要练习.暴力递归和动态规划.递归和回溯.刷题;

import java.util.*;

public class Solution {
    //根据电话号码求组合
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            {
                result.add("");
                return result;
            }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        //这个数组存放总共数字所对应的String
        char[] charArray = digits.toCharArray();
        String[] letters = new String[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            letters[i] = phoneMap.get(charArray[i]);
        }
        letterAdd(result,letters,-1,"");
        return result;
    }
    public void letterAdd(List result, String[] letters, int index, String temp){
        index++;
        if(index == letters.length)
            {
                result.add(temp);
                return;
            }
        String cur = temp;
        for (char c : letters[index].toCharArray()) {
            temp = cur + String.valueOf(c);
            letterAdd(result,letters,index, temp);
        }
    }

    //第K个语法符号
    public int kthGrammar(int N, int K) {
        if(N == 0)
            return 0;
        if(K % 2 != 0)
            return kthGrammar(N - 1, (K + 1) / 2);
        else
            return Math.abs(kthGrammar(N - 1, K / 2) - 1);
    }
    //组合
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineHelp(n,k,new ArrayList<>(),result,1);
        return result;
    }
    public void combineHelp(int n,int k,List<Integer> list,List<List<Integer>> res,int temp){
        if(k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = temp; i <= n; i++) {
            if(!list.contains(i)){
                list.add(i);
                combineHelp(n,k - 1,list,res,i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    //组合总和
    List<List<Integer>> combinationRes = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelp(candidates,target,0,new ArrayList<>(),0);
         return combinationRes;
    }
    public void combinationSumHelp(int[] arr, int target, int sum, List<Integer> list,int temp){
        if(sum > target)
            return;
        if(sum == target){
            combinationRes.add(new ArrayList<>(list));
            return;
        }
        for (int i = temp; i < arr.length; i++) {
            list.add(arr[i]);
            combinationSumHelp(arr,target,sum + arr[i],list,i);
            list.remove(list.size() - 1);
        }
    }

    //组合总和II
    HashSet<List<Integer>> combination2Res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        combinationSum2Help(candidates,target,0,new ArrayList<>(),0);
        return new ArrayList<>(combination2Res);
    }
    public void combinationSum2Help(int[] arr, int target, int sum, List<Integer> list,int temp){

        if(sum > target)
            return;
        if(sum == target){
            combination2Res.add(new ArrayList<>(list));

            return;
        }
        for (int i = temp; i < arr.length;i++) {
            list.add(arr[i]);
            combinationSum2Help(arr,target,sum + arr[i],list,i + 1);
            list.remove(list.size() - 1);
        }
    }

    //组合总和 III
    List<List<Integer>> combination3Res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3Help(k,n,new ArrayList<>(),1,0);
        return combination3Res;
    }
    public void combinationSum3Help(int k,int n,List<Integer> list,int temp,int sum){
        if(k == 0){
            if(sum == n)
                combination3Res.add(new ArrayList<>(list));
            return;
        }
        for(int i = temp; i <= 9; i++){
            if(!list.contains(i)){
                list.add(i);
                combinationSum3Help(k - 1, n ,list, i + 1, sum + i);
                list.remove(list.size() - 1);
            }
        }
    }

    //组合总和IV
    int countCombination = 0;
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        combinationSum4Help(nums,target,0);
        return countCombination;
    }
    public void combinationSum4Help(int[] nums, int target, int sum){
        if(sum > target)
            return;
        if(sum == target){
            countCombination++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            combinationSum4Help(nums,target,sum + nums[i]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,1,3};

        System.out.println(solution.combinationSum4(arr, 35));

    }
}
