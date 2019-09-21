package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Client_type_Dao;
import entity.Client_type;
import service.Client_type_Service;


@Service
public class Client_type_ServiceImpl implements Client_type_Service{

	@Autowired
	Client_type_Dao ctDao;
	public List<Client_type> getAll(String where,String limit) {
		// TODO Auto-generated method stub
		return ctDao.getAll(where,limit);
	}
	
	public int delete(int id) {
		// TODO Auto-generated method stub
		return ctDao.delete(id);
	}
	public int insert(Client_type w) {
		// TODO Auto-generated method stub
		return ctDao.insert(w);
	}
	public Client_type selectById(int id) {
		// TODO Auto-generated method stub
		return ctDao.getById(id);
	}
	public int update(Client_type w) {
		// TODO Auto-generated method stub
		return ctDao.update(w);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return ctDao.selectCount(where);
	}
}
