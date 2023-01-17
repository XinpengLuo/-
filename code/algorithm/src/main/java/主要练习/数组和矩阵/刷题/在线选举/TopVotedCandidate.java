package 主要练习.数组和矩阵.刷题.在线选举;

import java.util.ArrayList;
import java.util.HashMap;

class TopVotedCandidate {
    HashMap<Integer,Integer> map = new HashMap<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    int[] persons;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        int top = -1;
        for(int i = 0; i < persons.length; i++){
            map.put(persons[i],map.getOrDefault(persons[i],0) + 1);
            if(top == -1 || map.get(persons[i]) >= map.get(top))
                top = persons[i];
            arrayList.add(top);
        }
        System.out.println(1);
    }
    public int getIndex(int target){
        int l = 0;
        int r = times.length - 1;
        int ans = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (times[mid] <= target){
                ans = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
    public int q(int t) {
        return arrayList.get(getIndex(t));
    }

    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate top = new TopVotedCandidate(persons,times);
        System.out.println(top.q(3));
    }
}


