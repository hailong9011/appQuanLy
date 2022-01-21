package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entity.BaiHoc;
import entity.TableModelCustom;
import service.BaiHocService;

public class QuanLyBaiHocController {
	private JPanel jPanelView;
	private JTextField jTextFieldSearch;
	private JLabel labelId;

	static int selectedRowIndex;

	static JLabel lblWord = new JLabel("");
	static JLabel lblSlide = new JLabel("");
	static JLabel lblBaiTap = new JLabel("");
	static JLabel lblVideo = new JLabel("");

	static String tenBai;
	static String wordSource;
	static String slideSource;
	static String btSource;
	static String videoSource;

	private TableModelCustom tableModel = null;

	private final String[] COLUMNS = { "Tên bài học", "Word", "Slide", "Bài tập", "Video", "Ngày tạo",
			"Ngày cập nhật" };

	private BaiHocService baiHocService = null;

	private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyBaiHocController(JPanel jPanelView, JTextField jTextFieldSearch, JLabel labelId) {
		super();
		this.jPanelView = jPanelView;
		this.labelId = labelId;
		this.jTextFieldSearch = jTextFieldSearch;
		this.tableModel = new TableModelCustom();
		this.baiHocService = new BaiHocService();
	}

	public void setDataToTable(Long id) {

		List<BaiHoc> listItem = baiHocService.getBaiHocList(id);
		DefaultTableModel model = tableModel.setTableBaiHoc(listItem, COLUMNS);
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
					tenBai = model.getValueAt(selectedRowIndex, 0).toString();

					BaiHocService bhService = new BaiHocService();
					BaiHoc baiHoc = bhService.getBaiHoc(id, tenBai);

					JFrame capNhatBaiHoc = new JFrame();
					capNhatBaiHoc.setTitle("Cập Nhật Bài Học");
					capNhatBaiHoc.setBounds(100, 100, 475, 400);
					capNhatBaiHoc.getContentPane().setLayout(null);
					capNhatBaiHoc.setVisible(true);
					capNhatBaiHoc.setLocationRelativeTo(null);

					JLabel lblNewLabel_2 = new JLabel("Word:");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_2.setBounds(10, 85, 75, 39);
					capNhatBaiHoc.getContentPane().add(lblNewLabel_2);

					JLabel lblNewLabel_3 = new JLabel("Chi Tiết Bài Học");
					lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
					lblNewLabel_3.setBounds(106, 10, 248, 57);
					capNhatBaiHoc.getContentPane().add(lblNewLabel_3);

					JLabel lblNewLabel_2_1 = new JLabel("Slide:");
					lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_2_1.setBounds(10, 134, 75, 39);
					capNhatBaiHoc.getContentPane().add(lblNewLabel_2_1);

					JLabel lblNewLabel_2_2 = new JLabel("Bài tập:");
					lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_2_2.setBounds(10, 183, 75, 39);
					capNhatBaiHoc.getContentPane().add(lblNewLabel_2_2);

					JLabel lblNewLabel_2_3 = new JLabel("Video:");
					lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_2_3.setBounds(10, 232, 75, 39);
					capNhatBaiHoc.getContentPane().add(lblNewLabel_2_3);

					if (model.getValueAt(selectedRowIndex, 1) != null) {
						JLabel wordName = new JLabel(model.getValueAt(selectedRowIndex, 1).toString());
						wordName.addMouseListener(new MouseListener() {

							@Override
							public void mouseReleased(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseExited(MouseEvent e) {
								wordName.setForeground(new Color(0, 0, 0));
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								wordName.setForeground(new Color(0, 0, 255));
							}

							@Override
							public void mouseClicked(MouseEvent e) {
								try {
									File file = new File(baiHoc.getWord());
									Desktop dt = Desktop.getDesktop();
									dt.open(file);
								} catch (Exception e2) {
								}
							}
						});
						wordName.setFont(new Font("Tahoma", Font.BOLD, 12));
						wordName.setBounds(105, 85, 343, 39);
						capNhatBaiHoc.getContentPane().add(wordName);
					} else {
						JLabel wordName = new JLabel("");
						wordName.setFont(new Font("Tahoma", Font.BOLD, 12));
						wordName.setBounds(105, 85, 343, 39);
						capNhatBaiHoc.getContentPane().add(wordName);
					}
					if (model.getValueAt(selectedRowIndex, 2) != null) {
						JLabel slideName = new JLabel(model.getValueAt(selectedRowIndex, 2).toString());
						slideName.addMouseListener(new MouseListener() {

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
								slideName.setForeground(new Color(0, 0, 0));
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								slideName.setForeground(new Color(0, 0, 255));
							}

							@Override
							public void mouseClicked(MouseEvent e) {
								try {
									File file = new File(baiHoc.getSlide());
									Desktop dt = Desktop.getDesktop();
									dt.open(file);
								} catch (Exception e2) {
								}
							}
						});
						slideName.setFont(new Font("Tahoma", Font.BOLD, 12));
						slideName.setBounds(105, 134, 343, 39);
						capNhatBaiHoc.getContentPane().add(slideName);
					} else {
						JLabel slideName = new JLabel("");
						slideName.setFont(new Font("Tahoma", Font.BOLD, 12));
						slideName.setBounds(105, 134, 343, 39);
						capNhatBaiHoc.getContentPane().add(slideName);
					}
					if (model.getValueAt(selectedRowIndex, 3) != null) {
						JLabel btName = new JLabel(model.getValueAt(selectedRowIndex, 3).toString());
						btName.addMouseListener(new MouseListener() {

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
								btName.setForeground(new Color(0, 0, 0));
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								btName.setForeground(new Color(0, 0, 255));
							}

							@Override
							public void mouseClicked(MouseEvent e) {
								try {
									File file = new File(baiHoc.getBaiTap());
									Desktop dt = Desktop.getDesktop();
									dt.open(file);
								} catch (Exception e2) {
								}
							}
						});
						btName.setFont(new Font("Tahoma", Font.BOLD, 12));
						btName.setBounds(105, 183, 343, 39);
						capNhatBaiHoc.getContentPane().add(btName);
					} else {
						JLabel btName = new JLabel("");
						btName.setFont(new Font("Tahoma", Font.BOLD, 12));
						btName.setBounds(105, 183, 343, 39);
						capNhatBaiHoc.getContentPane().add(btName);
					}
					if (model.getValueAt(selectedRowIndex, 4) != null) {
						JLabel videoName = new JLabel(model.getValueAt(selectedRowIndex, 4).toString());
						videoName.addMouseListener(new MouseListener() {

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
								videoName.setForeground(new Color(0, 0, 0));
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								videoName.setForeground(new Color(0, 0, 255));
							}

							@Override
							public void mouseClicked(MouseEvent e) {
								try {
									File file = new File(baiHoc.getVideo());
									Desktop dt = Desktop.getDesktop();
									dt.open(file);
								} catch (Exception e2) {
								}
							}
						});
						videoName.setFont(new Font("Tahoma", Font.BOLD, 12));
						videoName.setBounds(105, 232, 343, 39);
						capNhatBaiHoc.getContentPane().add(videoName);
					} else {
						JLabel videoName = new JLabel("");
						videoName.setFont(new Font("Tahoma", Font.BOLD, 12));
						videoName.setBounds(105, 232, 343, 39);
						capNhatBaiHoc.getContentPane().add(videoName);
					}

					JButton btnEditHL = new JButton("S\u1EEDa");
					btnEditHL.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JFrame suaBaiHoc = new JFrame();
							suaBaiHoc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							suaBaiHoc.setBounds(100, 100, 450, 400);
							suaBaiHoc.setTitle("Thông tin học liệu");
							suaBaiHoc.setResizable(false);
							suaBaiHoc.setLocationRelativeTo(null);
							suaBaiHoc.getContentPane().setLayout(null);

							JPanel panel = new JPanel();
							panel.setBounds(0, 0, 446, 375);
							suaBaiHoc.getContentPane().add(panel);
							panel.setLayout(null);

							JLabel lblNewLabel = new JLabel("Sửa Bài Học");
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

							JTextField textFieldBaiHoc = new JTextField(tenBai);
							textFieldBaiHoc.setBounds(75, 61, 350, 35);
							panel.add(textFieldBaiHoc);
							textFieldBaiHoc.setColumns(10);

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

							if (model.getValueAt(selectedRowIndex, 1) == (null)) {
								lblWord = new JLabel("");
								lblWord.setBounds(185, 106, 240, 35);
								panel.add(lblWord);
							} else {
								lblWord = new JLabel(model.getValueAt(selectedRowIndex, 1).toString());
								lblWord.setBounds(185, 106, 240, 35);
								panel.add(lblWord);
							}
							if (model.getValueAt(selectedRowIndex, 2) == (null)) {
								lblSlide = new JLabel("");
								lblSlide.setBounds(185, 157, 240, 35);
								panel.add(lblSlide);
							} else {
								lblSlide = new JLabel(model.getValueAt(selectedRowIndex, 2).toString());
								lblSlide.setBounds(185, 157, 240, 35);
								panel.add(lblSlide);
							}
							if (model.getValueAt(selectedRowIndex, 3) == (null)) {
								lblBaiTap = new JLabel("");
								lblBaiTap.setBounds(185, 208, 240, 35);
								panel.add(lblBaiTap);
							} else {
								lblBaiTap = new JLabel(model.getValueAt(selectedRowIndex, 3).toString());
								lblBaiTap.setBounds(185, 208, 240, 35);
								panel.add(lblBaiTap);
							}
							if (model.getValueAt(selectedRowIndex, 4) == (null)) {
								lblVideo = new JLabel("");
								lblVideo.setBounds(185, 259, 240, 35);
								panel.add(lblVideo);
							} else {
								lblVideo = new JLabel(model.getValueAt(selectedRowIndex, 4).toString());
								lblVideo.setBounds(185, 259, 240, 35);
								panel.add(lblVideo);
							}

							JButton btnUpdate = new JButton("Cập Nhật");
							btnUpdate.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									if (textFieldBaiHoc.getText().equals("")) {
										JOptionPane.showMessageDialog(null, "Tên bài học không được để trống");
									} else {
										BaiHoc baiHoc = bhService.getBaiHoc(id, tenBai);
										if (wordSource == null) {
											wordSource = baiHoc.getWord();
										}
										if (slideSource == null) {
											slideSource = baiHoc.getSlide();
										}
										if (btSource == null) {
											btSource = baiHoc.getBaiTap();
										}
										if (videoSource == null) {
											videoSource = baiHoc.getVideo();
										}
										if (bhService.updateBaiHoc(id, textFieldBaiHoc.getText(),
												model.getValueAt(selectedRowIndex, 0).toString(), LocalDate.now(),
												wordSource, slideSource, btSource, videoSource)) {
											JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
										} else {
											JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
										}
									}
								}
							});

							btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
							btnUpdate.setBounds(111, 319, 100, 35);
							panel.add(btnUpdate);

							JButton btntReset = new JButton("Đặt lại");
							btntReset.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									wordSource = "";
									slideSource = "";
									btSource = "";
									videoSource = "";
									lblWord.setText("");
									lblSlide.setText("");
									lblBaiTap.setText("");
									lblVideo.setText("");
								}
							});
							btntReset.setFont(new Font("Tahoma", Font.BOLD, 12));
							btntReset.setBounds(234, 319, 100, 35);
							panel.add(btntReset);

							suaBaiHoc.setVisible(true);
						}
					});
					btnEditHL.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnEditHL.setBounds(119, 285, 110, 30);
					capNhatBaiHoc.getContentPane().add(btnEditHL);

					JButton btnDelete = new JButton("X\u00F3a");
					btnDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int check = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa học liệu này ?");
							if (check == 0) {
								BaiHocService bhService = new BaiHocService();
								Long idHocLieu = Long.parseLong(labelId.getText());
								if (bhService.deleteBaiHoc(idHocLieu, tenBai)) {
									JOptionPane.showMessageDialog(null, "Xóa thành công !");
								} else {
									JOptionPane.showMessageDialog(null, "Xóa thất bại !");
								}
							}
						}
					});
					btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnDelete.setBounds(265, 285, 110, 30);
					capNhatBaiHoc.getContentPane().add(btnDelete);
				}
			}
		});

		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
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
