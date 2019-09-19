package service;

import java.util.List;

import entity.Reserve;

public interface ReserveService {

	public List<Reserve> getAll(String where,String limit);
	public List<Reserve> selectAll();
	public int delete(int id);
	public int insert(Reserve o);
	public Reserve getById(int id);
	public int update(Reserve o);
	public int selectCount(String where);
}
