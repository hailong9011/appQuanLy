package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entity.TableModelCustom;
import entity.User;
import service.UserService;

public class QuanLyNguoiDungController {
	private JPanel jPanelView;
	private JTextField jTextFieldSearch;

	static int selectedRowIndex;

	private TableModelCustom tableModel = null;

	private final String[] COLUMNS = { "Email", "Tên người dùng", "Chức vụ" };

	private UserService userService = null;

	private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyNguoiDungController(JPanel jPanelView, JTextField jTextFieldSearch) {
		super();
		this.jPanelView = jPanelView;
		this.jTextFieldSearch = jTextFieldSearch;
		this.tableModel = new TableModelCustom();
		this.userService = new UserService();
	}

	public void setDataToTable() {
		List<User> listItem = userService.getUserList();
		DefaultTableModel model = tableModel.setTableUser(listItem, COLUMNS);
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
					String email = model.getValueAt(selectedRowIndex, 0).toString();
					User user = userService.getUser(email);

					JFrame phanQuyen = new JFrame();
					phanQuyen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					phanQuyen.setBounds(100, 100, 352, 175);
					phanQuyen.setTitle("Phân Quyền");
					phanQuyen.setResizable(false);
					phanQuyen.setLocationRelativeTo(null);
					phanQuyen.getContentPane().setLayout(null);
					phanQuyen.setVisible(true);

					JPanel panel = new JPanel();
					panel.setBounds(0, 0, 350, 147);
					phanQuyen.getContentPane().add(panel);
					panel.setLayout(null);

					JRadioButton rdbtnUser = new JRadioButton("Người dùng");
					ButtonGroup buttonGroup = new ButtonGroup();
					rdbtnUser.setActionCommand("Người dùng");
					buttonGroup.add(rdbtnUser);
					if (user.getRole().equals("Người dùng")) {
						rdbtnUser.setSelected(true);
					} else {
						rdbtnUser.setSelected(false);
					}
					rdbtnUser.setFont(new Font("Tahoma", Font.BOLD, 12));
					rdbtnUser.setBounds(52, 35, 103, 21);
					panel.add(rdbtnUser);

					JRadioButton rdbtnLecture = new JRadioButton("Giảng viên");
					rdbtnLecture.setActionCommand("Giảng viên");
					buttonGroup.add(rdbtnLecture);
					if (user.getRole().equals("Giảng viên")) {
						rdbtnLecture.setSelected(true);
					} else {
						rdbtnLecture.setSelected(false);
					}
					rdbtnLecture.setFont(new Font("Tahoma", Font.BOLD, 12));
					rdbtnLecture.setBounds(193, 35, 103, 21);
					panel.add(rdbtnLecture);

					JButton btnSetRole = new JButton("Cập nhật");
					btnSetRole.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							UserService userService = new UserService();
							if (userService.setRoleUser(email, buttonGroup.getSelection().getActionCommand())) {
								JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
							} else {
								JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
							}
						}
					});
					btnSetRole.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnSetRole.setBounds(127, 85, 95, 30);
					panel.add(btnSetRole);
				}
			}
		});

		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
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
