package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SrcDao;
import entity.Src;
import service.SrcService;


@Service
public class SrcServiceImpl implements SrcService{

	@Autowired
	SrcDao srcDao;
	public List<Src> getAll(String where,String limit) {
		// TODO Auto-generated method stub
		return srcDao.getAll(where,limit);
	}
	
	public int delete(int id) {
		// TODO Auto-generated method stub
		return srcDao.delete(id);
	}
	public int insert(Src s) {
		// TODO Auto-generated method stub
		return srcDao.insert(s);
	}
	public Src selectById(int id) {
		// TODO Auto-generated method stub
		return srcDao.getById(id);
	}
	public int update(Src s) {
		// TODO Auto-generated method stub
		return srcDao.update(s);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return srcDao.selectCount(where);
	}
}
