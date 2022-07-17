package 周赛.第302场周赛;

import java.util.*;

/**
 * @author luoxinpeng
 */
public class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else{
                count++;
                map.remove(nums[i]);
            }
        }
        int[] res = new int[2];
        res[0] = count;
        res[1] = nums.length - 2 * count;
        return res;
    }
    public int maximumSum(int[] nums) {
        int res = -1;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = count(nums[i]);
            if(!map.containsKey(count)){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(count,list);
            }
            else {
                map.get(count).add(nums[i]);
            }
        }
        for (Integer integer : map.keySet()) {
            List<Integer> list = map.get(integer);
            if(list.size() < 2) {
                continue;
            }
            Collections.sort(list);
            res = Math.max(res, list.get(list.size() - 1) + list.get(list.size() - 2));
        }
        return res;
    }
    public int count(int num){
        int res = 0;
        while (num != 0){
            int temp = num % 10;
            res += temp;
            num /= 10;
        }
        return res;
    }


    /**
     * 输入：nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
     * 输出：[2,2,1,0]
     * 解释：
     * 1. 裁剪到只剩 1 个数位后，nums = ["2","3","1","4"] 。最小的数字是 1 ，下标为 2 。
     * 2. 裁剪到剩 3 个数位后，nums 没有变化。第 2 小的数字是 251 ，下标为 2 。
     * 3. 裁剪到剩 2 个数位后，nums = ["02","73","51","14"] 。第 4 小的数字是 73 ，下标为 1 。
     * 4. 裁剪到剩 2 个数位后，最小数字是 2 ，下标为 0 。
     *    注意，裁剪后数字 "02" 值为 2 。
     * @param nums
     * @param queries
     * @return
     */

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int k = query[1];
            int min = query[0];
            String[] arr = new String[nums.length];
            HashMap<String,List<Integer>> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                int begin = nums[i].length() - k;
                int end = nums[i].length();
                arr[i] = ((nums[i].substring(begin,end)));
                if(!map.containsKey(arr[i]))
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(arr[i],list);
                }
                else {
                    map.get(arr[i]).add(i);
                }
            }
           Arrays.sort(arr, new Comparator<String>() {
               @Override
               public int compare(String t1, String t2) {
                   return t1.compareTo(t2);
               }
           });
           String minValue = arr[min - 1];
           int count = 0;
           while(min - 1 - 1 >= 0 && arr[min - 1 - 1].equals(minValue)) {
               count++;
               min--;
           }
           res[index] = map.get(minValue).get(count);
           index++;
        }
        return res;
    }


    public int minOperations(int[] nums, int[] numsDivide) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1 - t2;
            }
        });
        for (Integer integer : map.keySet()) {
            priorityQueue.add(integer);
        }
        int count = 0;
        while (!priorityQueue.isEmpty()){
            int temp = priorityQueue.poll();
            boolean flag = true;
            for (int integer : numsDivide) {
                if(integer % temp != 0)
                {
                    flag = false;
                    count += map.get(temp);
                    break;

                }
            }
            if(flag) {
                break;
            }
        }
        return count == nums.length ? -1 : count;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3,2,4,3};
        int[] di = {9,6,9,3,15};
        System.out.println(solution.minOperations(arr, di));
    }
}
