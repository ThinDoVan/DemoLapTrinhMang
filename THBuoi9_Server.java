package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class THBuoi9_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Server đã chạy");
			try {
				
				ServerSocket svSocket = new ServerSocket(3000);
				Socket socket = svSocket.accept();
				DataInputStream datain = new DataInputStream(socket.getInputStream());
				DataOutputStream dataout = new DataOutputStream(socket.getOutputStream());
				
				while (true) {
					String strIn = datain.readUTF().trim();
					if (strIn.equals("exit")) {
						break;
					} 
					strIn = strIn.replaceAll("\\s+", " ");
					String strOut = strIn.substring(0,1).toUpperCase()+strIn.substring(1,strIn.length()).toLowerCase();
					dataout.writeUTF("Server trả chuỗi sau chuẩn hóa: "+strOut);
					dataout.flush();
				}
				
				dataout.close();
				datain.close();
				socket.close();
				svSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
