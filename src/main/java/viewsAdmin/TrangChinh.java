package viewsAdmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controller.TabViewAdmin;
import entity.TabSelect;
import entity.User;
import views.DangNhap;
import views.DoiMatKhau;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;
import java.awt.ComponentOrientation;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrangChinh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChinh frame = new TrangChinh(user);
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
	public TrangChinh(User user) {

		TrangChinh.user = user;

		setTitle("Qu\u1EA3n L\u00FD H\u1ECDc Li\u1EC7u");
		setResizable(false);
		setExtendedState(Frame.NORMAL);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
		mainPanel = new JPanel();
		mainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mainPanel.setBackground(SystemColor.control);
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(mainPanel);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(240, 248, 255));
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panelHome = new JPanel();
		panelHome.setBounds(11, 101, 265, 83);
		panelHome.setBackground(new Color(100, 149, 237));
		panelHome.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Trang Ch\u1EE7");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_home_black_24dp.png"));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 0, 265, 83);
		panelHome.add(lblNewLabel_1);

		JPanel panelManage = new JPanel();
		panelManage.setBounds(11, 194, 265, 83);
		panelManage.setBackground(new Color(100, 149, 237));
		panelManage.setLayout(null);

		JPanel panelStatistical = new JPanel();
		panelStatistical.setBounds(11, 473, 265, 83);
		panelStatistical.setBackground(new Color(100, 149, 237));
		panelStatistical.setLayout(null);

		JPanel panelView = new JPanel();
		panelView.setBackground(Color.WHITE);
		panelView.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panelApp = new JPanel();
		panelApp.setBounds(0, 0, 285, 90);
		panelApp.setForeground(new Color(100, 149, 237));
		panelApp.setBackground(new Color(255, 215, 0));
		panelApp.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelApp.setLayout(null);

		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD H\u1ECDc Li\u1EC7u");
		lblNewLabel.setBounds(0, 0, 285, 90);
		panelApp.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_library_books_black_24dp.png"));
		lblNewLabel.setBackground(new Color(135, 206, 250));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
						.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelView, GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)));
		gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
				.addComponent(panelView, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE));
		panelView.setLayout(null);
		panelMenu.setLayout(null);
		panelMenu.add(panelHome);
		panelMenu.add(panelManage);
		panelMenu.add(panelStatistical);
		panelMenu.add(panelApp);
		mainPanel.setLayout(gl_mainPanel);

		JLabel lblNewLabel_1_4 = new JLabel("Th\u1ED1ng K\u00EA Chi Ti\u1EBFt");
		lblNewLabel_1_4.setBounds(0, 0, 265, 83);
		panelStatistical.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_analytics_black_24dp.png"));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblNewLabel_1_2 = new JLabel("Qu\u1EA3n L\u00FD H\u1ECDc Li\u1EC7u");
		lblNewLabel_1_2.setBounds(0, 0, 265, 83);
		panelManage.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_menu_book_black_24dp.png"));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblSignOut = new JLabel("\u0110\u0103ng Xu\u1EA5t");
		lblSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangNhap loginForm = new DangNhap();
				loginForm.setLocationRelativeTo(null);
				loginForm.setVisible(true);
				setVisible(false);
			}
		});
		lblSignOut.setForeground(SystemColor.textHighlight);
		lblSignOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setBounds(85, 647, 114, 38);
		panelMenu.add(lblSignOut);

		JLabel lblNewLabel_3 = new JLabel("?????i M???t Kh???u");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoiMatKhau formDoiMK = new DoiMatKhau(user);
				formDoiMK.setVisible(true);
				formDoiMK.setLocationRelativeTo(null);
			}
		});

		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(11, 598, 264, 39);
		panelMenu.add(lblNewLabel_3);

		JPanel panelLectureManage = new JPanel();
		panelLectureManage.setLayout(null);
		panelLectureManage.setBackground(new Color(100, 149, 237));
		panelLectureManage.setBounds(11, 287, 265, 83);
		panelMenu.add(panelLectureManage);

		JLabel lblNewLabel_1_3 = new JLabel("Qu???n L?? Gi???ng Vi??n");
		lblNewLabel_1_3.setBounds(0, 0, 265, 83);
		panelLectureManage.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_manage_accounts_black_24dp.png"));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));

		JPanel panelUserManage = new JPanel();
		panelUserManage.setBounds(11, 380, 265, 83);
		panelMenu.add(panelUserManage);
		panelUserManage.setBackground(new Color(100, 149, 237));
		panelUserManage.setLayout(null);

		JLabel lblNewLabel_1_3_1 = new JLabel("Qu???n L?? Ng?????i D??ng");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\appQuanLyHocLieu\\Image\\2x\\outline_people_alt_black_24dp.png"));
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(0, 0, 265, 83);
		panelUserManage.add(lblNewLabel_1_3_1);

		TabViewAdmin chuyenTab = new TabViewAdmin(panelView, user);
		chuyenTab.addView(panelHome);
		List<TabSelect> listItem = new ArrayList<>();
		listItem.add(new TabSelect("TrangChu", panelHome));
		listItem.add(new TabSelect("QuanLyHocLieu", panelManage));
		listItem.add(new TabSelect("ThongKe", panelStatistical));
		listItem.add(new TabSelect("QuanLyNguoiDung", panelUserManage));
		listItem.add(new TabSelect("QuanLyGiangVien", panelLectureManage));
		chuyenTab.addEvent(listItem);
	}
}
