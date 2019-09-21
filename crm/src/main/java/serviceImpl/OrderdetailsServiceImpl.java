package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderdetailsDao;
import entity.Orderdetails;
import service.OrderdetailsService;

@Service
public class OrderdetailsServiceImpl implements OrderdetailsService{

	@Autowired
	OrderdetailsDao orderdetailsDao;
	public List<Orderdetails> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return orderdetailsDao.getAll(where,limit);
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return orderdetailsDao.delete(id);
	}
	public int insert(Orderdetails o) {
		// TODO Auto-generated method stub
		return orderdetailsDao.insert(o);
	}
	public Orderdetails getById(int id) {
		// TODO Auto-generated method stub
		return orderdetailsDao.getById(id);
	}
	public int update(Orderdetails o) {
		// TODO Auto-generated method stub
		return orderdetailsDao.update(o);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return orderdetailsDao.selectCount(where);
	}
}
