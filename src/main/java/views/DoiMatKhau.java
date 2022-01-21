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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class DoiMatKhau extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField currentPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiMatKhau frame = new DoiMatKhau(user);
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
	public DoiMatKhau(User user) {

		DoiMatKhau.user = user;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0110\u1ED5i M\u1EADt Kh\u1EA9u");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(108, 10, 199, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u hi\u1EC7n t\u1EA1i: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 52, 150, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 94, 150, 32);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 136, 150, 32);
		contentPane.add(lblNewLabel_1_2);

		currentPasswordField = new JPasswordField();
		currentPasswordField.setBounds(160, 58, 220, 25);
		contentPane.add(currentPasswordField);

		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(160, 100, 220, 25);
		contentPane.add(newPasswordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(160, 142, 220, 25);
		contentPane.add(confirmPasswordField);

		JButton btnSubmit = new JButton("X\u00E1c nh\u1EADn");
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String currentPassword = String.valueOf(currentPasswordField.getPassword());
				String newPassword = String.valueOf(newPasswordField.getPassword());
				String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
				if (currentPassword.equals("") || newPassword.equals("") || confirmPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "Dữ liệu không được để trống !");
				} else if (newPassword.length() < 6 || confirmPassword.length() < 6) {
					JOptionPane.showMessageDialog(null, "Mật khẩu tối thiểu 6 kí tự !");
				} else if (newPassword.equals(currentPassword)) {
					JOptionPane.showMessageDialog(null, "Mật khẩu mới không được trùng với mật khẩu hiện tại !");
				} else if (!newPassword.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không khớp !");
				} else {
					String email = user.getEmail();
					System.out.println(email);
					UserService userService = new UserService();
					Map<String, Object> data = userService.checkResetPassword(email, currentPassword);
					if ((boolean) data.get("isReset")) {
						userService.resetPassword(email, BCrypt.hashpw(newPassword, BCrypt.gensalt()));
						JOptionPane.showMessageDialog(rootPane, (String) data.get("msg"));
					} else {
						JOptionPane.showMessageDialog(rootPane, (String) data.get("msg"));
					}
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(144, 198, 128, 32);
		contentPane.add(btnSubmit);
	}
}
