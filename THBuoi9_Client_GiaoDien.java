package packetThucHanh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
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
import java.net.UnknownHostException;

public class THBuoi9_Client_GiaoDien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNhap;
	private static Socket socket;
//	private static Socket socket;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				try {
					socket = new Socket("127.0.0.1",3000);
					THBuoi9_Client_GiaoDien frame = new THBuoi9_Client_GiaoDien();
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
	public THBuoi9_Client_GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNhap = new JLabel("Nhập nội dung: ");
		GridBagConstraints gbc_lblNhap = new GridBagConstraints();
		gbc_lblNhap.gridwidth = 3;
		gbc_lblNhap.anchor = GridBagConstraints.WEST;
		gbc_lblNhap.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhap.gridx = 0;
		gbc_lblNhap.gridy = 1;
		contentPane.add(lblNhap, gbc_lblNhap);
		
		txtNhap = new JTextField();
		GridBagConstraints gbc_txtNhap = new GridBagConstraints();
		gbc_txtNhap.insets = new Insets(0, 0, 5, 0);
		gbc_txtNhap.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNhap.gridx = 3;
		gbc_txtNhap.gridy = 1;
		contentPane.add(txtNhap, gbc_txtNhap);
		txtNhap.setColumns(10);
		
		JButton btnGui = new JButton("Gửi");
		
		GridBagConstraints gbc_btnGui = new GridBagConstraints();
		gbc_btnGui.insets = new Insets(0, 0, 5, 0);
		gbc_btnGui.gridx = 3;
		gbc_btnGui.gridy = 2;
		contentPane.add(btnGui, gbc_btnGui);
		
		JLabel lblNhan = new JLabel("Kết quả: ");
		GridBagConstraints gbc_lblNhan = new GridBagConstraints();
		gbc_lblNhan.gridwidth = 3;
		gbc_lblNhan.anchor = GridBagConstraints.WEST;
		gbc_lblNhan.insets = new Insets(0, 0, 0, 5);
		gbc_lblNhan.gridx = 0;
		gbc_lblNhan.gridy = 3;
		contentPane.add(lblNhan, gbc_lblNhan);
		
		JTextArea txtNhan = new JTextArea();
		GridBagConstraints gbc_txtNhan = new GridBagConstraints();
		gbc_txtNhan.fill = GridBagConstraints.BOTH;
		gbc_txtNhan.gridx = 3;
		gbc_txtNhan.gridy = 3;
		contentPane.add(txtNhan, gbc_txtNhan);
		
		btnGui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
					DataInputStream dataIn = new DataInputStream(socket.getInputStream());
					
					String strOut = txtNhap.getText();
					dataOut.writeUTF(strOut);
					dataOut.flush();

					String strIn = dataIn.readUTF();
					txtNhan.setText(strIn);
					
				} catch (UnknownHostException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
	}

}
