package service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.impl.HocLieuDAOImpl;
import entity.HocLieu;

public class HocLieuService {
	public List<HocLieu> getHocLieuList() {
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		return hlDao.getHocLieuList();
	}

	public HocLieu addHocLieu(HocLieu hocLieu) {
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		return hlDao.addHocLieu(hocLieu);
	}

	public Map<String, Object> checkAddHocLieu(HocLieu hocLieu) {
		Map<String, Object> map = new HashMap<>();
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		List<HocLieu> listHocLieu = hlDao.getHocLieuList();
		for (int i = 0; i < listHocLieu.size(); i++) {
			if (hocLieu.getHocLieu().equalsIgnoreCase(listHocLieu.get(i).getHocLieu())) {
				map.put("msg", "Học liệu này đã tồn tại !");
				map.put("status", false);
				break;
			} else {
				map.put("msg", "Thêm thành công !");
				map.put("status", true);
			}
		}
		return map;
	}

	public boolean updateHocLieu(Long id, String tenHocLieu, LocalDate ngayCapNhat) {
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		return hlDao.updateHocLieu(id, tenHocLieu, ngayCapNhat);
	}

	public Map<String, Object> checkUpdateHocLieu(String tenHocLieu) {
		Map<String, Object> map = new HashMap<>();
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		List<HocLieu> listHocLieu = hlDao.getHocLieuList();
		for (int i = 0; i < listHocLieu.size(); i++) {
			if (tenHocLieu.equalsIgnoreCase(listHocLieu.get(i).getHocLieu())) {
				map.put("msg", "Tên học liệu này đã tồn tại !");
				map.put("status", false);
				break;
			} else {
				map.put("msg", "Cập nhật thành công !");
				map.put("status", true);
			}
		}
		return map;
	}

	public boolean deleteHocLieu(Long id) {
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		return hlDao.deleteHocLieu(id);
	}

	public HocLieu getHocLieu(String tenHocLieu) {
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		return hlDao.getHocLieu(tenHocLieu);
	}

	public Long thongKeHocLieu() {
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		return hlDao.thongKeHocLieu();
	}

	public List<HocLieu> getListHocLieuByLecture(String email) {
		HocLieuDAOImpl hlDao = new HocLieuDAOImpl();
		return hlDao.getHocLieuListByLecture(email);
	}

}
