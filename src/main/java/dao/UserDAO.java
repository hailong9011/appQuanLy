package dao;

import java.util.List;

import entity.User;

public interface UserDAO {

	public User registry(User user);

	public boolean setRoleUser(String email, String role);

	public boolean resetPassword(String email, String password);

	public User login(String emai, String password);

	public User getUser(String email);

	public List<User> getListUser();

	public Long thongKeUser();
}
