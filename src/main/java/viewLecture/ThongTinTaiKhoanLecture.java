package viewLecture;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import entity.User;
import service.ThongKeService;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ThongTinTaiKhoanLecture extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static User user;

	/**
	 * Create the panel.
	 */
	public ThongTinTaiKhoanLecture(User user) {
		ThongTinTaiKhoanLecture.user = user;

		setBackground(new Color(240, 248, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng Tin T\u00E0i kho\u1EA3n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 175, 522, 58);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(94, 305, 145, 30);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn ng\u01B0\u1EDDi d\u00F9ng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(94, 265, 145, 30);
		add(lblNewLabel_1_1);

		JTextField userNameField = new JTextField(user.getUserName());
		userNameField.setBounds(252, 268, 298, 30);
		add(userNameField);
		userNameField.setColumns(10);

		JTextField emailField = new JTextField(user.getEmail());
		emailField.setColumns(10);
		emailField.setBounds(252, 305, 298, 30);
		add(emailField);

		JLabel lblNewLabel_1_2 = new JLabel("Học Liệu đã thêm:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(94, 345, 145, 30);
		add(lblNewLabel_1_2);

		ThongKeService tkService = new ThongKeService();

		JLabel hocLieuCount = new JLabel(tkService.countHocLieuOfLecture(user.getEmail()).toString());
		hocLieuCount.setBounds(252, 345, 298, 30);
		add(hocLieuCount);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(60, 175, 701, 250);
		add(panel);
	}
}
