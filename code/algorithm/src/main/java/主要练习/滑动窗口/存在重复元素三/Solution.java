package 主要练习.滑动窗口.存在重复元素三;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate() {
      TreeSet<Integer> set = new TreeSet<>();
      set.add(2);
      set.add(2);
      return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.containsNearbyAlmostDuplicate();
    }
}
