package dao;

import java.time.LocalDate;
import java.util.List;

import entity.BaiHoc;

public interface BaiHocDAO {
	public BaiHoc addBaiHoc(BaiHoc baiHoc);

	public List<BaiHoc> getBaiHocList(Long id);

	public boolean deleteBaiHoc(Long id, String tenBai);

	public boolean updateBaiHoc(Long idHocLieu, String tenBaiHocUpdate, String tenBaiHoc, LocalDate ngayCapNhat,
			String wordSource, String slideSource, String btSource, String videoSource);

	public Long thongKeBaiHoc();

	public BaiHoc getBaiHoc(Long id, String tenBai);
}
