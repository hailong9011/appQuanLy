package entity;

import javax.swing.JPanel;

public class TabSelect {
	private String panel;
	private JPanel jPanel;

	public TabSelect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TabSelect(String panel, JPanel jPanel) {
		super();
		this.panel = panel;
		this.jPanel = jPanel;
	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

}
