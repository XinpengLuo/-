import 剑指offer.数组中重复的数字.FindRepeatNumber;
import 左神.暴力递归和动态规划.动态规划.刷题.和为奇数的子数组数目.Solution;

import java.util.*;

public class Test {
    public static void main(String[] args) {
      test(4);
    }
    public static void test(int n)
    {
        if(n > 2)
            test(n - 1);
        else System.out.println(n);
    }
    public static void countNumber(String string)
    {

    }
    public List<Integer> majorityElement(int[] nums) {
        int minTime = nums.length / 3;
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums);
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if(count > minTime)
                res.add(nums[i]);
            if(i + 1 < nums.length && nums[i + 1] == nums[i])
                count++;
            else
                count = 1;
        }
        return new ArrayList<>(res);
    }
}
class Person implements Comparable<Person>{
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public int age;
    private String name;
    public Person(int age, String name)
    {
        this.age = age;
        this.name = name;
    }
    @Override
    public int compareTo(Person person) {
        return this.age - person.age; //升序
    }
}
class Student{
    private Person person;
    public void test()
    {
    }
}
class leetCode{

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = 99999999;
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i + 1< arr.length; i++) {
            if(Math.abs(arr[i] - arr[i + 1]) < min){
                min = Math.abs(arr[i] - arr[i + 1]);
                result.clear();
               }
            if(Math.abs(arr[i] - arr[i + 1]) == min){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i - 1]);
                result.add(list);
            }
            }
        return result;
    }
    public int[] sumEvenAfterQuerie(int[] A, int[][] queries)
    {
        int[] target = new int[A.length];
        int sum = 0;
        for (int j : A) {
            if(j % 2 == 0) {
                sum += j;
            }
        }
        for (int i = 0; i < target.length; i++) {
            int value = queries[i][0];
            int index = queries[i][1];
            int temp = A[index];
            A[index] += value;
            if(A[index] % 2 == 0) {
                if(temp % 2 == 0 ) {
                    sum += value;
                }else {
                    sum += A[index];
                }
            }else {
                if(temp % 2 == 0) {
                    sum -= temp;
                }
            }
            target[i] = sum;
        }
        return target;
    }
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[queries.length];
        int sum = 0;
        for (int item : A) {
            if(item % 2 == 0)
                sum += item;
        }
        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0];
            int index = queries[i][1];
            int temp = A[index];
            if((temp + value) % 2 == 0)
            {
                if(temp % 2 == 0)
                    sum += value;
                else
                    sum = sum + value + temp;
            }
            else{
                if(temp % 2 == 0)
                    sum -= temp;
            }

            answer[i] = sum;
        }
        return answer;

    }
    public int minSubArrayLen(int s, int[] nums) {
       if(nums.length == 0)
           return 0;
       int start = 0;
       int end = 0;
       int result = Integer.MAX_VALUE;
       int sum = 0;
       while (end < nums.length)
       {
           sum += nums[end];
           while (sum >= s){
               result = Math.min(result, end - start + 1);
               start++;
               sum -= nums[start];
           }
           end++;
       }
       return result;
    }
    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(!Character.isSpaceChar(c) && Character.isLetterOrDigit(c))
                stack.add(Character.toLowerCase(c));
        }
        for (char c : s.toCharArray()) {
            if(!Character.isSpaceChar(c) && Character.isLetterOrDigit(c) && Character.toLowerCase(c) != stack.pop())
                return false;
        }
        return true;
    }
    public static int findSecondSmall(int[] arr){
        int first = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < first){
                second = first;
                first = arr[i];
            }
            else if(arr[i] < second){
                second = arr[i];
            }
        }
        return second;
    }
    public int leastTimeOfFarmer(){
        char[] arr = {'A','B','C'}; // A --> 空心菜 B --> 山羊 C --> 狼;
        ArrayList<Character> queueFirst = new ArrayList<>();
        ArrayList<Character> queueSecond = new ArrayList<>();
        queueFirst.add('A');
        queueFirst.add('C');
        queueSecond.add('B');

        return helpFarmer(queueFirst,queueSecond) - 1;
    }
    public int helpFarmer(ArrayList<Character> first, ArrayList<Character> second){
        System.out.println(first.size() + " " + second.size());
        if(first.size() == 0)
            return 0;
        if((first.contains('A') && first.contains('B')) || (first.contains('B') && first.contains('C'))
            ||
                (second.contains('A') && second.contains('B'))  ||   (second.contains('B') && second.contains('C'))
        )
            return 2000;
        int res = Integer.MAX_VALUE;
        int size = first.size();
        for(int i = 0; i < size; i++) {
            Character temp = first.get(i);
            first.remove(i);
            second.add(temp);
            res = Math.min(res, 2 + helpFarmer(first,second));
            first.add(temp);
            second.remove(temp);
        }

        return res;
    }
    public static void main(String[] args) {
        leetCode leetCode = new leetCode();
        System.out.println(leetCode.leastTimeOfFarmer());

    }
}