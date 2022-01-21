package dao;

import java.time.LocalDate;
import java.util.List;

import entity.HocLieu;

public interface HocLieuDAO {

	public HocLieu addHocLieu(HocLieu hocLieu);

	public boolean updateHocLieu(Long id, String tenHocLieu, LocalDate ngayCapNhat);

	public boolean deleteHocLieu(Long id);

	public HocLieu getHocLieu(String tenHocLieu);

	public List<HocLieu> getHocLieuList();

	public List<HocLieu> getHocLieuListByLecture(String email);

	public Long thongKeHocLieu();

}
