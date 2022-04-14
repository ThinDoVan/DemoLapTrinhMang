package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FTP_Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Server say Holla!");
			//Khai báo Server Socket
			ServerSocket sv_socket = new ServerSocket(3000);
			//Chờ kết nối từ phía Client
			Socket socket = sv_socket.accept();
			//Khai báo 2 luồng nhận gửi
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

			//Nhận dữ liệu từ Client
			String dataNhan = dataIn.readUTF();
			//Lấy dữ liệu từ Server trả về Client
			FileInputStream fileIn = new FileInputStream("F://Input/"+dataNhan);
			//Chuyển đổi dữ liệu sang byte
			int len = fileIn.available();
			byte[] buff = new byte[len];
			fileIn.read(buff, 0, len);
			//Truyền File đến Client
			dataOut.write(buff, 0, len);

			//Đóng kết nối
			dataOut.close();
			fileIn.close();
			dataIn.close();
			socket.close();
			sv_socket.close();
		}
		
		
	}

}
