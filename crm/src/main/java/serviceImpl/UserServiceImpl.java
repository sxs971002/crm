package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public User login(User u) {
		return userDao.login(u);
	}
	public List<User> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return userDao.getAll(where,limit);
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}
	public int insert(User u) {
		// TODO Auto-generated method stub
		return userDao.insert(u);
	}
	public User selectById(int id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}
	public int update(User u) {
		// TODO Auto-generated method stub
		return userDao.update(u);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return userDao.selectCount(where);
	}
	public User selectByTel(String tel) {
		// TODO Auto-generated method stub
		return userDao.selectByTel(tel);
	}
	public int passedit(String newpass, int id) {
		// TODO Auto-generated method stub
		return userDao.passedit(newpass,id);
	}
}
