package 面试真题.视野争夺;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static int getAnswer(int l, int[][] eyes){
        Arrays.sort(eyes, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0] == t2[0]) //这里怎么排都可以
                    return t2[1] - t1[1];
                return t1[0] - t2[0];
            }
        });
        int index = 0, pre = 0;
        int count = 0;
        while(index < eyes.length){
            //如果当前的起点跟上一次的终点不连续 注意5 和 6 是不连续的 5 6中间空了一段呀
            if(eyes[index][0] > pre)
                return -1;
            int max = Integer.MIN_VALUE;
            //只要遍历到的元素在上一次区间的里面 或者刚好相等 都可以作为备选元素 取右边最大的即可
            while (index < eyes.length && eyes[index][0] <= pre){
                max = Math.max(max,eyes[index][1]);
                index++;
            }
            count++;
            pre = max;
        }
      if(pre >= l)
          return count;
      return -1;
    }

    public static void main(String[] args) {
        //长度为l n个区间 选择最少的k个区间去覆盖它
        Scanner scanner = new Scanner(System.in);
        int[] first = new int[2];
        for(int i = 0; i < 2; i++)
            first[i] = scanner.nextInt();
        int l = first[1];
        int[][] eyes = new int[first[0]][2];
        for (int[] eye : eyes) {
            eye[0] = scanner.nextInt();
            eye[1] = scanner.nextInt();
        }
        System.out.println(getAnswer(l, eyes));
    }
}
