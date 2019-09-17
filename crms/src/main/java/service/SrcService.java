package service;

import java.util.List;

import entity.Src;

public interface SrcService {

	public List<Src> getAll(String where,String limit);
	public int delete(int id);
	public int insert(Src s);
	public Src selectById(int id);
	public int update(Src s);
	public int selectCount(String where);
}
