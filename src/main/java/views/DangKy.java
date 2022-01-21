package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import entity.User;
import service.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DangKy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField cfPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy frame = new DangKy();
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
	public DangKy() {
		setResizable(false);
		setTitle("Qu\u1EA3n L\u00FD H\u1ECDc Li\u1EC7u");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 10, 463, 415);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 44, 187, 48);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(36, 102, 127, 38);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Username:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(36, 154, 127, 38);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Password:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(36, 205, 127, 38);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("ConfirmPassword");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(36, 262, 127, 38);
		panel.add(lblNewLabel_1_3);

		emailField = new JTextField();
		emailField.setBounds(173, 108, 245, 31);
		panel.add(emailField);
		emailField.setColumns(10);

		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(173, 160, 245, 31);
		panel.add(usernameField);

		passwordField = new JPasswordField();
		passwordField.setBounds(173, 211, 245, 31);
		panel.add(passwordField);

		cfPasswordField = new JPasswordField();
		cfPasswordField.setBounds(173, 268, 245, 31);
		panel.add(cfPasswordField);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService userService = new UserService();
				User user = new User();
				String email = emailField.getText();
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String cfPassword = String.valueOf(cfPasswordField.getPassword());
				String regex = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
				if (email.length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Email không được để trống !");
				} else if (!email.matches(regex)) {
					JOptionPane.showMessageDialog(rootPane, "Email không đúng định dạng !");
				} else if (email.equals("admin@gmail.com")) {
					JOptionPane.showMessageDialog(rootPane, "Email đã tồn tại !");
				} else if (username.length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Username không được để trống !");
				} else if (password.length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu không được để trống !");

				} else if (password.length() < 6) {
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu tối thiểu 6 kí tự !");
				} else if (cfPassword.length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng xác nhận mật khẩu !");
				} else if (cfPassword == password) {
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu không khớp !");
				} else {
					user.setEmail(email);
					user.setUserName(username);
					user.setPassWord(BCrypt.hashpw(password, BCrypt.gensalt()));
					user.setRole("Người dùng");

					Map<String, Object> data = userService.checkRegistry(user, email);
					if ((boolean) data.get("status")) {
						userService.registry(user);
						JOptionPane.showMessageDialog(rootPane, (String) data.get("msg"));
						DangNhap loginForm = new DangNhap();
						loginForm.setLocationRelativeTo(null);
						loginForm.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(rootPane, (String) data.get("msg"));
					}
				}
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignUp.setBounds(173, 335, 115, 38);
		panel.add(btnSignUp);

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap loginForm = new DangNhap();
				loginForm.setLocationRelativeTo(null);
				loginForm.setVisible(true);
				setVisible(false);
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignIn.setBounds(303, 335, 115, 38);
		panel.add(btnSignIn);
	}
}
