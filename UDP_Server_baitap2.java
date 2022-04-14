package packetThucHanh;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server_baitap2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Server đang chạy.");
		
		DatagramSocket socketNhan = new DatagramSocket(3000);
		DatagramSocket socketGui = new DatagramSocket();
		
			byte[] bufIn= new byte[1024];
			DatagramPacket dataIn = new DatagramPacket(bufIn, bufIn.length);
			socketNhan.receive(dataIn);
			String strIn = new String(dataIn.getData(), 0, bufIn.length);
			
			StringBuilder str = new StringBuilder(strIn.trim());
			String strOut = "Server đã nhận: " + str.reverse().toString();
			byte[] bufOut = strOut.getBytes();
			DatagramPacket dataOut = new DatagramPacket(bufOut, bufOut.length, dataIn.getAddress(), dataIn.getPort());
			socketGui.send(dataOut);
		
		
		socketNhan.close();
		socketGui.close();
		
	}

}
