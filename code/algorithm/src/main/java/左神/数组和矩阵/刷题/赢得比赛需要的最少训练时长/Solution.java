package 左神.数组和矩阵.刷题.赢得比赛需要的最少训练时长;

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        for(int i = 0; i < energy.length; i++){
            if(initialEnergy <= energy[i]) {
                int t = (energy[i] - initialEnergy + 1);
                initialEnergy += t;
                res += t;
            }
            if(initialExperience <= experience[i]) {
                int t = (experience[i] - initialExperience + 1);
                initialExperience += t;
                res += t;
            }
            initialExperience += experience[i];
            initialEnergy -= energy[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int[] arr = {1,4,3,2};
        int[] nums = {2,6,3,1};
        Solution solution = new Solution();
        System.out.println(solution.minNumberOfHours(a, b, arr, nums));
    }
}