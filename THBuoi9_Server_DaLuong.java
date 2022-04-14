package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class StringThread extends Thread{

	Socket socket;
	
	
	
	public StringThread(Socket socket) {
		super();
		this.socket = socket;
	}



	public void run() {
		System.out.println("Đang xử lý luồng"+Thread.currentThread().getId());
		try {
			DataInputStream datain = new DataInputStream(socket.getInputStream());
			DataOutputStream dataout = new DataOutputStream(socket.getOutputStream());
			
			while (true) {
				String strIn = datain.readUTF().trim();
				if (strIn.equals("exit")) {
					System.out.println("Đã dừng luồng "+Thread.currentThread().getId());
					break;
				} 
				strIn = strIn.replaceAll("\\s+", " ");
				String strOut = strIn.substring(0,1).toUpperCase()+strIn.substring(1,strIn.length()).toLowerCase();
				dataout.writeUTF("Server trả chuỗi sau chuẩn hóa: "+strOut);
				dataout.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class THBuoi9_Server_DaLuong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Phía Server đã chạy.");
		try (ServerSocket svSocket = new ServerSocket(3000)) {

			while (true) {
				Socket Socket = svSocket.accept();
	
				StringThread stringThread = new StringThread(Socket);
				stringThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
