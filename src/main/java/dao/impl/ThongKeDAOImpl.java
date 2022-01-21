package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.ThongKeDAO;
import entity.ThongKeBaiHocTheoHocLieu;
import entity.ThongKeHocLieuTheoUser;
import utils.HibernateUtils;

public class ThongKeDAOImpl implements ThongKeDAO {

	@Override
	public List<ThongKeHocLieuTheoUser> getListByUser() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<ThongKeHocLieuTheoUser> list = session
					.createQuery("select nguoiThem, count(*) as tongHocLieu from HocLieu group by nguoiThem").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ThongKeBaiHocTheoHocLieu> getListByHocLieu() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<ThongKeBaiHocTheoHocLieu> list = session.createSQLQuery(
					"select hoc_lieu.ten_hoc_lieu, count(bai_hoc.id) as tongBaiHoc from hoc_lieu,bai_hoc where hoc_lieu.id=bai_hoc.id_hoc_lieu group by hoc_lieu.ten_hoc_lieu")
					.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Long countHocLieuOfLecture(String email) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Long count = (Long) session.createQuery("select count(*) as tong from HocLieu where create_by=:email")
					.setParameter("email", email).uniqueResult();
			session.getTransaction().commit();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
