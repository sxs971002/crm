package service;

import java.util.List;

import entity.Customer;

public interface CustomerService {

	public List<Customer> getAll(String where,String limit);
	public List<Customer> selectAll();
	public int delete(int id);
	public int insert(Customer c);
	public Customer getById(int id);
	public int update(Customer c);
	public int selectCount(String where);
}
