package service;

import java.util.List;

import entity.User;

public interface UserService {
	
	public User login(User u);
	public List<User> getAll(String where,String limit);
	public int delete(int id);
	public int insert(User u);
	public User selectById(int id);
	public int update(User u);
	public int selectCount(String where);
	public User selectByTel(String tel);
	public int passedit(String newpass, int id);
}
