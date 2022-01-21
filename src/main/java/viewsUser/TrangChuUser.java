package viewsUser;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.viewHocLieuUserController;

public class TrangChuUser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TrangChuUser() {
		setBackground(SystemColor.control);
		setLayout(null);

		JPanel panelButton = new JPanel();
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelButton.setBackground(Color.WHITE);
		panelButton.setBounds(0, 0, 803, 57);
		add(panelButton);
		panelButton.setLayout(null);

		JTextField searchField = new JTextField();
		searchField.setBounds(10, 10, 230, 37);
		panelButton.add(searchField);
		searchField.setColumns(10);

		JPanel panelTable = new JPanel();
		panelTable.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panelTable.setBounds(0, 51, 803, 669);
		add(panelTable);

		viewHocLieuUserController controller = new viewHocLieuUserController(panelTable, searchField);
		controller.setDataToTable();

	}

}
