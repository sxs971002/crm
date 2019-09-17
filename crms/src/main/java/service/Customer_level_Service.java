package service;

import java.util.List;

import entity.Customer_level;

public interface Customer_level_Service {

	public List<Customer_level> getAll(String where,String limit);
	public List<Customer_level> selectAll();
	public int delete(int id);
	public int insert(Customer_level cl);
	public Customer_level getById(int id);
	public int update(Customer_level cl);
	public int selectCount(String where);
}
