package viewsAdmin;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import service.BaiHocService;
import service.HocLieuService;
import service.UserService;

import java.awt.Font;

public class TrangChu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public TrangChu() {

		HocLieuService hlService = new HocLieuService();
		BaiHocService bhService = new BaiHocService();
		UserService userService = new UserService();

		setBackground(SystemColor.window);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 204));
		panel.setBounds(0, 0, 802, 720);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panel_1.setBounds(10, 300, 250, 225);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_auto_stories_white_48dp.png"));
		lblNewLabel.setBounds(10, 122, 105, 93);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("Học Liệu");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 10, 230, 87);
		panel_1.add(lblNewLabel_3);

		JLabel lblHocLieu = new JLabel(hlService.thongKeHocLieu().toString());
		lblHocLieu.setForeground(Color.WHITE);
		lblHocLieu.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblHocLieu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHocLieu.setBounds(125, 122, 115, 93);
		panel_1.add(lblHocLieu);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(135, 206, 235));
		panel_1_1.setBounds(270, 300, 250, 225);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_people_alt_white_48dp.png"));
		lblNewLabel_1.setBounds(10, 122, 105, 93);
		panel_1_1.add(lblNewLabel_1);

		JLabel lblUser = new JLabel(userService.thongKeUser().toString());
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblUser.setBounds(125, 122, 115, 93);
		panel_1_1.add(lblUser);

		JLabel lblNewLabel_3_1 = new JLabel("User");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_3_1.setBounds(10, 10, 230, 87);
		panel_1_1.add(lblNewLabel_3_1);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 255, 127));
		panel_1_2.setBounds(530, 300, 250, 225);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_book_online_white_48dp.png"));
		lblNewLabel_2.setBounds(10, 122, 105, 93);
		panel_1_2.add(lblNewLabel_2);

		JLabel lblBaiHoc = new JLabel(bhService.thongKeBaiHoc().toString());
		lblBaiHoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaiHoc.setForeground(Color.WHITE);
		lblBaiHoc.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblBaiHoc.setBounds(125, 122, 115, 93);
		panel_1_2.add(lblBaiHoc);

		JLabel lblNewLabel_3_2 = new JLabel("Bài Học");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_3_2.setBounds(10, 10, 230, 87);
		panel_1_2.add(lblNewLabel_3_2);

		JLabel lblNewLabel_4 = new JLabel("Tổng Quan Hệ Thống");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel_4.setForeground(SystemColor.textHighlightText);
		lblNewLabel_4.setBounds(10, 10, 770, 204);
		panel.add(lblNewLabel_4);

	}
}
