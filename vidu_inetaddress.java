package packetThucHanh;
import java.net.*;
public class vidu_inetaddress {
	public static void main(String[] args) {
		try {
			InetAddress host = InetAddress.getByName("dantri.com.vn");
			System.out.println("Host name l�: "+host.getHostName());
			System.out.println("IP address l�: "+host.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
