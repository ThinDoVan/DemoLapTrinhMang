package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCP_DaLuong_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Phía Client đã chạy");
		try {
			Socket socket = new Socket("127.0.0.1", 3000);
			DataOutputStream data_out = new DataOutputStream(socket.getOutputStream());
			DataInputStream data_in = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print("Nội dung gửi: ");
				String data = sc.nextLine();
				data_out.writeUTF(data);
				data_out.flush();
				if (data.equals("exit")) {
					break;
				}
				String ketqua = data_in.readUTF();
				System.out.println("Kết quả là: "+ketqua);
			}
			
			socket.close();
			data_out.close();
			data_in.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
