package service;

import java.util.List;

import entity.Orderdetails;

public interface OrderdetailsService {

	public List<Orderdetails> getAll(String where,String limit);
	public int delete(int id);
	public int insert(Orderdetails o);
	public Orderdetails getById(int id);
	public int update(Orderdetails o);
	public int selectCount(String where);
}
