package packetThucHanh;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_Client_baitap2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Client đang chạy");
		
		DatagramSocket socket = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		
			System.out.print("Nhập nội dung: ");
			String strOut = sc.nextLine();
			byte[] bufOut = strOut.getBytes();
			InetAddress ipServer = InetAddress.getByName("localhost");
			DatagramPacket dataOut = new DatagramPacket(bufOut, bufOut.length, ipServer, 3000);
			socket.send(dataOut);
			
			byte[] bufIn = new byte[1024];
			DatagramPacket dataIn = new DatagramPacket(bufIn, bufIn.length);
			socket.receive(dataIn);
			String strIn = new String(dataIn.getData(), 0, bufIn.length);
			System.out.println("Server trả v�?: " +strIn.trim());
			
		
		

		socket.close();
		sc.close();
	}

}
