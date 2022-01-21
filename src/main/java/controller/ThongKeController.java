package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import entity.User;
import service.ThongKeService;
import service.UserService;

public class ThongKeController {
	private ThongKeService tkService = new ThongKeService();

	public void setDataToLectureChart(JPanel jpanelItem) {
		List<?> listItem = tkService.getListByUser();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (listItem != null) {
			for (int i = 0; i < listItem.size(); i++) {
				Object[] row = (Object[]) listItem.get(i);
				UserService userService = new UserService();
				User user = userService.getUser(row[0] + "");
				dataset.addValue(Long.parseLong(row[1] + ""), "Học Liệu", user.getUserName());
			}
		}

		JFreeChart barChart = ChartFactory.createBarChart(
				"Biểu đồ thống kê số lượng học liệu của mỗi giảng viên".toUpperCase(), "Giảng viên", "Số lượng",
				dataset, PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(jpanelItem.getWidth(), 321));

		jpanelItem.removeAll();
		jpanelItem.setLayout(new CardLayout());
		jpanelItem.add(chartPanel);
		jpanelItem.validate();
		jpanelItem.repaint();
	}

	public void setDataToHocLieuChart(JPanel jpanelItem) {
		List<?> listItem = tkService.getListByHocLieu();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (listItem != null) {
			for (int i = 0; i < listItem.size(); i++) {
				Object[] row = (Object[]) listItem.get(i);
				dataset.addValue(Long.parseLong(row[1] + ""), "Bài Học", row[0] + "");
			}
		}

		JFreeChart barChart = ChartFactory.createBarChart(
				"Biểu đồ thống kê số lượng bài học của mỗi học liệu".toUpperCase(), "Học Liệu", "Bài Học",
				dataset, PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(jpanelItem.getWidth(), 321));

		jpanelItem.removeAll();
		jpanelItem.setLayout(new CardLayout());
		jpanelItem.add(chartPanel);
		jpanelItem.validate();
		jpanelItem.repaint();
	}
}
