package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ThreadReply extends Thread{
	int id;
	Socket clientSocket;
	
	//Khởi tạo
	public ThreadReply(int id, Socket clientSocket) {
		this.id = id;
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		//Lấy ID hệ thống của luồng đang xử lý
		System.out.println("Đang xử lý luồng "+Thread.currentThread().getId());
		try {
			DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
			while(true) {
				String str = dataIn.readUTF();
				System.out.println("ID: "+id + " xử lý: "+str);
				if (str.equals("exit")) {
					System.out.println("Đã dừng luồng "+id);
					break;
				}
				dataOut.writeUTF("Server xử lý "+str);
				dataOut.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class TCP_DaLuong_Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Phía Server đã chạy.");
		try (ServerSocket serverSocket = new ServerSocket(3000)) {
			int luong=0;
			while (true) {
				//chờ kết nối
				Socket clientSocket = serverSocket.accept();
				//mỗi lần kết nối tạo 1 luồng mới
				ThreadReply threadreply = new ThreadReply(luong++, clientSocket);
				threadreply.start();
			}
		}
	}

}
