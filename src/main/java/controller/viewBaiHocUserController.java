package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class viewBaiHocUserController {
	private JPanel jPanelView;
	private JTextField jTextFieldSearch;

	static int selectedRowIndex;

	static JLabel lblWord = new JLabel("");
	static JLabel lblSlide = new JLabel("");
	static JLabel lblBaiTap = new JLabel("");
	static JLabel lblVideo = new JLabel("");
	static String tenBai;

	private TableModelCustom tableModel = null;

	private final String[] COLUMNS = { "Tên bài học", "Word", "Slide", "Bài tập", "Video", "Ngày tạo",
			"Ngày cập nhật" };

	private BaiHocService baiHocService = null;

	private TableRowSorter<TableModel> rowSorter = null;

	public viewBaiHocUserController(JPanel jPanelView, JTextField jTextFieldSearch) {
		super();
		this.jPanelView = jPanelView;
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
					capNhatBaiHoc.setBounds(100, 100, 475, 350);
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
