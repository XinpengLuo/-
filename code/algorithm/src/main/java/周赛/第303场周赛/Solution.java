package 周赛.第303场周赛;

import java.util.*;

/**
 * @author luoxinpeng
 */
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        List<String> row = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++)
                sb.append(grid[i][j] + " ");
            row.add(sb.toString());
        }
        List<String> col = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++)
                sb.append(grid[j][i] + " ");
            col.add(sb.toString());
        }
        for(int i = 0; i < n; i++){
            String temp = row.get(i);
            for(int j = 0; j < n; j++)
                if(col.get(j).equals(temp))
                    count++;
        }
        return count;
    }
    public long countExcellentPairs(int[] nums, int k) {
        long count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            set.add(num);
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            arr[index] = integer;
            index++;
        }
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i; j < arr.length; j++){
                int a = arr[i] | arr[j];
                int b = arr[i] & arr[j];
                if(Integer.bitCount(a) + Integer.bitCount(b) >= k) {
                    if(i == j){
                        count++;
                    }else{
                    count += 2;
                }
            }
        }
    }
        return count;
    }
    public static void main(String[] args) {
        int[][] arr = {{11,1},{1,11}};
        Solution solution = new Solution();
        System.out.println(solution.equalPairs(arr));
    }
}
class Food{
    int rating;
    String name;
    String cuis;
    public Food(int rating, String name, String cuis){
        this.rating = rating;
        this.name = name;
        this.cuis = cuis;
    }
}
class FoodRatings {
    HashMap<String,PriorityQueue<Food>> rateToFoodName = new HashMap<>(); //通过烹饪方式找到对应的食物以及他们的评分
    HashMap<String,Food> map = new HashMap<>(); //通过食物的名字找到对应的食物
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0; i < n; i++){
            Food food = new Food(ratings[i],foods[i],cuisines[i]);
            map.put(foods[i],food);
            PriorityQueue<Food> queue = rateToFoodName.get(cuisines[i]);
            if(queue == null) {
                queue = new PriorityQueue<>(new Comparator<Food>() {
                    @Override
                    public int compare(Food f1, Food f2) {
                        if(f2.rating != f1.rating) {
                            return f2.rating - f1.rating;
                        }
                        return f1.name.compareTo(f2.name);
                    }
                });
            }
            queue.add(food);
            rateToFoodName.put(cuisines[i],queue);
        }
    }

    public void changeRating(String food, int newRating) {
        Food node = map.get(food);
        PriorityQueue<Food> queue = rateToFoodName.get(node.cuis);
        queue.remove(node);
        node.rating = newRating;
        queue.add(node);
        HashSet<Integer> set=  new HashSet<>();

    }

    public String highestRated(String cuisine) {
        return rateToFoodName.get(cuisine).peek().name;
    }
}