package dao;

import java.util.List;

import entity.User;

public interface UserDAO {

	public User registry(User user);

	public User login(String emai, String password);

	public boolean resetPassword(String email, String password);

	public boolean setRoleUser(String email, String role);

	public User getUser(String email);

	public List<User> getListUser();

	public List<User> getListLecture();

	public List<User> getListStudent();

	public Long thongKeUser();
}
