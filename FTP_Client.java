package packetThucHanh;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FTP_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Client say Yo!");
		try {
			//Kết nối đến Server
			Socket socket = new Socket("127.0.0.1", 3000);
			//Nhận dữ liệu từ Server
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			//Chuẩn bị File Output Stream để ghi dữ liệu
			FileOutputStream fileOut = new FileOutputStream("F://Output/Prince Bojji 6.jpg");
			//Ghi file từ dataIn vào fileOut
			int len;
			byte[] data = new byte[10000];
			while ((len=dataIn.read(data))>0) {
				fileOut.write(data, 0, len);
			}
			//Lấy thông tin từ ảnh
			File anh = new File("F://Output/Prince Bojji 6.jpg");
			if (anh.exists()) {
				System.out.println("Tên File: "+anh.getName());
				System.out.println("Đường dẫn thư mục chứa: "+anh.getParent());
				System.out.println("Đường dẫn đầy đủ: "+anh.getPath());
				System.out.println("Kích thước: "+anh.length()+" byte");
			}
			//Đóng kết nối
			fileOut.close();
			dataIn.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
