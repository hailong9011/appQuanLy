package dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import dao.HocLieuDAO;
import entity.HocLieu;
import utils.HibernateUtils;

public class HocLieuDAOImpl implements HocLieuDAO {

	@Override
	public List<HocLieu> getHocLieuList() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<HocLieu> listHL = session.createQuery("from HocLieu").list();
			session.getTransaction().commit();
			return listHL;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public HocLieu addHocLieu(HocLieu hocLieu) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(hocLieu);
			session.getTransaction().commit();
			return hocLieu;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteHocLieu(Long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createQuery("delete from BaiHoc where id_hoc_lieu=:id").setParameter("id", id).executeUpdate();
			session.createQuery("delete from HocLieu where id=:id").setParameter("id", id).executeUpdate();
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
	public boolean updateHocLieu(Long id, String tenHocLieu, LocalDate ngayCapNhat) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createQuery("update HocLieu set ten_hoc_lieu=:tenHocLieu, update_at=:ngayCapNhat where id=:id")
					.setParameter("id", id).setParameter("tenHocLieu", tenHocLieu)
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
	public HocLieu getHocLieu(String tenHocLieu) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			HocLieu hocLieu = session.createQuery("from HocLieu where hocLieu=:tenHocLieu", HocLieu.class)
					.setParameter("tenHocLieu", tenHocLieu).uniqueResult();
			session.getTransaction().commit();
			return hocLieu;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Long thongKeHocLieu() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Long tongHocLieu = (Long) session.createQuery("select count (*) from HocLieu").uniqueResult();
			session.getTransaction().commit();
			return tongHocLieu;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<HocLieu> getHocLieuListByLecture(String email) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<HocLieu> listHL = session.createQuery("from HocLieu where nguoiThem=:email")
					.setParameter("email", email).list();
			session.getTransaction().commit();
			return listHL;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
