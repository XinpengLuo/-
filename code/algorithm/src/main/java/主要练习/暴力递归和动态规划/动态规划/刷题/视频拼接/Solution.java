package 主要练习.暴力递归和动态规划.动态规划.刷题.视频拼接;

import java.util.*;

public class Solution {
    public int videoStitching(int[][] clips, int time) {
        //-----
        // --------
        //   ---------------
        //             -----------

        Arrays.sort(clips, (t1, t2) -> {
            if(t1[0] == t2[0])
                return t1[1] - t2[1];
            return t1[0] - t2[0];
        });
        if(clips[0][0] != 0)
            return -1;
        int cover = 0, index = 0, count = 0;
        while(index < clips.length){
            int last = 0;
            while (index < clips.length && clips[index][0] <= cover){
                if(clips[index][1] > last){
                    last = clips[index][1];
                }
                index++;
            }
            if(last == 0)
                return -1;
            count++;
            cover = last;
            if(cover >= time)
                break;
        }
        return cover < time ? -1 : count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0,2},{4,6},{8,10},{1,9},{1,5}};
        System.out.println(solution.videoStitching(arr, 10));
    }
}
