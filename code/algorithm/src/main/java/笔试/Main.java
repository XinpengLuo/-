package 笔试;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int m = 0, n = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            m = scanner.nextInt();
            n = scanner.nextInt();
        }
        String[] board = new String[n];
        for(int i = 0; i < n; i++)
            board[i] = scanner.next();
        String command = "";
        command = scanner.next();
        Main solution = new Main();
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            String temp = board[i];
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == '*'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        System.out.println(solution.getAnswer(board, x, y, command));
    }
    public int getAnswer(String[] board, int x, int y, String command){
        int res = 0;
        for (int i = 0; i < command.length(); i++) {
            char temp = command.charAt(i);
            if(temp == 'W')
                x--;
            else if(temp == 'S')
                x++;
            else if(temp == 'A')
                y--;
            else if(temp == 'D')
                y++;
            if(x >= board.length || x < 0 || y >= board[0].length() || y < 0)
                break;
            if(board[x].charAt(y) == '$')
                res++;
        }
        return res;
    }

}
