package 周赛.第二次周赛.第二题;

import java.util.Arrays;

class Robot {

    private int width;
    private int height;
    private String[] direction;
    private int directionIndex;
    private int x;
    private int y;
    private int length;
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.length = width * 2 + (height - 2) * 2;
        this.direction = new String[]{"North", "East", "South", "West"}; //"North" 0，"East" 1，"South" 2 和 "West"  3
        this.directionIndex = 1;
    }

    public void move(int num) {
        if(num == 0)
            return;
        num = num % length;
        if(num == 0){
            if(x == 0 && y == 0)
                directionIndex = 2;
            return;
        }
        int leftMove = 0;
        if(direction[directionIndex].equals("North")){
            if(y + num >= height){
                leftMove = num - (height - 1 - y);
                y = height - 1;

            }
            else{
                y = y + num;
                return;
            }
        }
        else if(direction[directionIndex].equals("East")){
            if(x + num >= width){
                leftMove = num - (width - 1 - x );
                x = width - 1;

            }
            else{
                x = x + num;
                return;
            }
        }
        else if(direction[directionIndex].equals("South")){
            if(y - num < 0){
                leftMove = num - (y - 0);
                y = 0;

            }
            else{
                y = y - num;
                return;
            }
        }
        else{
            if(x - num < 0){
                leftMove = num - (x - 0);
                x = 0;
            }
            else{
                x = x - num;
                return;
            }
        }
        if(directionIndex == 0)
            directionIndex = 3;
        else
            directionIndex = directionIndex - 1;
        move(leftMove );
    }

    public int[] getPos() {
        return new int[]{x,y};
    }

    public String getDir() {
        return this.direction[directionIndex];
    }

}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.move(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */