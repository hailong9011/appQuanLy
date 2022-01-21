package viewsAdmin;

import javax.swing.JPanel;

import controller.ThongKeController;

public class ThongKe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ThongKe() {
		setLayout(null);

		JPanel barChartHocLieu = new JPanel();
		barChartHocLieu.setBounds(10, 10, 772, 340);
		add(barChartHocLieu);

		JPanel barChartLecture = new JPanel();
		barChartLecture.setBounds(10, 360, 772, 346);
		add(barChartLecture);

		ThongKeController controller = new ThongKeController();
		controller.setDataToLectureChart(barChartLecture);
		controller.setDataToHocLieuChart(barChartHocLieu);
	}
}
