package 周赛.第十三次周赛.第二题;

public class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] flag = new boolean[n * 4][n * 4];
        for (int[] temp : dig) {
            flag[temp[0]][temp[1]] = true;
        }
        int count = 0;
        for (int[] artifact : artifacts) {
            if(isValid(artifact,flag))
                count++;
        }
        return count;
    }
    public boolean isValid(int[] artifact, boolean[][] flag){
        int topLeftX = artifact[0];
        int topLeftY = artifact[1];
        int downRightX = artifact[2];
        int downRightY = artifact[3];
        boolean temp = true;
        if(topLeftX == downRightX){
            for(int i = topLeftY; i <= downRightY; i++){
                if(flag[topLeftX][i] != true){
                    temp = false;
                    break;
                }
            }
        }
        else if(topLeftX != downRightX && topLeftY != downRightY){
            if(!flag[topLeftX][topLeftY] || !flag[topLeftX][topLeftY + 1] || !flag[downRightX][downRightY - 1] || !flag[downRightX][downRightY]){
                temp = false;
            }
        }
        else if(topLeftY == downRightY){
            for(int i = topLeftX; i <= downRightX; i++)
                if(flag[i][topLeftY] != true){
                    temp = false;
                    break;
                }
        }
        return temp;
    }

    public static void main(String[] args) {
         Solution solution = new Solution();
         int[][] artifacts = {{0,0,0,0},{0,1,1,1}};
         int[][] dig = {{0,0},{0,1},{1,1}};
        System.out.println(solution.digArtifacts(2, artifacts, dig));

    }
}
