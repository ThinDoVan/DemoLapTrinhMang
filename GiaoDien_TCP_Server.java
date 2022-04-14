package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GiaoDien_TCP_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Phía Server đã chạy.");
		try {
			ServerSocket sv_socket = new ServerSocket(3000);
			Socket socket = sv_socket.accept();
			DataInputStream data_in = new DataInputStream(socket.getInputStream());
			DataOutputStream data_out = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				String chuoi = data_in.readUTF();
				if (chuoi.equals("exit")) {
					break;
				}
				data_out.writeUTF("Server trả: đã nhận thông tin " + chuoi);
				data_out.flush();
			}
					
			sv_socket.close();
			socket.close();
			data_in.close();
			data_out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
