package packetThucHanh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextField;

public class FTP_Client_GiaoDien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtYeuCau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FTP_Client_GiaoDien frame = new FTP_Client_GiaoDien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FTP_Client_GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblYeuCau = new JLabel("Tên file yêu cầu");
		GridBagConstraints gbc_lblYeuCau = new GridBagConstraints();
		gbc_lblYeuCau.anchor = GridBagConstraints.WEST;
		gbc_lblYeuCau.insets = new Insets(0, 0, 5, 5);
		gbc_lblYeuCau.gridx = 1;
		gbc_lblYeuCau.gridy = 0;
		contentPane.add(lblYeuCau, gbc_lblYeuCau);
		
		txtYeuCau = new JTextField();
		GridBagConstraints gbc_txtYeuCau = new GridBagConstraints();
		gbc_txtYeuCau.gridwidth = 3;
		gbc_txtYeuCau.insets = new Insets(0, 0, 5, 5);
		gbc_txtYeuCau.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYeuCau.gridx = 2;
		gbc_txtYeuCau.gridy = 0;
		contentPane.add(txtYeuCau, gbc_txtYeuCau);
		txtYeuCau.setColumns(10);
		
		JButton btnXem = new JButton("Xem");
		
		GridBagConstraints gbc_btnXem = new GridBagConstraints();
		gbc_btnXem.insets = new Insets(0, 0, 5, 5);
		gbc_btnXem.gridx = 5;
		gbc_btnXem.gridy = 0;
		contentPane.add(btnXem, gbc_btnXem);
		
		JLabel lblTen = new JLabel("Tên ảnh: ");
		lblTen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblTen = new GridBagConstraints();
		gbc_lblTen.anchor = GridBagConstraints.WEST;
		gbc_lblTen.insets = new Insets(0, 0, 5, 5);
		gbc_lblTen.gridx = 1;
		gbc_lblTen.gridy = 1;
		contentPane.add(lblTen, gbc_lblTen);
		
		JLabel lblHTTen = new JLabel("Chưa có");
		lblHTTen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHTTen = new GridBagConstraints();
		gbc_lblHTTen.anchor = GridBagConstraints.WEST;
		gbc_lblHTTen.gridwidth = 3;
		gbc_lblHTTen.insets = new Insets(0, 0, 5, 5);
		gbc_lblHTTen.gridx = 2;
		gbc_lblHTTen.gridy = 1;
		contentPane.add(lblHTTen, gbc_lblHTTen);
		
		JLabel lblDuongDanThuMuc = new JLabel("Đường dẫn thư mục cha: ");
		lblDuongDanThuMuc.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDuongDanThuMuc = new GridBagConstraints();
		gbc_lblDuongDanThuMuc.anchor = GridBagConstraints.WEST;
		gbc_lblDuongDanThuMuc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuongDanThuMuc.gridx = 1;
		gbc_lblDuongDanThuMuc.gridy = 2;
		contentPane.add(lblDuongDanThuMuc, gbc_lblDuongDanThuMuc);
		
		JLabel lblHTDuongDanThuMuc = new JLabel("Chưa có");
		lblHTDuongDanThuMuc.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHTDuongDanThuMuc = new GridBagConstraints();
		gbc_lblHTDuongDanThuMuc.anchor = GridBagConstraints.WEST;
		gbc_lblHTDuongDanThuMuc.gridwidth = 3;
		gbc_lblHTDuongDanThuMuc.insets = new Insets(0, 0, 5, 5);
		gbc_lblHTDuongDanThuMuc.gridx = 2;
		gbc_lblHTDuongDanThuMuc.gridy = 2;
		contentPane.add(lblHTDuongDanThuMuc, gbc_lblHTDuongDanThuMuc);
		
		JLabel lblDuongDanDayDu = new JLabel("Đường dẫn đầy đủ: ");
		lblDuongDanDayDu.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDuongDanDayDu = new GridBagConstraints();
		gbc_lblDuongDanDayDu.anchor = GridBagConstraints.WEST;
		gbc_lblDuongDanDayDu.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuongDanDayDu.gridx = 1;
		gbc_lblDuongDanDayDu.gridy = 3;
		contentPane.add(lblDuongDanDayDu, gbc_lblDuongDanDayDu);
		
		JLabel lblHTDuongDanDayDu = new JLabel("Chưa có");
		lblHTDuongDanDayDu.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHTDuongDanDayDu = new GridBagConstraints();
		gbc_lblHTDuongDanDayDu.anchor = GridBagConstraints.WEST;
		gbc_lblHTDuongDanDayDu.gridwidth = 3;
		gbc_lblHTDuongDanDayDu.insets = new Insets(0, 0, 5, 5);
		gbc_lblHTDuongDanDayDu.gridx = 2;
		gbc_lblHTDuongDanDayDu.gridy = 3;
		contentPane.add(lblHTDuongDanDayDu, gbc_lblHTDuongDanDayDu);
		
		JLabel lblKichThuoc = new JLabel("Kích thước: ");
		lblKichThuoc.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblKichThuoc = new GridBagConstraints();
		gbc_lblKichThuoc.anchor = GridBagConstraints.WEST;
		gbc_lblKichThuoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblKichThuoc.gridx = 1;
		gbc_lblKichThuoc.gridy = 4;
		contentPane.add(lblKichThuoc, gbc_lblKichThuoc);
		
		JLabel lblHTKichThuoc = new JLabel("Chưa có");
		lblHTKichThuoc.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHTKichThuoc = new GridBagConstraints();
		gbc_lblHTKichThuoc.anchor = GridBagConstraints.WEST;
		gbc_lblHTKichThuoc.gridwidth = 3;
		gbc_lblHTKichThuoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblHTKichThuoc.gridx = 2;
		gbc_lblHTKichThuoc.gridy = 4;
		contentPane.add(lblHTKichThuoc, gbc_lblHTKichThuoc);
		
		JLabel lblDinhDang = new JLabel("Định dạng:");
		lblDinhDang.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDinhDang = new GridBagConstraints();
		gbc_lblDinhDang.anchor = GridBagConstraints.WEST;
		gbc_lblDinhDang.insets = new Insets(0, 0, 5, 5);
		gbc_lblDinhDang.gridx = 1;
		gbc_lblDinhDang.gridy = 5;
		contentPane.add(lblDinhDang, gbc_lblDinhDang);
		
		JLabel lblHTDinhDang = new JLabel("Chưa có");
		lblHTDinhDang.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHTDinhDang = new GridBagConstraints();
		gbc_lblHTDinhDang.anchor = GridBagConstraints.WEST;
		gbc_lblHTDinhDang.gridwidth = 3;
		gbc_lblHTDinhDang.insets = new Insets(0, 0, 5, 5);
		gbc_lblHTDinhDang.gridx = 2;
		gbc_lblHTDinhDang.gridy = 5;
		contentPane.add(lblHTDinhDang, gbc_lblHTDinhDang);
		
		JLabel lblAnh = new JLabel("Hiển thị ảnh:");
		GridBagConstraints gbc_lblAnh = new GridBagConstraints();
		gbc_lblAnh.anchor = GridBagConstraints.WEST;
		gbc_lblAnh.insets = new Insets(0, 0, 0, 5);
		gbc_lblAnh.gridx = 1;
		gbc_lblAnh.gridy = 6;
		contentPane.add(lblAnh, gbc_lblAnh);
		
		JLabel lblHTAnh = new JLabel("Chưa có");
		GridBagConstraints gbc_lblHTAnh = new GridBagConstraints();
		gbc_lblHTAnh.gridwidth = 3;
		gbc_lblHTAnh.insets = new Insets(0, 0, 0, 5);
		gbc_lblHTAnh.gridx = 2;
		gbc_lblHTAnh.gridy = 6;
		contentPane.add(lblHTAnh, gbc_lblHTAnh);
		btnXem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//Kết nối đến Server
					Socket socket = new Socket("127.0.0.1", 3000);
					//Gửi Dữ liệu lên Server
					DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
					String dataGui = txtYeuCau.getText();
					dataOut.writeUTF(dataGui);
					dataOut.flush();
					//Nhận dữ liệu từ Server
					DataInputStream dataIn = new DataInputStream(socket.getInputStream());
					//Chuẩn bị File Output Stream để ghi dữ liệu
					FileOutputStream fileOut = new FileOutputStream("F://Output/Copy "+dataGui);
					//Ghi file từ dataIn vào fileOut
					int len;
					byte[] data = new byte[10000];
					while ((len=dataIn.read(data))>0) {
						fileOut.write(data, 0, len);
					}
					//Lấy thông tin từ ảnh
					File anh = new File("F://Output/Copy "+dataGui);

					if (anh.exists()) {
						lblHTTen.setText(anh.getName());
						lblHTDuongDanThuMuc.setText(anh.getParent());
						lblHTDuongDanDayDu.setText(anh.getPath());
						lblHTKichThuoc.setText(anh.length() + " byte");
						lblHTDinhDang.setText(anh.getName().substring(anh.getName().lastIndexOf(".")+1));
						lblHTAnh.setText("");
						lblHTAnh.setIcon(new ImageIcon("F://Output/Copy "+dataGui));
					}
					//Đóng kết nối
					dataOut.close();
					fileOut.close();
					dataIn.close();
					socket.close();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		
	}

}
