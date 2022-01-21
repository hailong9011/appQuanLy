package dao.impl;

import java.util.List;

import org.hibernate.Session;

import dao.UserDAO;
import entity.User;
import utils.HibernateUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public User registry(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean setRoleUser(String email, String role) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createQuery("update User set role=:role where email=:email").setParameter("role", role)
					.setParameter("email", email).executeUpdate();
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
	public User login(String email, String password) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User user = (User) session.createQuery("from User where email=:email").setParameter("email", email)
					.uniqueResult();
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> getListUser() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<User> listUser = session.createQuery("from User where role <>: role").setParameter("role", "Admin")
					.list();
			session.getTransaction().commit();
			return listUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public User getUser(String email) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User user = session.createQuery("from User where email=:email", User.class).setParameter("email", email)
					.uniqueResult();
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean resetPassword(String email, String password) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createQuery("update User set password=:password where email=:email").setParameter("email", email)
					.setParameter("password", password).executeUpdate();
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
	public Long thongKeUser() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String role = "Admin";
			Long tongUser = (Long) session.createQuery("select count(*) from User where role <>: role")
					.setParameter("role", role).uniqueResult();
			session.getTransaction().commit();
			return tongUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> getListLecture() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<User> listUser = session.createQuery("from User where role =: role").setParameter("role", "Giảng viên")
					.list();
			session.getTransaction().commit();
			return listUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> getListStudent() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<User> listUser = session.createQuery("from User where role =: role").setParameter("role", "Người dùng")
					.list();
			session.getTransaction().commit();
			return listUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}
}
