package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReserveDao;
import entity.Reserve;
import service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService{

	@Autowired
	ReserveDao reserveDao;
	public List<Reserve> getAll(String where, String limit) {
		// TODO Auto-generated method stub
		return reserveDao.getAll(where,limit);
	}
	public List<Reserve> selectAll() {
		// TODO Auto-generated method stub
		return reserveDao.selectAll();
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return reserveDao.delete(id);
	}
	public int insert(Reserve o) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		o.setCreatedate(dateStr);
		return reserveDao.insert(o);
	}
	public Reserve getById(int id) {
		// TODO Auto-generated method stub
		return reserveDao.getById(id);
	}
	public int update(Reserve o) {
		// TODO Auto-generated method stub
		return reserveDao.update(o);
	}
	public int selectCount(String where) {
		// TODO Auto-generated method stub
		return reserveDao.selectCount(where);
	}
}
