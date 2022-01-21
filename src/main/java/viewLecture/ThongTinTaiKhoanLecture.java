package viewLecture;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import entity.User;
import service.ThongKeService;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ThongTinTaiKhoanLecture extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userNameField;
	private JTextField emailField;
	public static User user;

	/**
	 * Create the panel.
	 */
	public ThongTinTaiKhoanLecture(User user) {
		ThongTinTaiKhoanLecture.user = user;

		ThongKeService tkService = new ThongKeService();

		setBackground(new Color(240, 248, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng Tin T\u00E0i kho\u1EA3n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 175, 522, 58);
		add(lblNewLabel);

		JButton btnUpdate = new JButton("C\u1EADp Nh\u1EADt");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(329, 385, 145, 40);
		add(btnUpdate);

		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(94, 305, 145, 30);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn ng\u01B0\u1EDDi d\u00F9ng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(94, 265, 145, 30);
		add(lblNewLabel_1_1);

		userNameField = new JTextField(user.getUserName());
		userNameField.setBounds(252, 268, 298, 30);
		add(userNameField);
		userNameField.setColumns(10);

		emailField = new JTextField(user.getEmail());
		emailField.setEnabled(false);
		emailField.setEditable(false);
		emailField.setColumns(10);
		emailField.setBounds(252, 305, 298, 30);
		add(emailField);

		JLabel lblNewLabel_1_2 = new JLabel("Học Liệu đã thêm:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(94, 345, 145, 30);
		add(lblNewLabel_1_2);

		JLabel hocLieuCount = new JLabel(tkService.countHocLieuOfLecture(user.getEmail()).toString());
		hocLieuCount.setBounds(252, 345, 298, 30);
		add(hocLieuCount);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(60, 175, 701, 275);
		add(panel);
	}
}
