package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

import entity.TabSelect;
import viewsUser.TrangChuUser;
import viewsUser.ThongTinTaiKhoanUser;

public class TabViewUser {
	private JPanel root;
	private String panelSelected = "";
	private List<TabSelect> listItem;

	public TabViewUser(JPanel panelRoot) {
		this.root = panelRoot;
	}

	public void addView(JPanel panelItem) {
		panelSelected = "TrangChuUser";
		panelItem.setBackground(new Color(255, 140, 0));

		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new TrangChuUser());
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
			case "TrangChuUser":
				panel = new TrangChuUser();
				break;
			case "ThongTinTaiKhoanUser":
				panel = new ThongTinTaiKhoanUser();
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
