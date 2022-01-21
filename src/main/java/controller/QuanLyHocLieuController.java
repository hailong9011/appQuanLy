package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entity.BaiHoc;
import entity.HocLieu;
import entity.TableModelCustom;
import entity.User;
import service.BaiHocService;
import service.HocLieuService;

public class QuanLyHocLieuController {
	private JPanel jPanelView;
	private JTextField jTextFieldSearch;
	private HocLieu hocLieu;
	private String tenHocLieu;
	private User user;

	static String wordSource;
	static String slideSource;
	static String btSource;
	static String videoSource;

	static int selectedRowIndex;

	private TableModelCustom tableModel = null;

	private final String[] COLUMNS = { "Tên học liệu", "Ngày tạo", "Ngày cập nhật", "Người thêm" };

	private HocLieuService hocLieuService = null;

	private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyHocLieuController(JPanel jPanelView, JTextField jTextFieldSearch, User user) {
		super();
		this.jPanelView = jPanelView;
		this.user = user;
		this.jTextFieldSearch = jTextFieldSearch;
		this.tableModel = new TableModelCustom();
		this.hocLieuService = new HocLieuService();
	}

	public void setDataToTable() {

		List<HocLieu> listItem = null;
		if (user.getRole().equals("Admin")) {
			listItem = hocLieuService.getHocLieuList();
		} else {
			listItem = hocLieuService.getListHocLieuByLecture(user.getEmail());
		}
		DefaultTableModel model = tableModel.setTableHocLieu(listItem, COLUMNS);
		JTable table = new JTable(model);

		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);

		jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jTextFieldSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jTextFieldSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					selectedRowIndex = table.getSelectedRow();

					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					tenHocLieu = model.getValueAt(selectedRowIndex, 0).toString();
					HocLieuService hlService = new HocLieuService();
					hocLieu = hlService.getHocLieu(tenHocLieu);

					JFrame capNhatHocLieu = new JFrame();
					capNhatHocLieu.setTitle("C\u1EADp Nh\u1EADt H\u1ECDc Li\u1EC7u");
					capNhatHocLieu.setBounds(100, 100, 450, 150);
					capNhatHocLieu.getContentPane().setLayout(null);
					capNhatHocLieu.setVisible(true);
					capNhatHocLieu.setLocationRelativeTo(null);

					JButton btnListBH = new JButton("DS Bài Học");
					btnListBH.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							capNhatHocLieu.setVisible(false);

							JFrame capNhatBaiHoc = new JFrame();
							capNhatBaiHoc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							capNhatBaiHoc.setBounds(100, 100, 900, 680);
							capNhatBaiHoc.getContentPane().setLayout(null);
							capNhatBaiHoc.setTitle("Danh sách bài học");
							capNhatBaiHoc.setResizable(false);
							capNhatBaiHoc.setLocationRelativeTo(null);
							capNhatBaiHoc.setVisible(true);

							JPanel panelData = new JPanel();
							panelData.setBounds(0, 56, 896, 596);
							capNhatBaiHoc.getContentPane().add(panelData);
							panelData.setLayout(null);

							JPanel panelTop = new JPanel();
							panelTop.setBorder(new LineBorder(new Color(0, 0, 0)));
							panelTop.setBackground(Color.WHITE);
							panelTop.setBounds(0, 0, 896, 54);
							capNhatBaiHoc.getContentPane().add(panelTop);
							panelTop.setLayout(null);

							JTextField searchField = new JTextField();
							searchField.setBounds(10, 10, 227, 34);
							panelTop.add(searchField);
							searchField.setColumns(10);

							JLabel labelIdHocLieu = new JLabel(hocLieu.getId().toString());

							JButton btnAddBaiHoc = new JButton("Thêm Bài Học");
							btnAddBaiHoc.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									JFrame themBaiHoc = new JFrame();
									themBaiHoc.setVisible(true);
									themBaiHoc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									themBaiHoc.setBounds(100, 100, 450, 400);
									themBaiHoc.setTitle("Thông tin học liệu");
									themBaiHoc.setResizable(false);
									themBaiHoc.setLocationRelativeTo(null);
									themBaiHoc.getContentPane().setLayout(null);

									JPanel panel = new JPanel();
									panel.setBounds(0, 0, 446, 375);
									themBaiHoc.getContentPane().add(panel);
									panel.setLayout(null);

									JLabel lblNewLabel = new JLabel("Thêm Bài Học");
									lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
									lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
									lblNewLabel.setBounds(126, 10, 193, 41);
									panel.add(lblNewLabel);

									JLabel lblNewLabel_1 = new JLabel("Tên bài:");
									lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
									lblNewLabel_1.setBounds(10, 55, 70, 41);
									panel.add(lblNewLabel_1);

									JLabel lblNewLabel_1_1 = new JLabel("Word:");
									lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
									lblNewLabel_1_1.setBounds(10, 106, 70, 41);
									panel.add(lblNewLabel_1_1);

									JLabel lblNewLabel_1_2 = new JLabel("Slide:");
									lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
									lblNewLabel_1_2.setBounds(10, 157, 70, 41);
									panel.add(lblNewLabel_1_2);

									JLabel lblNewLabel_1_3 = new JLabel("Bài tập:");
									lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
									lblNewLabel_1_3.setBounds(10, 208, 70, 41);
									panel.add(lblNewLabel_1_3);

									JLabel lblNewLabel_1_4 = new JLabel("Video:");
									lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
									lblNewLabel_1_4.setBounds(10, 259, 70, 41);
									panel.add(lblNewLabel_1_4);

									JTextField textFieldBaiHoc = new JTextField();
									textFieldBaiHoc.setBounds(75, 61, 350, 35);
									panel.add(textFieldBaiHoc);
									textFieldBaiHoc.setColumns(10);

									JLabel lblWord = new JLabel("");
									JLabel lblSlide = new JLabel("");
									JLabel lblBaiTap = new JLabel("");
									JLabel lblVideo = new JLabel("");

									JButton btnWord = new JButton("Chọn File");
									btnWord.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											JFileChooser fc = new JFileChooser(
													new File("C:\\Users\\hailo\\Downloads\\Documents"));
											fc.setDialogTitle("Chọn File");
											if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
												panel.add(lblWord);
												lblWord.setText(fc.getSelectedFile().getName());
												wordSource = fc.getSelectedFile().getAbsolutePath();
												lblWord.setBounds(185, 106, 240, 35);
											}
										}
									});
									btnWord.setFont(new Font("Tahoma", Font.BOLD, 12));
									btnWord.setBounds(75, 106, 100, 35);
									panel.add(btnWord);

									JButton btnSlide = new JButton("Chọn File");
									btnSlide.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											JFileChooser fc = new JFileChooser(
													new File("C:\\Users\\hailo\\Downloads\\Documents"));
											fc.setDialogTitle("Chọn File");
											if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
												panel.add(lblSlide);
												lblSlide.setText(fc.getSelectedFile().getName());
												slideSource = fc.getSelectedFile().getAbsolutePath();
												lblSlide.setBounds(185, 157, 240, 35);
											}

										}
									});
									btnSlide.setFont(new Font("Tahoma", Font.BOLD, 12));
									btnSlide.setBounds(75, 157, 100, 35);
									panel.add(btnSlide);

									JButton btnBaiTap = new JButton("Chọn File");
									btnBaiTap.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											JFileChooser fc = new JFileChooser(
													new File("C:\\Users\\hailo\\Downloads\\Documents"));
											fc.setDialogTitle("Chọn File");
											if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
												panel.add(lblBaiTap);
												lblBaiTap.setText(fc.getSelectedFile().getName());
												btSource = fc.getSelectedFile().getAbsolutePath();
												lblBaiTap.setBounds(185, 208, 240, 35);
											}

										}
									});
									btnBaiTap.setFont(new Font("Tahoma", Font.BOLD, 12));
									btnBaiTap.setBounds(75, 208, 100, 35);
									panel.add(btnBaiTap);

									JButton btnVideo = new JButton("Chọn File");
									btnVideo.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											JFileChooser fc = new JFileChooser(
													new File("C:\\Users\\hailo\\Downloads\\Documents"));
											fc.setDialogTitle("Chọn File");
											if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
												panel.add(lblVideo);
												lblVideo.setText(fc.getSelectedFile().getName());
												videoSource = fc.getSelectedFile().getAbsolutePath();
												lblVideo.setBounds(185, 259, 240, 35);
											}

										}
									});
									btnVideo.setFont(new Font("Tahoma", Font.BOLD, 12));
									btnVideo.setBounds(75, 259, 100, 35);
									panel.add(btnVideo);

									JButton btnAdd = new JButton("Thêm");
									btnAdd.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											if (textFieldBaiHoc.getText().equals("")) {
												JOptionPane.showMessageDialog(null,
														"Tên bài học không được để trống !");
											} else {
												BaiHoc baiHoc = new BaiHoc();
												BaiHocService baiHocService = new BaiHocService();
												baiHoc.setIdHocLieu(hocLieu.getId());
												baiHoc.setTenBai(textFieldBaiHoc.getText());
												baiHoc.setWord(wordSource);
												baiHoc.setSlide(slideSource);
												baiHoc.setBaiTap(btSource);
												baiHoc.setVideo(videoSource);
												baiHoc.setNgayTao(LocalDate.now());
												Map<String, Object> data = baiHocService.checkAddBaiHoc(baiHoc,
														hocLieu.getId());
												if ((boolean) data.get("status")) {
													baiHocService.addBaiHoc(baiHoc);
													JOptionPane.showMessageDialog(null, data.get("msg"));

												} else {
													JOptionPane.showMessageDialog(null, data.get("msg"));
												}
												QuanLyBaiHocController controller = new QuanLyBaiHocController(
														panelData, searchField, labelIdHocLieu);
												controller.setDataToTable(hocLieu.getId());
											}

										}
									});
									btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
									btnAdd.setBounds(126, 319, 85, 35);
									panel.add(btnAdd);

									JButton btntReset = new JButton("Đặt lại");
									btntReset.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											textFieldBaiHoc.setText("");
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
									btntReset.setFont(new Font("Tahoma", Font.BOLD, 12));
									btntReset.setBounds(234, 319, 85, 35);
									panel.add(btntReset);
								}
							});
							btnAddBaiHoc.setFont(new Font("Tahoma", Font.BOLD, 12));
							btnAddBaiHoc.setBackground(new Color(100, 149, 237));
							btnAddBaiHoc.setBounds(680, 10, 143, 34);
							panelTop.add(btnAddBaiHoc);

							JLabel lblRenew = new JLabel("");
							lblRenew.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									QuanLyBaiHocController controller = new QuanLyBaiHocController(panelData,
											searchField, labelIdHocLieu);
									controller.setDataToTable(hocLieu.getId());
								}
							});
							lblRenew.setIcon(new ImageIcon(
									"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_autorenew_black_24dp.png"));
							lblRenew.setBounds(831, 10, 45, 34);
							panelTop.add(lblRenew);

							QuanLyBaiHocController controller = new QuanLyBaiHocController(panelData, searchField,
									labelIdHocLieu);
							controller.setDataToTable(hocLieu.getId());

						}
					});
					btnListBH.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnListBH.setBounds(10, 41, 110, 30);
					capNhatHocLieu.getContentPane().add(btnListBH);

					JButton btnEditHL = new JButton("S\u1EEDa");
					btnEditHL.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							capNhatHocLieu.setVisible(false);

							JFrame suaHocLieu = new JFrame();
							suaHocLieu.setTitle("Sửa Học Liệu");
							suaHocLieu.setBounds(100, 100, 450, 220);
							suaHocLieu.getContentPane().setLayout(null);
							suaHocLieu.setVisible(true);
							suaHocLieu.setLocationRelativeTo(null);

							JLabel lblNewLabel = new JLabel("Thông Tin");
							lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
							lblNewLabel.setBounds(136, 10, 143, 30);
							suaHocLieu.getContentPane().add(lblNewLabel);

							JLabel lblHocLieu = new JLabel("Tên Học Liệu:");
							lblHocLieu.setFont(new Font("Tahoma", Font.BOLD, 12));
							lblHocLieu.setBounds(10, 68, 90, 30);
							suaHocLieu.getContentPane().add(lblHocLieu);

							JTextField textHocLieu = new JTextField(model.getValueAt(selectedRowIndex, 0).toString());
							textHocLieu.setBounds(110, 68, 280, 30);
							suaHocLieu.getContentPane().add(textHocLieu);
							textHocLieu.setColumns(10);

							JButton btnUpdate = new JButton("Cập Nhật");
							btnUpdate.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									if (textHocLieu.getText().equals("")) {
										JOptionPane.showMessageDialog(null, "Tên học liệu không được để trống !");
									} else {
										HocLieuService hocLieuService = new HocLieuService();
										if (hocLieuService.updateHocLieu(hocLieu.getId(), textHocLieu.getText(),
												LocalDate.now())) {
											JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
										} else {
											JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
										}
									}
								}
							});
							btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
							btnUpdate.setBounds(163, 126, 90, 30);
							suaHocLieu.getContentPane().add(btnUpdate);
						}
					});
					btnEditHL.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnEditHL.setBounds(163, 41, 110, 30);
					capNhatHocLieu.getContentPane().add(btnEditHL);

					JButton btnDelete = new JButton("X\u00F3a");
					btnDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int check = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa học liệu này ?");
							if (check == 0) {
								HocLieuService hocLieuService = new HocLieuService();
								if (hocLieuService.deleteHocLieu(hocLieu.getId())) {
									JOptionPane.showMessageDialog(null, "Xóa thành công !");

								} else {
									JOptionPane.showMessageDialog(null, "Xóa thất bại !");
								}
							}
						}
					});
					btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnDelete.setBounds(316, 41, 110, 30);
					capNhatHocLieu.getContentPane().add(btnDelete);

				}
			}
		});

		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.setRowHeight(50);
		table.validate();
		table.repaint();

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		jPanelView.removeAll();
		jPanelView.setLayout(new CardLayout());
		jPanelView.add(scroll);
		jPanelView.validate();
		jPanelView.repaint();
	}
}
