package dao;

import java.time.LocalDate;
import java.util.List;

import entity.BaiHoc;

public interface BaiHocDAO {

	public BaiHoc addBaiHoc(BaiHoc baiHoc);

	public boolean updateBaiHoc(Long idHocLieu, String tenBaiHocUpdate, String tenBaiHoc, LocalDate ngayCapNhat,
			String wordSource, String slideSource, String btSource, String videoSource);

	public boolean deleteBaiHoc(Long id, String tenBai);

	public BaiHoc getBaiHoc(Long id, String tenBai);

	public List<BaiHoc> getBaiHocList(Long id);

	public Long thongKeBaiHoc();

}
