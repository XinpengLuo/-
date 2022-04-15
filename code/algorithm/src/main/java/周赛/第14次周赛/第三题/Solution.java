package 周赛.第14次周赛.第三题;

public class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (sum / k == 0)
            return 0;
        long res = 0;
        long max = (int) (sum / k);
        long left = 0, right = max;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (middle == 0) {
               left = middle + 1;
               continue;
            }
                long count = 0;
                for (int candy : candies) {
                    count += (candy / middle);
                }
                if (count < k) {
                    right = middle - 1;
                } else {
                    res = middle;
                    left = middle + 1;
                }
            }
        return (int) res;
    }

    public static void main(String[] args) {

    }
}
