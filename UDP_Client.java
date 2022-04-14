package packetThucHanh;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_Client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Client đã chạy");
		//Tạo đối tượng DatagramSocket
		DatagramSocket socket = new DatagramSocket();
		//Khai báo xuất
		Scanner sc = new Scanner(System.in);
		System.out.print("Nội dung bạn muốn gửi: ");
		String str_gui = sc.nextLine();
		byte[] bufout = str_gui.getBytes();
		//�?óng gói dữ liệu
		InetAddress server = InetAddress.getByName("localhost");
		DatagramPacket dataOut = new DatagramPacket(bufout, bufout.length, server, 3000);
		socket.send(dataOut);
		//Khai báo nhận
		byte[] bufin = new byte[1024];
		DatagramPacket dataIn = new DatagramPacket(bufin, bufin.length);
		//Ch�? nhận dữ liệu
		socket.receive(dataIn);
		String str_nhan = new String(dataIn.getData(), 0, bufin.length);
		System.out.print("Client báo: " + str_nhan);
		//�?óng kết nối
		socket.close();
		sc.close();
	}

}
