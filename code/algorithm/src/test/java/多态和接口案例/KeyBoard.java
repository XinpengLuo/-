package 多态和接口案例;

public class KeyBoard implements USB {

    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }
    public void typing()
    {
        System.out.println("键盘打字了");
    }
}
