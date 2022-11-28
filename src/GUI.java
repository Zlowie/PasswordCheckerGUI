import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JTextField textPassword;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		User.ReadUserFile();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 10, 416, 31);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 65, 416, 31);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 222, 416, 31);
		getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(10, 162, 150, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.setBounds(276, 162, 150, 40);
		getContentPane().add(btnCreateAccount);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textLogin = new JTextField();
		textLogin.setBounds(10, 25, 416, 32);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(10, 76, 416, 32);
		contentPane.add(textPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textLogin.getText();
				textField.setText(text);

			}
		});
		btnLogin.setBounds(10, 171, 149, 40);
		contentPane.add(btnLogin);
		
		JButton btnCreateUser = new JButton("Create user");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.SingleUserToFile(textLogin.getText(), textPassword.getText());
			}
		});
		btnCreateUser.setBounds(277, 171, 149, 40);
		contentPane.add(btnCreateUser);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 10, 416, 13);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 64, 416, 13);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 231, 416, 32);
		contentPane.add(textField);
	}
}
