package service;

import java.util.List;

import entity.Order;

public interface OrderService {

	public List<Order> getAll(String where,String limit);
	public List<Order> selectAll();
	public int delete(int id);
	public int insert(Order o);
	public Order getById(int id);
	public int update(Order o);
	public int selectCount(String where);
	//以下为业务
	public Order getByClientId(int clientid);
}
