package 主要练习.二分总结.运动员和训练师的最大匹配数;

import java.util.*;

public class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int res = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0, j = 0;
        while (i < players.length && j < trainers.length){
            int temp = players[i];
            while (j < trainers.length && trainers[j] < temp)
                j++;
            if(j != trainers.length)
            {
                i++;
                res++;
                j++;
            }
        }
        return res;
    }

}
