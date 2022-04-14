package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class THBuoi9_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Client đã chạy");
		try {
			
			Socket socket = new Socket("127.0.0.1",3000);
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("Nhập nội dung: ");
				String strOut = sc.nextLine();
				dataOut.writeUTF(strOut);
				dataOut.flush();
				if (strOut.equals("exit")) {
					break;
				}
				String strIn = dataIn.readUTF();
				System.out.println(strIn);
			}
			sc.close();
			dataIn.close();
			dataOut.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
