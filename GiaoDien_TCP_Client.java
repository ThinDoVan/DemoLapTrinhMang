package packetThucHanh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GiaoDien_TCP_Client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNoiDung;
	private static Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 3000);
					GiaoDien_TCP_Client frame = new GiaoDien_TCP_Client();
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
	public GiaoDien_TCP_Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNoiDung = new JLabel("Nội dung");
		GridBagConstraints gbc_lblNoiDung = new GridBagConstraints();
		gbc_lblNoiDung.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoiDung.gridx = 1;
		gbc_lblNoiDung.gridy = 0;
		contentPane.add(lblNoiDung, gbc_lblNoiDung);
		
		txtNoiDung = new JTextField();
		GridBagConstraints gbc_txtNoiDung = new GridBagConstraints();
		gbc_txtNoiDung.insets = new Insets(0, 0, 5, 0);
		gbc_txtNoiDung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNoiDung.gridx = 3;
		gbc_txtNoiDung.gridy = 0;
		contentPane.add(txtNoiDung, gbc_txtNoiDung);
		txtNoiDung.setColumns(10);
		
		JButton btnSend = new JButton("Gửi");
		
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 5, 0);
		gbc_btnSend.gridx = 3;
		gbc_btnSend.gridy = 1;
		contentPane.add(btnSend, gbc_btnSend);
		
		JTextArea txtaHienThi = new JTextArea();
		GridBagConstraints gbc_txta = new GridBagConstraints();
		gbc_txta.fill = GridBagConstraints.BOTH;
		gbc_txta.gridx = 3;
		gbc_txta.gridy = 2;
		contentPane.add(txtaHienThi, gbc_txta);
		
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
					DataInputStream dataIn = new DataInputStream(socket.getInputStream());
					String dataGui = txtNoiDung.getText();
					dataOut.writeUTF(dataGui);
					dataOut.flush();
					
					String dataNhan = dataIn.readUTF();
					String noidung = txtaHienThi.getText() + "\nClient: " + dataGui + "\n" + dataNhan;
					txtaHienThi.setText(noidung);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	

}
