package service;

import java.util.List;

import entity.Workgroup;

public interface WorkgroupService {

	public List<Workgroup> getAll(String where,String limit);
	public int delete(int id);
	public int insert(Workgroup w);
	public Workgroup selectById(int id);
	public int update(Workgroup w);
	public int selectCount(String where);
}
