import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Hello World! Start now");
        System.out.println("my ip adress is: "+ Inet4Address.getLocalHost());
    }
}
