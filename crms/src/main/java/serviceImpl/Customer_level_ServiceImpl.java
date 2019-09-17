package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Customer_level_Dao;
import entity.Customer_level;
import service.Customer_level_Service;

@Service
public class Customer_level_ServiceImpl implements Customer_level_Service{

	@Autowired
	Customer_level_Dao clDao;
	public List<Customer_level> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return clDao.getAll(where,limit);
	}
	public List<Customer_level> selectAll() {
		// TODO Auto-generated method stub
		return clDao.selectAll();
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return clDao.delete(id);
	}
	public int insert(Customer_level u) {
		// TODO Auto-generated method stub
		return clDao.insert(u);
	}
	public Customer_level getById(int id) {
		// TODO Auto-generated method stub
		return clDao.getById(id);
	}
	public int update(Customer_level u) {
		// TODO Auto-generated method stub
		return clDao.update(u);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return clDao.selectCount(where);
	}
}
