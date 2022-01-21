package entity;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import service.UserService;

public class TableModelCustom {
	public DefaultTableModel setTableUser(List<User> listItem, String[] listColumn) {
		int columns = listColumn.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(listColumn);
		Object[] obj;
		int num = listItem.size();
		User user = null;
		for (int i = 0; i < num; i++) {
			user = listItem.get(i);
			obj = new Object[columns];
			obj[0] = user.getEmail();
			obj[1] = user.getUserName();
			obj[2] = user.getRole();
			dtm.addRow(obj);
		}
		return dtm;
	}

	public DefaultTableModel setTableHocLieu(List<HocLieu> listItem, String[] listColumn) {
		int columns = listColumn.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(listColumn);
		Object[] obj;
		int num = listItem.size();
		HocLieu hocLieu = null;
		UserService userService = new UserService();
		for (int i = 0; i < num; i++) {
			hocLieu = listItem.get(i);
			obj = new Object[columns];
			obj[0] = hocLieu.getHocLieu();
			obj[1] = hocLieu.getNgayTao();
			obj[2] = hocLieu.getNgayCapNhat();
			User user = userService.getUser(hocLieu.getNguoiThem());
			obj[3] = user.getUserName();
			dtm.addRow(obj);
		}
		return dtm;
	}

	public DefaultTableModel setTableBaiHoc(List<BaiHoc> listItem, String[] listColumn) {
		int columns = listColumn.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(listColumn);
		Object[] obj;
		int num = listItem.size();
		BaiHoc baiHoc = null;
		for (int i = 0; i < num; i++) {
			baiHoc = listItem.get(i);
			obj = new Object[columns];
			obj[0] = baiHoc.getTenBai();
			obj[1] = catChuoi(baiHoc.getWord());
			obj[2] = catChuoi(baiHoc.getSlide());
			obj[3] = catChuoi(baiHoc.getBaiTap());
			obj[4] = catChuoi(baiHoc.getVideo());
			obj[5] = baiHoc.getNgayTao();
			obj[6] = baiHoc.getNgayCapNhat();
			dtm.addRow(obj);
		}
		return dtm;
	}

	public String catChuoi(String source) {
		String input = "";
		if (source != null && source.length() != 0) {
			for (int i = source.length() - 1; i >= 0; i--) {
				if (source.charAt(i) == 92) {
					break;
				} else {
					input += source.charAt(i);
				}
			}
			StringBuilder outPut = new StringBuilder(input);
			return outPut.reverse().toString();
		} else {
			return null;
		}
	}
}
