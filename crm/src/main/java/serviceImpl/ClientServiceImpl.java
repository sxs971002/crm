package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		c.setCreatedate(dateStr);
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
	
	//以下为业务
	public List<Client> getNoappoint(String where, String limit) {
		// TODO Auto-generated method stub
		return clientDao.getNoappoint(where,limit);
	}
	public List<Client> getMyunexecuted(String where, String limit) {
		// TODO Auto-generated method stub
		return clientDao.getMyunexecuted(where,limit);
	}
	public int remove(Client u) {
		// TODO Auto-generated method stub
		return clientDao.remove(u);
	}
	public Client getAllById(int clientid) {
		// TODO Auto-generated method stub
		return clientDao.getAllById(clientid);
	}
	public List<Client> getMyexecuted(String where, String limit) {
		// TODO Auto-generated method stub
		return clientDao.getMyexecuted(where,limit);
	}
}
