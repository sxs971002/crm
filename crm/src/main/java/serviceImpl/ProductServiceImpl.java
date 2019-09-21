package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import entity.Product;
import service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	public List<Product> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return productDao.getAll(where,limit);
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}
	public int insert(Product u) {
		// TODO Auto-generated method stub
		return productDao.insert(u);
	}
	public Product selectById(int id) {
		// TODO Auto-generated method stub
		return productDao.getById(id);
	}
	public int update(Product u) {
		// TODO Auto-generated method stub
		return productDao.update(u);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return productDao.selectCount(where);
	}
}
