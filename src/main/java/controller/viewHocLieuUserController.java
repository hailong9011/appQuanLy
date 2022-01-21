package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entity.HocLieu;
import entity.TableModelCustom;
import service.HocLieuService;

public class viewHocLieuUserController {
	private JPanel jPanelView;
	private JTextField jTextFieldSearch;
	private HocLieu hocLieu;
	private String tenHocLieu;

	static String wordSource;
	static String slideSource;
	static String btSource;
	static String videoSource;

	static int selectedRowIndex;

	private TableModelCustom tableModel = null;

	private final String[] COLUMNS = { "Tên học liệu", "Ngày tạo", "Ngày cập nhật", "Người thêm" };

	private HocLieuService hocLieuService = null;

	private TableRowSorter<TableModel> rowSorter = null;

	public viewHocLieuUserController(JPanel jPanelView, JTextField jTextFieldSearch) {
		super();
		this.jPanelView = jPanelView;
		this.jTextFieldSearch = jTextFieldSearch;
		this.tableModel = new TableModelCustom();
		this.hocLieuService = new HocLieuService();
	}

	public void setDataToTable() {

		List<HocLieu> listItem = hocLieuService.getHocLieuList();
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

					viewBaiHocUserController controller = new viewBaiHocUserController(panelData, searchField);
					controller.setDataToTable(hocLieu.getId());

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
