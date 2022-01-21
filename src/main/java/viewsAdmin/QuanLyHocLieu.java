package viewsAdmin;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.util.Map;

import controller.QuanLyHocLieuController;
import entity.BaiHoc;
import entity.HocLieu;
import entity.User;
import service.BaiHocService;
import service.HocLieuService;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyHocLieu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
	static String wordSource = "";
	static String slideSource = "";
	static String btSource = "";
	static String videoSource = "";
	static User user;

	/**
	 * Create the panel.
	 */
	public QuanLyHocLieu(User user) {
		QuanLyHocLieu.user = user;

		setBackground(SystemColor.control);
		setLayout(null);

		JPanel panelButton = new JPanel();
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelButton.setBackground(Color.WHITE);
		panelButton.setBounds(0, 0, 803, 57);
		add(panelButton);
		panelButton.setLayout(null);

		searchField = new JTextField();
		searchField.setBounds(10, 10, 230, 37);
		panelButton.add(searchField);
		searchField.setColumns(10);

		JPanel panelTable = new JPanel();
		panelTable.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panelTable.setBounds(0, 51, 803, 669);
		add(panelTable);

		JButton btnAddButton = new JButton("Thêm Học Liệu");
		btnAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame ThemHocLieu = new JFrame();
				ThemHocLieu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ThemHocLieu.setBounds(100, 100, 500, 400);
				ThemHocLieu.setVisible(true);
				ThemHocLieu.setLocationRelativeTo(null);

				JPanel contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				ThemHocLieu.setContentPane(contentPane);

				JPanel panelAdd = new JPanel();
				panelAdd.setBackground(Color.WHITE);
				panelAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
				panelAdd.setBounds(0, 519, 803, 201);
				ThemHocLieu.getContentPane().add(panelAdd);
				panelAdd.setLayout(null);

				JLabel lblNewLabel = new JLabel("Thêm Học Liệu");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(132, 10, 212, 39);
				panelAdd.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("T\u00EAn h\u1ECDc li\u1EC7u: ");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1.setBounds(5, 52, 98, 31);
				panelAdd.add(lblNewLabel_1);

				JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn b\u00E0i: ");
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1_1.setBounds(5, 93, 98, 31);
				panelAdd.add(lblNewLabel_1_1);

				JLabel lblNewLabel_1_1_1 = new JLabel("Word:");
				lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1_1_1.setBounds(5, 134, 53, 31);
				panelAdd.add(lblNewLabel_1_1_1);

				JLabel lblNewLabel_1_1_2 = new JLabel("Silde:");
				lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1_1_2.setBounds(5, 175, 53, 31);
				panelAdd.add(lblNewLabel_1_1_2);

				JLabel lblNewLabel_1_1_2_1 = new JLabel("B\u00E0i t\u1EADp:");
				lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1_1_2_1.setBounds(5, 216, 55, 31);
				panelAdd.add(lblNewLabel_1_1_2_1);

				JLabel lblWord = new JLabel("");
				JLabel lblSlide = new JLabel("");
				JLabel lblBaiTap = new JLabel("");
				JLabel lblVideo = new JLabel("");

				JButton btnAddWord = new JButton("Ch\u1ECDn file");
				btnAddWord.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser(new File("C:\\Users\\hailo\\Downloads\\Documents"));
						fc.setDialogTitle("Chọn File");
						if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							panelAdd.add(lblWord);
							lblWord.setText(fc.getSelectedFile().getName());
							wordSource = fc.getSelectedFile().getAbsolutePath();
							lblWord.setBounds(207, 134, 236, 31);
						}
					}

				});
				btnAddWord.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAddWord.setBounds(112, 137, 95, 28);
				panelAdd.add(btnAddWord);

				JButton btnAddSlide = new JButton("Ch\u1ECDn file");
				btnAddSlide.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser(new File("C:\\Users\\hailo\\Downloads\\Documents"));
						fc.setDialogTitle("Chọn File");
						if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							panelAdd.add(lblSlide);
							lblSlide.setText(fc.getSelectedFile().getName());
							slideSource = fc.getSelectedFile().getAbsolutePath();
							lblSlide.setBounds(207, 175, 236, 31);
						}
					}
				});
				btnAddSlide.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAddSlide.setBounds(112, 178, 95, 28);
				panelAdd.add(btnAddSlide);

				JButton btnAddBT = new JButton("Ch\u1ECDn file");
				btnAddBT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser(new File("C:\\Users\\hailo\\Downloads\\Documents"));
						fc.setDialogTitle("Chọn File");
						if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							panelAdd.add(lblBaiTap);
							lblBaiTap.setText(fc.getSelectedFile().getName());
							btSource = fc.getSelectedFile().getAbsolutePath();
							lblBaiTap.setBounds(207, 216, 236, 31);
						}
					}
				});
				btnAddBT.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAddBT.setBounds(112, 219, 95, 28);
				panelAdd.add(btnAddBT);

				JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Video:");
				lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1_1_2_1_1.setBounds(5, 257, 55, 31);
				panelAdd.add(lblNewLabel_1_1_2_1_1);

				JButton btnAddVideo = new JButton("Chọn file");
				btnAddVideo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser(new File("C:\\Users\\hailo\\Downloads\\Documents"));
						fc.setDialogTitle("Chọn File");
						if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							panelAdd.add(lblVideo);
							lblVideo.setText(fc.getSelectedFile().getName());
							videoSource = fc.getSelectedFile().getAbsolutePath();
							lblVideo.setBounds(207, 257, 236, 31);
						}
					}
				});
				btnAddVideo.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAddVideo.setBounds(112, 257, 95, 28);
				panelAdd.add(btnAddVideo);

				JTextField hocLieuField = new JTextField();
				hocLieuField.setBounds(113, 52, 330, 31);
				panelAdd.add(hocLieuField);
				hocLieuField.setColumns(10);

				JTextField baiHocField = new JTextField();
				baiHocField.setColumns(10);
				baiHocField.setBounds(113, 93, 330, 31);
				panelAdd.add(baiHocField);

				JButton btnAddHocLieu = new JButton("Thêm");
				btnAddHocLieu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (hocLieuField.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Tên học liệu không được để trống !");
						} else {
							if (baiHocField.getText().equals("")) {
								if (wordSource == null && slideSource == null && videoSource == null
										&& btSource == null) {
									HocLieu hocLieu = new HocLieu();
									HocLieuService hocLieuService = new HocLieuService();
									hocLieu.setHocLieu(hocLieuField.getText());
									hocLieu.setNgayTao(LocalDate.now());
									hocLieuService.addHocLieu(hocLieu);
									JOptionPane.showMessageDialog(null, "Thêm thành công !");
								} else {
									JOptionPane.showMessageDialog(null, "Tên bài học không được để trống !");
								}
							} else {
								HocLieu hocLieu = new HocLieu();
								HocLieuService hocLieuService = new HocLieuService();
								BaiHoc baiHoc = new BaiHoc();
								BaiHocService baiHocService = new BaiHocService();
								hocLieu.setHocLieu(hocLieuField.getText());
								hocLieu.setNgayTao(LocalDate.now());
								hocLieu.setNguoiThem(user.getEmail());
								Map<String, Object> dataHL = hocLieuService.checkAddBaiHoc(hocLieu);
								if ((boolean) dataHL.get("status")) {
									hocLieuService.addHocLieu(hocLieu);
									baiHoc.setTenBai(baiHocField.getText());
									baiHoc.setIdHocLieu(hocLieu.getId());
									baiHoc.setWord(wordSource);
									baiHoc.setSlide(slideSource);
									baiHoc.setVideo(videoSource);
									baiHoc.setBaiTap(btSource);
									baiHoc.setNgayTao(LocalDate.now());
									baiHocService.addBaiHoc(baiHoc);
									JOptionPane.showMessageDialog(null, (String) dataHL.get("msg"));

								} else {
									JOptionPane.showMessageDialog(null, (String) dataHL.get("msg"));
								}
								QuanLyHocLieuController controller = new QuanLyHocLieuController(panelTable,
										searchField, user);
								controller.setDataToTable();
							}
						}
					}
				});
				btnAddHocLieu.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAddHocLieu.setBounds(145, 304, 85, 39);
				panelAdd.add(btnAddHocLieu);

				JButton btnReset = new JButton("Đặt lại");
				btnReset.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						hocLieuField.setText("");
						baiHocField.setText("");
						lblWord.setText("");
						lblSlide.setText("");
						lblBaiTap.setText("");
						lblVideo.setText("");
						wordSource = "";
						slideSource = "";
						videoSource = "";
						btSource = "";
					}
				});
				btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnReset.setBounds(255, 304, 85, 39);
				panelAdd.add(btnReset);
			}
		});
		btnAddButton.setBackground(new Color(100, 149, 237));
		btnAddButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddButton.setBounds(597, 9, 128, 37);
		panelButton.add(btnAddButton);

		QuanLyHocLieuController controller = new QuanLyHocLieuController(panelTable, searchField, user);

		JLabel lblRenew = new JLabel("");
		lblRenew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuanLyHocLieuController controller = new QuanLyHocLieuController(panelTable, searchField, user);
				controller.setDataToTable();
			}
		});
		lblRenew.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_autorenew_black_24dp.png"));
		lblRenew.setBounds(735, 10, 45, 37);
		panelButton.add(lblRenew);
		controller.setDataToTable();
	}
}
