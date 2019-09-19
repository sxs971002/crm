package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RevisitDao;
import entity.Revisit;
import service.RevisitService;

@Service
public class RevisitServiceImpl implements RevisitService{

	@Autowired
	RevisitDao revisitDao;
	public List<Revisit> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return revisitDao.getAll(where,limit);
	}
	public List<Revisit> selectAll() {
		// TODO Auto-generated method stub
		return revisitDao.selectAll();
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return revisitDao.delete(id);
	}
	public int insert(Revisit c) {
		// TODO Auto-generated method stub
		return revisitDao.insert(c);
	}
	public Revisit getById(int id) {
		// TODO Auto-generated method stub
		return revisitDao.getById(id);
	}
	public int update(Revisit c) {
		// TODO Auto-generated method stub
		return revisitDao.update(c);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return revisitDao.selectCount(where);
	}
}
