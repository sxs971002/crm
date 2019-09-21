package service;

import java.util.List;

import entity.Product;

public interface ProductService {
	
	public List<Product> getAll(String where,String limit);
	public int delete(int id);
	public int insert(Product p);
	public Product selectById(int id);
	public int update(Product p);
	public int selectCount(String where);
}
