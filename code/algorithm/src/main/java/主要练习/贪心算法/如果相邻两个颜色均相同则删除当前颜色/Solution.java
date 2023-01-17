package 主要练习.贪心算法.如果相邻两个颜色均相同则删除当前颜色;

public class Solution {
    int a;
    public boolean winnerOfGame(String colors) {

        int countA = 0;
        int countB = 0;
        int temp = 0;
        char curChar = 'C';
        for(int i = 0; i < colors.length(); i++){
            char c = colors.charAt(i);
            if(c != curChar){
                curChar = c;
                temp = 1;
            }
            else{
                temp++;
                if(temp >= 3){
                    if(curChar == 'A')
                        countA++;
                    else
                        countB++;
                }
            }
        }
        return countA > countB;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.a);
        Integer i1 = 1000;
        Integer i2 = 1000;
        System.out.println(i1 == i2);
    }
}
class A{
    public void printSomething(){
        System.out.println("wo shi baba");
    }
}
class B extends A{
    public void printSomething(){
        System.out.println("wo shi er zi");
    }
    public static void main(String[] args) {
        A b = new B();
        b.printSomething();
    }
}