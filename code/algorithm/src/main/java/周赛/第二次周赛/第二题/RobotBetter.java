package 周赛.第二次周赛.第二题;

public class RobotBetter {
    private int x;
    private int y;
    private String[] directionName = {"North", "East", "South", "West"};
    private int directionIndex = 1;
    private int width;
    private int height;
    private int length;
    public RobotBetter(int width, int height) {
        this.width = width;
        this.height = height;
        this.length = 2 * width + 2 * (height - 2);
        this.x = 0;
        this.y = 0;
    }

    public void move(int num) {
        num = num % length;
        if(num == 0){
            if(x == 0 && y == 0)
                this.directionIndex = 2;
            return;
        }
        int nextNum = 0;
        if(directionIndex == 0){
            if(y + num >= height){
                nextNum = num - (height - 1 - y);
                y = height - 1;
            }
            else
                y += num;

        }
        if(directionIndex == 1){
            if(x + num >= width){
                nextNum = num - (width - 1 - x);
                x = width - 1;
            }
            else
                x += num;
        }
        if(directionIndex == 2){
            if(y - num < 0){
                nextNum = num - y;
                y = 0;
            }
            else
                y -= num;
        }
        if(directionIndex == 3){
            if(x - num < 0){
                nextNum = num - x;
                x = 0;
            }
            else
                x -= num;
        }
        directionIndex = nextNum == 0 ? directionIndex : (directionIndex - 1 + 4) % 4;
        move(num);
    }

    public int[] getPos() {
        return new int[]{x,y};
    }

    public String getDir() {
        return directionName[directionIndex];
    }
}
