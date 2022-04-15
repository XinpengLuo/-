package 基本数据结构.递归;

public class Maze {
    //创建一个二维数组 模拟迷宫
    private int[][] map = new int[8][7];
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.initMaze();
        maze.setWay(1,1);
        for (int[] ints : maze.map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    public void initMaze()
    {
        //用1表示墙 先上下置为1
        for (int i = 0; i < 7; i++)
        {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1
        for (int i = 1; i < 7; i++)
        {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
    }
    //map表示地图 小球从（1，1）出发 到（6，5）结束 当map[i][j] == 1为0时 还没走过 为1时 代表墙 为2 表示通路 3表示该点已经走过 但是走不通
    //走迷宫时要先确定一个策略 先走下 》 右 》 上 》 左
    public  boolean setWay(int i, int j)
    {
        if(map[6][5] == 2)
            return true;
        else {
            //如果当前这个点还没走过
            if(map[i][j] == 0){
                map[i][j] = 2;
                //向下走
                if(setWay(i + 1 ,j)){
                    return true;
                }
                else if(setWay(i, j + 1)){
                    return true;
                }else if(setWay(i - 1, j))
                {
                    return true;
                }else if(setWay(i, j - 1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }
            else {
                //不等于0 可能为1 2 3 都返回false
                return false;
            }
        }
    }
}
