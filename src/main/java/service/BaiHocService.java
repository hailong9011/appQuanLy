package service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.impl.BaiHocDAOImpl;
import entity.BaiHoc;

public class BaiHocService {
	public List<BaiHoc> getBaiHocList(Long id) {
		BaiHocDAOImpl bhDao = new BaiHocDAOImpl();
		return bhDao.getBaiHocList(id);
	}

	public BaiHoc addBaiHoc(BaiHoc baiHoc) {
		BaiHocDAOImpl bhDao = new BaiHocDAOImpl();
		return bhDao.addBaiHoc(baiHoc);
	}

	public Map<String, Object> checkAddBaiHoc(BaiHoc baiHoc, Long idHocLieu) {
		Map<String, Object> map = new HashMap<>();
		BaiHocDAOImpl bhDao = new BaiHocDAOImpl();
		List<BaiHoc> listBaiHoc = bhDao.getBaiHocList(idHocLieu);
		for (int i = 0; i < listBaiHoc.size(); i++) {
			if (baiHoc.getTenBai().equalsIgnoreCase(listBaiHoc.get(i).getTenBai())) {
				map.put("msg", "Tên bài học này đã tồn tại !");
				map.put("status", false);
				break;
			} else {
				map.put("msg", "Thêm thành công !");
				map.put("status", true);
			}
		}
		return map;
	}

	public boolean updateBaiHoc(Long idHocLieu, String tenBaiHocUpdate, String tenBaiHoc, LocalDate ngayCapNhat,
			String wordSource, String slideSource, String btSource, String videoSource) {
		BaiHocDAOImpl bhDao = new BaiHocDAOImpl();
		return bhDao.updateBaiHoc(idHocLieu, tenBaiHoc, tenBaiHocUpdate, ngayCapNhat, wordSource, slideSource, btSource,
				videoSource);
	}

	public boolean deleteBaiHoc(Long id, String tenBai) {
		BaiHocDAOImpl bhDao = new BaiHocDAOImpl();
		return bhDao.deleteBaiHoc(id, tenBai);
	}

	public Long thongKeBaiHoc() {
		BaiHocDAOImpl bhDao = new BaiHocDAOImpl();
		return bhDao.thongKeBaiHoc();
	}

	public BaiHoc getBaiHoc(Long id, String tenBaiHoc) {
		BaiHocDAOImpl bhDao = new BaiHocDAOImpl();
		return bhDao.getBaiHoc(id, tenBaiHoc);
	}
}
