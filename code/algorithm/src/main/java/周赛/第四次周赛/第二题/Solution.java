package 周赛.第四次周赛.第二题;

public class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0, full = capacity;
        for(int i = -1; i < plants.length - 1; i++){
            if(capacity >= plants[i + 1])
                {
                    ans++;
                    capacity -= plants[i + 1];}
            else{
                ans += (i + 1 + i + 1) + 1;
                capacity = full - plants[i + 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7,7,7,7,7,7,7};
        System.out.println(solution.wateringPlants(arr, 8));
    }
}
