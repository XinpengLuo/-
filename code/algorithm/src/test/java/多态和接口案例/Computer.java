package 多态和接口案例;

public class Computer {
    public void powerOn()
    {
        System.out.println("开机");
    }
    public void powerClose()
    {
        System.out.println("关机");
    }
    //使用设备的方法
    public void useDevice(USB usb)
    {
        usb.open();
        usb.close();
        if(usb instanceof Mouse)
        {
            ((Mouse)usb).click();
        }
        if(usb instanceof KeyBoard){
            ((KeyBoard)usb).typing();
        }
    }
}
