package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientDao;
import entity.Client;
import service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientDao clientDao;
	public List<Client> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return clientDao.getAll(where,limit);
	}
	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		return clientDao.selectAll();
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return clientDao.delete(id);
	}
	public int insert(Client c) {
		// TODO Auto-generated method stub
		return clientDao.insert(c);
	}
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return clientDao.getById(id);
	}
	public int update(Client c) {
		// TODO Auto-generated method stub
		return clientDao.update(c);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return clientDao.selectCount(where);
	}
}
