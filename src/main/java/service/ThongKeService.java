package service;

import java.util.List;

import dao.impl.ThongKeDAOImpl;
import entity.ThongKeBaiHocTheoHocLieu;
import entity.ThongKeHocLieuTheoUser;

public class ThongKeService {
	public List<ThongKeHocLieuTheoUser> getListByUser() {
		ThongKeDAOImpl tkDao = new ThongKeDAOImpl();
		return tkDao.getListByUser();
	}

	public List<ThongKeBaiHocTheoHocLieu> getListByHocLieu() {
		ThongKeDAOImpl tkDao = new ThongKeDAOImpl();
		return tkDao.getListByHocLieu();
	}

	public Long countHocLieuOfLecture(String email) {
		ThongKeDAOImpl tkDao = new ThongKeDAOImpl();
		return tkDao.countHocLieuOfLecture(email);
	}
}
