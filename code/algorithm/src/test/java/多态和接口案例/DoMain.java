package 多态和接口案例;

public class DoMain {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.powerOn();
        //准备一个鼠标
        Mouse mouse = new Mouse();
        computer.useDevice(mouse);
        //创建一个键盘
        KeyBoard keyBoard = new KeyBoard();
        computer.useDevice(keyBoard);
        computer.powerClose();
    }
}
