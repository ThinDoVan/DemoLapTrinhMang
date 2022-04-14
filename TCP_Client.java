package packetThucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCP_Client {
	public static void main(String[] arg) {
		System.out.println("Client đã chạy");
		try {
			//Bước 1: Tạo đối tượng Socket
			Socket socket = new Socket("127.0.0.1", 3000);
			//Bước 2: Khai báo luồn nhận và xuất
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			//Bước 3: Truy�?n dữ liệu lên Server
			//String data = "Chúc mừng năm mới";
			Scanner sc = new Scanner(System.in);
			System.out.print("Nội dung bạn muốn gửi: ");
			String data = sc.nextLine();
			dataOut.writeUTF(data);
			dataOut.flush();
			//Bước 4: Nhận dữ liệu từ Server
			String ketqua = dataIn.readUTF();
			System.out.println("Kết quả là: "+ketqua);
			//Bước 5: Giải phóng tài nguyên
			sc.close();
			socket.close();
			dataIn.close();
			dataOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
