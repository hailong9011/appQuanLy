package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

import dao.impl.UserDAOImpl;
import entity.User;

public class UserService {
	public Map<String, Object> checkRegistry(User user, String email) {
		Map<String, Object> map = new HashMap<>();
		UserDAOImpl userDao = new UserDAOImpl();
		List<User> listUser = userDao.getListUser();
		for (int i = 0; i < listUser.size(); i++) {
			if (user.getEmail().equalsIgnoreCase(listUser.get(i).getEmail())) {
				map.put("msg", "Email đã tồn tại !");
				map.put("status", false);
				break;
			} else {
				map.put("msg", "Đăng ký thành công !");
				map.put("status", true);
			}
		}
		return map;
	}

	public User registry(User user) {
		UserDAOImpl userDao = new UserDAOImpl();
		return userDao.registry(user);
	}

	public Map<String, Object> login(String email, String password) {
		Map<String, Object> map = new HashMap<>();
		UserDAOImpl userDao = new UserDAOImpl();
		User user = userDao.login(email, password);
		if (user != null) {
			if (BCrypt.checkpw(password, user.getPassWord())) {
				map.put("isLogin", true);
				map.put("role", user.getRole());
			} else {
				map.put("msg", "Sai mật khẩu !");
				map.put("isLogin", false);
			}
			;
		} else {
			map.put("msg", "Tài khoản không tồn tại !");
			map.put("isLogin", false);
		}
		return map;
	}

	public Map<String, Object> checkResetPassword(String email, String password) {
		Map<String, Object> map = new HashMap<>();
		UserDAOImpl userDao = new UserDAOImpl();
		User user = userDao.getUser(email);
		if (BCrypt.checkpw(password, user.getPassWord())) {
			map.put("isReset", true);
			map.put("msg", "Đổi thành công !");
		} else {
			map.put("msg", "Mật khẩu hiện tại không khớp !");
			map.put("isReset", false);
		}
		return map;
	}

	public boolean resetPassword(String email, String password) {
		UserDAOImpl userDao = new UserDAOImpl();
		return userDao.resetPassword(email, password);
	}

	public User getUser(String email) {
		UserDAOImpl userDao = new UserDAOImpl();
		return userDao.getUser(email);
	}

	public boolean setRoleUser(String email, String role) {
		UserDAOImpl userDao = new UserDAOImpl();
		return userDao.setRoleUser(email, role);
	}

	public Long thongKeUser() {
		UserDAOImpl userDao = new UserDAOImpl();
		Long tongUser = userDao.thongKeUser();
		return tongUser;
	}

	public List<User> getUserList() {
		UserDAOImpl userDao = new UserDAOImpl();
		return userDao.getListUser();
	}

	public List<User> getLectureList() {
		UserDAOImpl userDao = new UserDAOImpl();
		return userDao.getListLecture();
	}

	public List<User> getStudenList() {
		UserDAOImpl userDao = new UserDAOImpl();
		return userDao.getListStudent();
	}

}
