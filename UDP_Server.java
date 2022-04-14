package packetThucHanh;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("Server đã chạy");
		//Tạo DatagramSocket với số cổng xác định
		DatagramSocket socket_nhan = new DatagramSocket(3000);
		//Khai báo bộ đệm nhập
		byte[] bufin = new byte[1024];
		//Tạo DatagramPacket
		DatagramPacket dataIn = new DatagramPacket(bufin, bufin.length);
		//Nhận từ Client
		socket_nhan.receive(dataIn);
		String str_nhan = new String(dataIn.getData(), 0, bufin.length);
		//Gửi trả Client
		String str_tra = "Server đã nhận thông tin: " + str_nhan;
		byte[] bufout = str_tra.getBytes();
		DatagramPacket dataOut = new DatagramPacket(bufout, bufout.length, dataIn.getAddress(), dataIn.getPort());
		//Thực hiện gửi
		DatagramSocket socket_gui = new DatagramSocket();
		socket_gui.send(dataOut);
		//�?óng kết nối
		socket_nhan.close();
		socket_gui.close();
	}

}
