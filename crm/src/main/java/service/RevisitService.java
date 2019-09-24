package service;

import java.util.List;

import entity.Revisit;

public interface RevisitService {

	public List<Revisit> getAll(String where,String limit);
	public List<Revisit> selectAll();
	public int delete(int id);
	public int insert(Revisit c);
	public Revisit getById(int id);
	public int update(Revisit c);
	public int selectCount(String where);
	public List<Revisit> getMyrevisit(String where, String lim);
}
