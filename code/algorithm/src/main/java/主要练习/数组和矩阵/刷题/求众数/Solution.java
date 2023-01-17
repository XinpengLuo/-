package 主要练习.数组和矩阵.刷题.求众数;

import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int minTime = nums.length / 3;
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums);
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if(count > minTime)
                res.add(nums[i]);
            if(i + 1 < nums.length && nums[i + 1] == nums[i])
                count++;
            else
                count = 1;
        }
        return new ArrayList<>(res);
    }
    public List<Integer> findBetter(int[] nums){
        //候选人是2个
        int canA = 0, canB = 0, hpA = 0, hpB = 0;
        for(int i = 0; i < nums.length; i++){
            if(hpA == 0 && nums[i] != canB)
            {
                canA = nums[i];
                hpA++;
            }
            else if(canA == nums[i])
                hpA++;
            else if(hpB == 0)
            {
                canB = nums[i];
                hpB++;
            }
            else if(canB == nums[i])
                hpB++;
            else{
                hpA--;
                hpB--;
            }
        }
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < nums.length; i++){
            if(hpA != 0 && nums[i] == canA)
                countA++;
            if(hpB != 0 && nums[i] == canB)
                countB++;
        }
        List<Integer> res = new ArrayList<>();
        if(countA > nums.length / 3 )
            res.add(canA);
        if(countB > nums.length / 3)
            res.add(canB);
        return res;
    }
    public List<Integer> test(int[] nums){

            int element1 = 0;
            int element2 = 0;
            int vote1 = 0;
            int vote2 = 0;

            for (int num : nums) {
                if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
                    vote1++;
                } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
                    vote2++;
                } else if (vote1 == 0) { // 选择第一个元素
                    element1 = num;
                    vote1++;
                } else if (vote2 == 0) { // 选择第二个元素
                    element2 = num;
                    vote2++;
                } else { //如果三个元素均不相同，则相互抵消1次
                    vote1--;
                    vote2--;
                }
            }
            System.out.println(element1 + " " + vote1);
            System.out.println(element2 + " " + vote2);
            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && num == element1) {
                    cnt1++;
                }
                if (vote2 > 0 && num == element2) {
                    cnt2++;
                }
            }
            // 检测元素出现的次数是否满足要求
            List<Integer> ans = new ArrayList<>();
            if (vote1 > 0 && cnt1 > nums.length / 3) {
                ans.add(element1);
            }
            if (vote2 > 0 && cnt2 > nums.length / 3) {
                ans.add(element2);
            }

            return ans;
        }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,0,0};
        List<Integer> list = solution.findBetter(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
