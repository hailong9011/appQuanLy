package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

import entity.TabSelect;
import entity.User;
import viewsAdmin.QuanLyGiangVien;
import viewsAdmin.QuanLyHocLieu;
import viewsAdmin.QuanLyNguoiDung;
import viewsAdmin.ThongKe;
import viewsAdmin.TrangChu;

public class TabViewAdmin {
	private JPanel root;
	private String panelSelected = "";
	private List<TabSelect> listItem;
	private User user;

	public TabViewAdmin(JPanel panelRoot, User user) {
		this.root = panelRoot;
		this.user = user;
	}

	public void addView(JPanel panelItem) {
		panelSelected = "TrangChu";
		panelItem.setBackground(new Color(255, 140, 0));

		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new TrangChu());
		root.validate();
		root.repaint();
	}

	public void addEvent(List<TabSelect> listItem) {
		this.listItem = listItem;
		for (TabSelect item : listItem) {
			item.getjPanel().addMouseListener(new LabelEvent(item.getjPanel(), item.getPanel()));
		}
	}

	class LabelEvent implements MouseListener {
		private JPanel jPanelItem, panel;
		private String onClick;

		public LabelEvent(JPanel jPanelItem, String onClick) {
			super();
			this.jPanelItem = jPanelItem;
			this.onClick = onClick;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (onClick) {
			case "TrangChu":
				panel = new TrangChu();
				break;
			case "QuanLyHocLieu":
				panel = new QuanLyHocLieu(user);
				break;
			case "QuanLyNguoiDung":
				panel = new QuanLyNguoiDung();
				break;
			case "ThongKe":
				panel = new ThongKe();
				break;
			case "QuanLyGiangVien":
				panel = new QuanLyGiangVien();
				break;
			default:
				break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(panel);
			root.validate();
			root.repaint();
			setChangeBackground(onClick);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panelSelected = onClick;
			jPanelItem.setBackground(new Color(255, 140, 0));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jPanelItem.setBackground(new Color(255, 140, 0));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!panelSelected.equalsIgnoreCase(onClick)) {
				jPanelItem.setBackground(new Color(100, 149, 237));
			}
		}
	}

	private void setChangeBackground(String panel) {
		for (TabSelect item : listItem) {
			if (item.getPanel().equalsIgnoreCase(panel)) {
				item.getjPanel().setBackground(new Color(255, 140, 0));
			} else {
				item.getjPanel().setBackground(new Color(100, 149, 237));
			}
		}
	}
}
