package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WorkgroupDao;
import entity.Workgroup;
import service.WorkgroupService;


@Service
public class WorkgroupServiceImpl implements WorkgroupService{

	@Autowired
	WorkgroupDao groupDao;
	public List<Workgroup> getAll(String where,String limit) {
		// TODO Auto-generated method stub
		return groupDao.getAll(where,limit);
	}
	
	public int delete(int id) {
		// TODO Auto-generated method stub
		return groupDao.delete(id);
	}
	public int insert(Workgroup w) {
		// TODO Auto-generated method stub
		return groupDao.insert(w);
	}
	public Workgroup selectById(int id) {
		// TODO Auto-generated method stub
		return groupDao.getById(id);
	}
	public int update(Workgroup w) {
		// TODO Auto-generated method stub
		return groupDao.update(w);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return groupDao.selectCount(where);
	}
}
