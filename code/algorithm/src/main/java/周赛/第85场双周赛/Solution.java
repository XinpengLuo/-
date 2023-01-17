package 周赛.第85场双周赛;

import java.util.*;

public class Solution {

    public int minimumRecolors(String blocks, int k) {
        int countB = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'B')
                countB++;
            if(i >= k - 1){
                res = Math.min(res, Math.abs(countB - k));
                if(blocks.charAt(j) == 'B')
                    countB--;
                j++;
            }
        }
        return res;
    }
    public int secondsToRemoveOccurrences(String s) {
        int res = 0;
        while (true){
            String temp = s.replace("01", "10");
            if(temp.equals(s))
                break;
            res++;
            s = temp;
        }
        return res;
    }
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length()];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            if(direction == 1){
                diff[start] = (diff[start] + 1) % 26;
                if(end + 1 < diff.length)
                    diff[end + 1] = (diff[end + 1] - 1 + 26) % 26;
            }
            else{
                diff[start] = (diff[start] - 1 + 26) % 26;
                if(end + 1 < diff.length)
                    diff[end + 1] = (diff[end + 1] + 1 ) % 26;
            }
        }
        for(int i = 1; i < diff.length; i++)
            diff[i] += diff[i - 1];
        char[] res = s.toCharArray();
        for(int i = 0; i < diff.length; i++){
            if(diff[i] == 0)
                continue;
            char c = res[i];
            if(diff[i] < 0){
               res[i] = (char) ('a' +  (c - 'a' + 26 + diff[i]) % 26);
            }
            else
                res[i] = (char) ('a' + (c - 'a' + diff[i]) % 26);
        }
        return String.valueOf(res);
    }

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        long[] res = new long[removeQueries.length];
        PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long t1, Long t2) {
                if(t2 > t1)
                    return 1;
                else if(t2.equals(t1))
                    return 0;
                else
                    return -1;
            }
        });
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        for(int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + nums[i];
        List<Integer> removeIndex = new ArrayList<>();
        queue.add(preSum[preSum.length - 1]);
        for (int i = 0; i < removeQueries.length; i++) {
            int leftIndex = findFirstLessIndex(removeIndex,removeQueries[i]);
            int rightIndex = findFirstGreatIndex(removeIndex,removeQueries[i]);
            long leftSum = leftIndex == -1 ? preSum[removeQueries[i]] - nums[removeQueries[i]] : preSum[removeQueries[i]] - preSum[leftIndex] - nums[removeQueries[i]];
            long rightSum = rightIndex == -1 ? preSum[preSum.length - 1] - preSum[removeQueries[i]] : preSum[rightIndex] - preSum[removeQueries[i]] - nums[rightIndex];
            long sum = leftSum + rightSum + nums[removeQueries[i]];
            queue.remove(sum);
            queue.add(leftSum);
            queue.add(rightSum);
            insert(removeIndex,removeQueries[i]);
            res[i] = queue.peek();

        }
        return res;
    }
    public int findFirstLessIndex(List<Integer> list, int target){
        int left = 0, right = list.size() - 1;
        int index = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) < target){
                index = list.get(mid);
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return index;
    }

    public int findFirstGreatIndex(List<Integer> list, int target){
        int left = 0, right = list.size() - 1;
        int index = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) > target){
                index = list.get(mid);
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return index;
    }

    public void insert(List<Integer> list, int target){
        if(list.isEmpty()){
            list.add(target);
            return;
        }
        int left = 0, right = list.size() - 1, index = list.size();
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) > target){
                index = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        list.add(index,target);
    }



    public static void main(String[] args) {
        int[] nums = {3,2,11,1};
        int[] remove = {3,2,1,0};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maximumSegmentSum(nums, remove)));

    }
}
