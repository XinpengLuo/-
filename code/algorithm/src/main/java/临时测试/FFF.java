package 临时测试;

public class FFF {
    public static String restoreString(String s, int[] indices) {
        char[] characters = new char[indices.length];
        for (int i = 0; i < s.toCharArray().length; i++) {
            characters[indices[i]] = s.charAt(i);
        }
        return new String(characters);
    }
    int minPath = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        minPathSum(grid,0,0,0);
        return minPath;
    }
    public void minPathSum(int[][] grid, int tempSum,int i, int j) {
        if(i >= grid.length || j >= grid[0].length){
            return;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1){
            minPath = Math.min(minPath,tempSum + grid[i][j]);
        }
        minPathSum(grid,tempSum + grid[i][j],i + 1,j);
        minPathSum(grid,tempSum + grid[i][j],i,j+ 1);
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1[0].charAt(0) != word2[0].charAt(0))
            return false;
        StringBuilder s1 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }
        StringBuilder s2 = new StringBuilder();
        for (String s : word2) {
            s2.append(s);
        }
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        return s1.toString().equals(s2.toString());
    }

    public void heapInsert(int[] nums, int i){
        while (nums[i] > nums[(i - 1) / 2]){
            swap(nums,i,(i - 1) / 2);
            i = (i - 1) / 2;
        }

    }
    public void heapFy(int[] nums, int index, int size){
        int leftIndex = index * 2 + 1;
        while (leftIndex < size){
            int largest = leftIndex + 1 < size && nums[leftIndex + 1] > nums[leftIndex] ? leftIndex + 1 : leftIndex;
            largest = nums[index] > nums[largest] ? index : largest;
            if(largest == index)
                break;
            swap(nums,largest,index);
            index = largest;
            leftIndex = index * 2 + 1;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++)
            heapInsert(nums,i);
        int index = nums.length - k + 1;
        int size = nums.length;
        while (k-- > 0){
            swap(nums,0,size - 1);
            size--;
            heapFy(nums,0,size);
        }
        return nums[index - 1];
        }


    public static void main(String[] args) {
        FFF test = new FFF();
        int[] arr = {3,2};
        System.out.println(test.findKthLargest(arr, 2));
        Double sum = 0.0;
    }
}
