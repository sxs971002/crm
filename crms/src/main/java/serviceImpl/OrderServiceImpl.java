package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderDao;
import entity.Order;
import service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	public List<Order> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return orderDao.getAll(where,limit);
	}
	public List<Order> selectAll() {
		// TODO Auto-generated method stub
		return orderDao.selectAll();
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return orderDao.delete(id);
	}
	public int insert(Order o) {
		// TODO Auto-generated method stub
		return orderDao.insert(o);
	}
	public Order getById(int id) {
		// TODO Auto-generated method stub
		return orderDao.getById(id);
	}
	public int update(Order o) {
		// TODO Auto-generated method stub
		return orderDao.update(o);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return orderDao.selectCount(where);
	}
}
