package dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import dao.BaiHocDAO;
import entity.BaiHoc;
import utils.HibernateUtils;

public class BaiHocDAOImpl implements BaiHocDAO {

	@Override
	public BaiHoc addBaiHoc(BaiHoc baiHoc) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(baiHoc);
			session.getTransaction().commit();
			return baiHoc;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<BaiHoc> getBaiHocList(Long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<BaiHoc> listBH = session.createQuery("from BaiHoc where id_hoc_lieu=: id").setParameter("id", id)
					.list();
			session.getTransaction().commit();
			return listBH;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateBaiHoc(Long idHocLieu, String tenBaiHocUpdate, String tenBaiHoc, LocalDate ngayCapNhat,
			String wordSource, String slideSource, String btSource, String videoSource) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createQuery(
					"update BaiHoc set ten_bai=:tenBaiHocUpdate, update_at=:ngayCapNhat, word=:wordSource, slide=:slideSource, bai_tap=:btSource, video=:videoSource where idHocLieu=:id and ten_bai=:tenBaiHoc")
					.setParameter("id", idHocLieu).setParameter("tenBaiHocUpdate", tenBaiHocUpdate)
					.setParameter("tenBaiHoc", tenBaiHoc).setParameter("ngayCapNhat", ngayCapNhat)
					.setParameter("wordSource", wordSource).setParameter("slideSource", slideSource)
					.setParameter("btSource", btSource).setParameter("videoSource", videoSource).executeUpdate();
			session.createQuery("update HocLieu set update_at=:ngayCapNhat where id=:id").setParameter("id", idHocLieu)
					.setParameter("ngayCapNhat", ngayCapNhat).executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteBaiHoc(Long id, String tenBai) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createQuery("delete from BaiHoc where id_hoc_lieu=:id and ten_bai=:tenBai").setParameter("id", id)
					.setParameter("tenBai", tenBai).executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Long thongKeBaiHoc() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Long tongBaiHoc = (Long) session.createQuery("select count (*) from BaiHoc").uniqueResult();
			session.getTransaction().commit();
			return tongBaiHoc;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public BaiHoc getBaiHoc(Long id, String tenBai) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			BaiHoc baiHoc = session.createQuery("from BaiHoc where idHocLieu=:id and tenBai=:tenBai", BaiHoc.class)
					.setParameter("id", id).setParameter("tenBai", tenBai).uniqueResult();
			session.getTransaction().commit();
			return baiHoc;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
