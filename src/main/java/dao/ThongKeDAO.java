package dao;

import java.util.List;

import entity.ThongKeBaiHocTheoHocLieu;
import entity.ThongKeHocLieuTheoUser;

public interface ThongKeDAO {
	public List<ThongKeHocLieuTheoUser> getListByUser();

	public List<ThongKeBaiHocTheoHocLieu> getListByHocLieu();

	public Long countHocLieuOfLecture(String email);

}
