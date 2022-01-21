package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.User;
import service.UserService;
import viewLecture.TrangChinhLecture;
import viewsAdmin.TrangChinh;
import viewsUser.TrangChinhUser;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField emailField;
	public static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setLocationRelativeTo(null);
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
	public DangNhap() {
		setResizable(false);
		setTitle("Qu\u1EA3n L\u00FD H\u1ECDc Li\u1EC7u");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBackground(Color.WHITE);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailLabel.setBounds(48, 97, 81, 33);
		contentPane.add(emailLabel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBackground(Color.WHITE);
		passwordLabel.setBounds(48, 140, 81, 33);
		contentPane.add(passwordLabel);

		emailField = new JTextField();
		emailField.setBounds(150, 97, 212, 31);
		contentPane.add(emailField);
		emailField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(151, 43, 144, 33);
		contentPane.add(lblNewLabel);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService userService = new UserService();
				String email = emailField.getText();
				String password = String.valueOf(passwordField.getPassword());

				Map<String, Object> data = userService.login(email, password);
				if ((boolean) data.get("isLogin")) {
					if (data.get("role").equals("Admin")) {
						user = userService.getUser(email);
						TrangChinh homepageForm = new TrangChinh(user);
						homepageForm.setLocationRelativeTo(null);
						homepageForm.setVisible(true);
						setVisible(false);
					} else if (data.get("role").equals("Giảng viên")) {
						user = userService.getUser(email);
						TrangChinhLecture homepageForm = new TrangChinhLecture(user);
						homepageForm.setLocationRelativeTo(null);
						homepageForm.setVisible(true);
						setVisible(false);
					} else {
						user = userService.getUser(email);
						TrangChinhUser homepageForm = new TrangChinhUser(user);
						homepageForm.setLocationRelativeTo(null);
						homepageForm.setVisible(true);
						setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(rootPane, (String) data.get("msg"));
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(151, 191, 104, 33);
		contentPane.add(btnLogin);

		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DangKy registerForm = new DangKy();
				registerForm.setLocationRelativeTo(null);
				registerForm.setVisible(true);
				setVisible(false);

			}
		});
		btnSignUp.setBounds(259, 191, 104, 32);
		contentPane.add(btnSignUp);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 10, 395, 241);
		contentPane.add(panel);
		panel.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 127, 212, 31);
		panel.add(passwordField);
	}
}
