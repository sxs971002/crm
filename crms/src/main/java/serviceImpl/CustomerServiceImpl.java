package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import entity.Customer;
import service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	public List<Customer> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return customerDao.getAll(where,limit);
	}
	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		return customerDao.selectAll();
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return customerDao.delete(id);
	}
	public int insert(Customer u) {
		// TODO Auto-generated method stub
		return customerDao.insert(u);
	}
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getById(id);
	}
	public int update(Customer u) {
		// TODO Auto-generated method stub
		return customerDao.update(u);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return customerDao.selectCount(where);
	}
}
