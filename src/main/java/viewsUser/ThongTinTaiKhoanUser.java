package viewsUser;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ThongTinTaiKhoanUser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ThongTinTaiKhoanUser() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng Tin T\u00E0i kho\u1EA3n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 210, 522, 58);
		add(lblNewLabel);
		
		JButton btnUpdate = new JButton("C\u1EADp Nh\u1EADt");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(252, 392, 145, 40);
		add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(94, 291, 145, 30);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn ng\u01B0\u1EDDi d\u00F9ng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(94, 331, 145, 30);
		add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(252, 331, 298, 30);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 291, 298, 30);
		add(textField_1);

	}
}
