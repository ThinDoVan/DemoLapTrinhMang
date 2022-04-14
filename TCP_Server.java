package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
	public static void main(String[] args) {
		System.out.println("Server đã chạy");
		
		try {
			//Bước 1: Khai báo Server Socket với cổng xác định
			ServerSocket sv_socket = new ServerSocket(3000);
			//Bước 2: Đưa ServerSocket về? trạng thái chờ
			Socket socket = sv_socket.accept();
			//Bước 3: Khai báo luồng nhận và xuất
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			//Bước 4: Nhận, xử lý, gửi trả về Client
			String chuoi = dataIn.readUTF();
			String trave = "OK, Server đã nhận thông tin " + chuoi;
			dataOut.writeUTF(trave);
			dataOut.flush();
			//Bước 5: Đóng kết nối
			sv_socket.close();
			socket.close();
			dataIn.close();
			dataOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
