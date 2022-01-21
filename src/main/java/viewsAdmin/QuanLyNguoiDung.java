package viewsAdmin;

import javax.swing.JPanel;

import controller.QuanLyNguoiDungController;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyNguoiDung extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public QuanLyNguoiDung() {
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel jPanelView = new JPanel();
		jPanelView.setBounds(0, 71, 803, 649);
		add(jPanelView);

		JTextField jTextFieldSearch = new JTextField();
		jTextFieldSearch.setBounds(10, 10, 299, 50);
		add(jTextFieldSearch);
		jTextFieldSearch.setColumns(10);

		JLabel lblRenew = new JLabel("");
		lblRenew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuanLyNguoiDungController controller = new QuanLyNguoiDungController(jPanelView, jTextFieldSearch);
				controller.setDataToTable();
			}
		});
		lblRenew.setIcon(new ImageIcon(
				"C:\\Users\\hailo\\eclipse-workspace\\QuanLyHocLieu\\Image\\2x\\outline_autorenew_black_24dp.png"));
		lblRenew.setBounds(741, 10, 52, 51);
		add(lblRenew);

		QuanLyNguoiDungController controller = new QuanLyNguoiDungController(jPanelView, jTextFieldSearch);
		controller.setDataToTable();
	}
}
