package CTF;

public class CTF4 {
    public static void main(String[] args) {
            long a = 951004;
            long b = 943784;
            int p = 998411;
            double x = Math.log(a) / Math.log(2);
            double y = Math.log(b) / Math.log(2);
        System.out.println(x);
        System.out.println(y);
        System.out.println(Math.pow(2,x * y) % p);
        int t = 0xe6;
        int c = 0xc6;
        int s = 0x53;
        double temp = Math.pow(2,77);
        System.out.println(39 * 156 % 101);
        System.out.println(t ^ c ^ s);
    }
}
