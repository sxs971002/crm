package service;

import java.util.List;

import entity.Reserve;

public interface ReserveService {

	public List<Reserve> getAll(String where,String limit);
	public List<Reserve> selectAll();
	public int delete(int id);
	public int insert(Reserve o);
	public Reserve getById(int id);
	public int update(Reserve r);
	public int selectCount(String where);
	public List<Reserve> getMyreserved(String where, String lim);
	public int updatepool(Reserve r);
}
